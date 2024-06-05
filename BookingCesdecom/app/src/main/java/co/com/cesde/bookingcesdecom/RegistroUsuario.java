package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroUsuario extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("Clientes");

    Button btnRegistrarUsuario;
    Button btnVolverHomeFromRegistro;

    EditText idUsuario;
    EditText nombreUsuario;
    EditText apellidoUsuario;
    EditText telUsuario;
    EditText correo;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        idUsuario = findViewById(R.id.input_id_cliente);
        nombreUsuario = findViewById(R.id.input_nombre_usuario);
        apellidoUsuario = findViewById(R.id.input_apellido);
        telUsuario = findViewById(R.id.input_Telefono_usuario);
        correo = findViewById(R.id.input_correo);
        password = findViewById(R.id.input_password);

        btnRegistrarUsuario = findViewById(R.id.btn_registrar_usuario);

        btnVolverHomeFromRegistro = findViewById(R.id.btn_ir_home_from_registro);

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCliente();
            }
        });


        btnVolverHomeFromRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverHome();
            }
        });




    }


    public void volverHome(){

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void registrarCliente(){

        String idCliente = idUsuario.getText().toString();

        DatabaseReference nuevoCliente = reference.child(String.valueOf(idCliente));

        String nombreCliente = nombreUsuario.getText().toString();

        nuevoCliente.child("Nombre").setValue(nombreCliente);

        String apellidoCliente = apellidoUsuario.getText().toString();

        nuevoCliente.child("Apellido").setValue(apellidoCliente);

        String telefonoCliente = telUsuario.getText().toString();

        nuevoCliente.child("Telefono").setValue(telefonoCliente);

        String correoCliente = correo.getText().toString();

        nuevoCliente.child("Correo").setValue(correoCliente);

        String contrasena =  password.getText().toString();

        nuevoCliente.child("contraseña").setValue(contrasena);

        Toast.makeText(getApplicationContext(), "Se registro correctamente el usuario", Toast.LENGTH_LONG).show();


    }


}