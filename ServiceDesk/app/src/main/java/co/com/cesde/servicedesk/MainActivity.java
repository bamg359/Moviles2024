package co.com.cesde.servicedesk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    Button btnIrRegistro;

    Button btnIrInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrRegistro = findViewById(R.id.btn_registro);

        btnIrRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irRegistro();
            }
        });


    }

    public void irRegistro(){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}