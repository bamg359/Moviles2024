package co.com.cesde.cashbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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

    FirebaseAuth auth = FirebaseAuth.getInstance();

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

        registroFireBaseAuth(correo, clave);

        Toast.makeText(getApplicationContext(),"Registro Creado", Toast.LENGTH_LONG).show();
    }

    public void registroFireBaseAuth(String correo, String clave){

        auth.createUserWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Registro.this, "Cuenta Creada Correctamente", Toast.LENGTH_LONG).show();

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Registro.this, "La cuenta no fue creada correctamente", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }





}