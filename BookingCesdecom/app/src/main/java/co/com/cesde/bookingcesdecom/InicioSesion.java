package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {


    EditText inputPassUsuario;

    EditText inputCorreoUsuario;

    EditText inputTelUsuario;

    Button btnIniciarSesion;

    Button btnVolverHome2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        inputCorreoUsuario = findViewById(R.id.input_email_val);
        inputPassUsuario = findViewById(R.id.input_password_val);
        inputTelUsuario = findViewById(R.id.input_tel_val);
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        btnVolverHome2 = findViewById(R.id.btn_volver_home_from_inicio_sesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        btnVolverHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverHomefromInicioSesion();
            }
        });

    }

    public void iniciarSesion(){

        Intent intent= new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void volverHomefromInicioSesion(){

        Intent intent= new Intent(this, Home.class);
        startActivity(intent);
    }

}