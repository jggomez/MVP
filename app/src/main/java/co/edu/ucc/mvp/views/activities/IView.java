package co.edu.ucc.mvp.views.activities;

/**
 * Created by jggomez on 09-Mar-18.
 */

public interface IView {

    void mostrarLoading();

    void ocultarLoading();

    void onClickSumar();

    void mostrarError(String msg);

    void mostrarResultadoSuma(int resultSuma);


}
