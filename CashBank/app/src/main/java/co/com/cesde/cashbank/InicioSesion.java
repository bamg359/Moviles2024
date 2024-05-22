package co.com.cesde.cashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {





    EditText inputCorreoCLiente;
    EditText inputClaveCliente;
    Button btnIniciarSesion;

    Button btnVolverInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnIniciarSesion = findViewById(R.id.btn_iniciar);
        btnVolverInicio = findViewById(R.id.btn_volver_inicio);


        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDasboard();
            }
        });

        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInicio();
            }
        });


    }




    public void irDasboard(){

        Intent intent = new Intent(this, DashBoardCliente.class);
        startActivity(intent);
    }

    public void irInicio(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}