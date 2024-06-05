package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {


    Button btnIrRegistro;
    Button btnIrInicioSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnIrRegistro = findViewById(R.id.btn_ir_registro);
        btnIrInicioSesion = findViewById(R.id.btn_ir_inicio_sesion);

        btnIrRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
            }
        });

        btnIrInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInicioSesion();
            }
        });
    }


    public void irRegistro(){

        Intent intent = new Intent(this, RegistroUsuario.class);

        startActivity(intent);
    }

    public void irInicioSesion(){

        Intent intent = new Intent(this, InicioSesion.class);

        startActivity(intent);
    }


}