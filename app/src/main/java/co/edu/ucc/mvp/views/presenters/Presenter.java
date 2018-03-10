package co.edu.ucc.mvp.views.presenters;

import co.edu.ucc.mvp.domain.IInteractorOperaciones;
import co.edu.ucc.mvp.domain.InteractorOperaciones;
import co.edu.ucc.mvp.views.activities.IView;

/**
 * Created by jggomez on 09-Mar-18.
 */

public class Presenter implements IPresenter {

    private IView view;
    private IInteractorOperaciones operaciones;

    public Presenter(IView view) {
        this.view = view;
        operaciones = new InteractorOperaciones();
    }

    @Override
    public void sumar(int a, int b) {
        try {
            view.mostrarLoading();
            int result = operaciones.sumar(a, b);
            view.ocultarLoading();
            view.mostrarResultadoSuma(result);
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }
}
