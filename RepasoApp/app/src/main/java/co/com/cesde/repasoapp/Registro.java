package co.com.cesde.repasoapp;

import androidx.appcompat.app.AppCompatActivity;

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

    // 1. Crear los objetos de los componentes xml

    EditText inputId;
    EditText inputNombre;
    EditText inputApellido;
    EditText inputTelefono;
    EditText inputCorreo;
    EditText inputClave;
    EditText inputSaldo;
    Button btnCrearUsuario;
    Button btnVolver_desde_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // 2. Mapear los objetos con los componentes

        inputId = findViewById(R.id.input_id);
        inputNombre = findViewById(R.id.input_nombre);
        inputApellido = findViewById(R.id.input_apellido);
        inputTelefono = findViewById(R.id.input_telefono);
        inputCorreo = findViewById(R.id.input_correo);
        inputClave = findViewById(R.id.input_clave);
        inputSaldo = findViewById(R.id.input_saldo);
        btnCrearUsuario = findViewById(R.id.btn_crear_usuario);
        btnVolver_desde_reg = findViewById(R.id.btn_volver_desde_reg);

        //3. Crear el evento desde los botones

        btnVolver_desde_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverInicio();
            }
        });

        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrarUsuario();

            }
        });
    }


    public void volverInicio(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void registrarUsuario(){

        String telefono = inputTelefono.getText().toString();

        DatabaseReference nuevoUsuario = reference.child(String.valueOf(telefono));

        int id = Integer.parseInt(inputId.getText().toString());
        nuevoUsuario.child("Id").setValue(id);
        String nombre = inputNombre.getText().toString();
        nuevoUsuario.child("Nombre").setValue(nombre);
        String apellido = inputApellido.getText().toString();
        nuevoUsuario.child("Apellido").setValue(apellido);
        String telefonoUsuario = inputTelefono.getText().toString();
        nuevoUsuario.child("Telefono").setValue(telefonoUsuario);
        String correo = inputCorreo.getText().toString();
        nuevoUsuario.child("Correo").setValue(correo);
        String clave = inputClave.getText().toString();
        nuevoUsuario.child("Clave").setValue(clave);

        double saldo = 0;

        nuevoUsuario.child("Saldo").setValue(saldo);

        Toast.makeText(getApplicationContext(),"El usuario se ha creado correctamente", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}