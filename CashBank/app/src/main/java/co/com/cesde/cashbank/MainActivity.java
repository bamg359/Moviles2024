package co.com.cesde.cashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    Button btnIrRegistro;
    Button btnIrInicioSesion;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrRegistro = findViewById(R.id.btn_registro);

        btnIrInicioSesion = findViewById(R.id.btn_inicio);




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

        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void irInicioSesion(){

        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    }


}