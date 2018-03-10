package co.edu.ucc.mvp.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.mvp.R;
import co.edu.ucc.mvp.views.presenters.IPresenter;
import co.edu.ucc.mvp.views.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.txtNum1)
    EditText txtNum1;

    @BindView(R.id.txtNum2)
    EditText txtNum2;

    @BindView(R.id.btnSumar)
    Button btnSumar;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
    }

    @Override
    public void mostrarLoading() {
        //progress mostrar
        Log.i("MainActivity", "Mostrando Loading");
    }

    @Override
    public void ocultarLoading() {
        //progress ocultar
        Log.i("MainActivity", "Ocultando Loading");
    }

    @OnClick(R.id.btnSumar)
    public void onClickSumar() {
        int num1 = Integer.parseInt(txtNum1.getText().toString());
        int num2 = Integer.parseInt(txtNum2.getText().toString());

        presenter.sumar(num1, num2);
    }

    @Override
    public void mostrarError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarResultadoSuma(int resultSuma) {
        Toast.makeText(this,
                "La suma es:" + resultSuma, Toast.LENGTH_SHORT).show();
    }

}
