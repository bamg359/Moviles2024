package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btnIrHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnIrHome = findViewById(R.id.btn_ir_inicio);

        btnIrHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
            }
        });


    }

    public void irHome(){

        Intent intent = new Intent(this, Home.class);

        startActivity(intent);
    }
}