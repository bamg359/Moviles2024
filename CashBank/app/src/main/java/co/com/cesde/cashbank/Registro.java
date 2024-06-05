package co.com.cesde.cashbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Usuarios");

    Button btnRegistrar;

    Button btnCancelarReg;

    EditText inputTel;

    EditText inputNombre;

    EditText inputCorreo;

    EditText inputClave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        btnCancelarReg = findViewById(R.id.btn_cancelar);
        btnRegistrar = findViewById(R.id.btn_registrar);
        inputTel = findViewById(R.id.input_tel_id);
        inputNombre = findViewById(R.id.input_nombre);
        inputCorreo = findViewById(R.id.input_correo);
        inputClave = findViewById(R.id.input_password);

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

        DatabaseReference nuevoUsuario = reference.child(String.valueOf(tel));

        nuevoUsuario.child("Tel: ").setValue(tel);

        String nombre = inputNombre.getText().toString();
        nuevoUsuario.child("Nombre: ").setValue(nombre);
        String correo = inputCorreo.getText().toString();
        nuevoUsuario.child("Correo: ").setValue(correo);
        String clave = inputClave.getText().toString();
        nuevoUsuario.child("Clave: ").setValue(clave);

        double saldo = 0;

        nuevoUsuario.child("Saldo").setValue(saldo);

        Toast.makeText(getApplicationContext(),"Registro Creado", Toast.LENGTH_LONG).show();
    }
}