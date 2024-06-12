package co.com.cesde.cashbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InicioSesion extends AppCompatActivity {





    EditText inputCorreoCLiente;
    EditText inputClaveCliente;
    Button btnIniciarSesion;
    Button btnVolverInicio;

    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnIniciarSesion = findViewById(R.id.btn_iniciar);
        btnVolverInicio = findViewById(R.id.btn_volver_inicio);
        inputCorreoCLiente = findViewById(R.id.input_correo_cliente);
        inputClaveCliente = findViewById(R.id.input_clave_cliente);




        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = inputCorreoCLiente.getText().toString();
                String clave = inputClaveCliente.getText().toString();

                iniciarSesion(correo, clave);
            }
        });

        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irInicio();
            }
        });


    }



    public void iniciarSesion(String correo, String clave){

        auth.signInWithEmailAndPassword(correo, clave)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            irDasboard();
                            Toast.makeText(InicioSesion.this,"Logeado correctamente", Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(InicioSesion.this,"Valide sus credenciales", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }




    public void irDasboard(){

        Intent intent = new Intent(InicioSesion.this, DashBoardCliente.class);
        startActivity(intent);
        finish();
    }

    public void irInicio(){

        Intent intent = new Intent(InicioSesion.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}