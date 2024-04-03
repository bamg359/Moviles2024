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

public class Registro extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Usuario");

    Button btnRegistrar;

    Button btnCancelarReg;

    EditText inputTel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        btnCancelarReg = findViewById(R.id.btn_cancelar);
        btnRegistrar = findViewById(R.id.btn_registrar);
        inputTel = findViewById(R.id.input_tel_id);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });

        btnCancelarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMain();
            }
        });

    }

    public void irMain(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void registrar(){



        String tel = inputTel.getText().toString();
        reference.child("Telefono").setValue(tel);



    }
}