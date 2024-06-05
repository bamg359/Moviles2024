package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroUsuario extends AppCompatActivity {

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

    }


    public void volverHome(){

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}