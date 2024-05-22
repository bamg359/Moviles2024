package co.com.cesde.cashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashBoardCliente extends AppCompatActivity {


    TextView txtSaldo;
    Button btnVerDatos;
    Button btnVerMovimientos;
    Button btnIrTranferencias;
    Button btnIrRetiros;
    Button btnSalir;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_cliente);

        btnVerDatos = findViewById(R.id.btn_datos);

        btnSalir = findViewById(R.id.btn_salir);


        btnVerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDatosUsuario();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });


    }

    public void irDatosUsuario(){

        Intent intent = new Intent(this, DataCliente.class);
        startActivity(intent);
    }

    public void salir(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}