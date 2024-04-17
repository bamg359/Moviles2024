package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIrCrearOferta;

    Button btnIrReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrCrearOferta = findViewById(R.id.btn_creador_oferta);
        btnIrReserva = findViewById(R.id.btn_ir_reserva);
        btnIrCrearOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irCrearOferta();
            }
        });

        btnIrReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irReservar();
            }
        });



    }

    public void irCrearOferta(){

        Intent intent = new Intent(this, RegistroOferta.class);
        startActivity(intent);
    }


    public void irReservar(){
        Intent intent = new Intent(this, VerOferta.class);
        startActivity(intent);
    }

}