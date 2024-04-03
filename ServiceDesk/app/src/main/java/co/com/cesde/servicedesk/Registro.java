package co.com.cesde.servicedesk;

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
    DatabaseReference reference = database.getReference().child("user25");


    EditText inputId;
    EditText inputNombre;
    EditText inputApellido;
    EditText inputTelefono;
    EditText inputCorreo;
    EditText inputContrasena;
    Button btnRegistrar;
    Button btnCancelarReg;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inputId = findViewById(R.id.input_id);
        inputNombre = findViewById(R.id.input_nombre);
        inputApellido = findViewById(R.id.input_apellido);
        inputTelefono = findViewById(R.id.input_tel);
        inputCorreo = findViewById(R.id.input_correo);
        inputContrasena = findViewById(R.id.input_clave);

        btnRegistrar = findViewById(R.id.btn_registrar);
        btnCancelarReg = findViewById(R.id.btn_cancelar_reg);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });

        btnCancelarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelarRegistro();
            }
        });
    }

    public void registrarUsuario(){

        int id = Integer.parseInt(inputId.getText().toString());
        reference.child("id").setValue(id);
        String nombre = inputNombre.getText().toString();
        reference.child("nombre").setValue(nombre);
        String apellido = inputApellido.getText().toString();
        reference.child("apellido").setValue(apellido);
        String telefono = inputTelefono.getText().toString();
        reference.child("telefono").setValue(telefono);
        String correo = inputCorreo.getText().toString();
        reference.child("correo").setValue(correo);
        String contrasena = inputContrasena.getText().toString();
        reference.child("contrasena").setValue(contrasena);

        Toast.makeText(getApplicationContext(), "Datos registrados", Toast.LENGTH_LONG).show();

    }

    public void cancelarRegistro(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}