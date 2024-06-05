package co.com.cesde.cashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DashBoardCliente extends AppCompatActivity {


    TextView txtSaldo;
    ImageButton btnIrData;
    ImageButton btnVerMovimientos;
    ImageButton btnIrTranferencias;
    ImageButton btnIrRetiros;
    Button btnSalir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_cliente);

        btnIrData = findViewById(R.id.bnt_ir_datos);

        btnSalir = findViewById(R.id.btn_salir);

        btnIrTranferencias = findViewById(R.id.btn_transferir);

        btnIrData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDatosUsuario();
            }
        });

        btnIrTranferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irTranferencias();
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

    public void irTranferencias(){

        Intent intent = new Intent(this, Transferencia.class);
        startActivity(intent);
    }

    public void salir(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}