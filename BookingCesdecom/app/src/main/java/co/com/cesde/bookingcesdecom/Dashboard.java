package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {


    ImageButton btnIrDatosUsuario;
    ImageButton btnIrVerOferta;
    ImageButton btnIrReservas;
    ImageButton btnIrCrearOferta;

    Button btnSalir;

    TextView txtVerNombreUsuario;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnIrDatosUsuario = findViewById(R.id.btn_ir_ver_clientes);
        btnIrVerOferta = findViewById(R.id.btn_ir_ver_ofertas);
        btnIrReservas = findViewById(R.id.btn_ir_reservas);
        btnIrCrearOferta = findViewById(R.id.btn_crear_oferta);

        btnSalir = findViewById(R.id.btn_cerrar_sesion);

        txtVerNombreUsuario = findViewById(R.id.txt_ver_nombre_usuario);


        btnIrDatosUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVerDatosUsuario();
            }
        });


        btnIrVerOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVerOferta();
            }
        });

        btnIrCrearOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistrarOferta();
            }
        });

        btnIrReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irCatalogoOferta();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

    }


    public void cerrarSesion(){

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void irRegistrarOferta(){

        Intent intent = new Intent(this, RegistroOferta.class);
        startActivity(intent);
    }

    public void irVerDatosUsuario(){

        Intent intent = new Intent(this, VerDatosCliente.class);
        startActivity(intent);
    }

    public void irVerOferta(){

        Intent intent = new Intent(this, VerOferta.class);
        startActivity(intent);
    }

    public void irCatalogoOferta(){

        Intent intent = new Intent(this, CatalogoOferta.class);
        startActivity(intent);
    }









}