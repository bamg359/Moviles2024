package co.com.cesde.cashbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataCliente extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("Usuarios");

    EditText inputTel;
    TextView txtTel;
    TextView txtNombre;
    TextView txtCorreo;
    TextView txtClave;
    Button btnConsultar;
    Button btnVolverDash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cliente);

        inputTel = findViewById(R.id.input_tel_cliente);
        txtTel = findViewById(R.id.txt_tel_cliente);
        txtNombre = findViewById(R.id.txt_nombre);
        txtCorreo = findViewById(R.id.txt_correo);
        txtClave = findViewById(R.id.txt_clave);
        btnConsultar = findViewById(R.id.btn_consultar);
        btnVolverDash = findViewById(R.id.btn_volver_dash);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDataCliente();
            }
        });


        btnVolverDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverDash();
            }
        });


    }

    public void obtenerDataCliente(){

        String telefono = inputTel.getText().toString();

        DatabaseReference usuarioRef = reference.child(telefono);

        usuarioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    String tel = snapshot.child("Tel: ").getValue(String.class);
                    txtTel.setText("Tel" + tel);
                    String nombre = snapshot.child("Nombre: ").getValue(String.class);
                    txtNombre.setText("Nombre" + nombre);
                    String correo = snapshot.child("Correo: ").getValue(String.class);
                    txtCorreo.setText(correo);
                    String clave = snapshot.child("Clave: ").getValue(String.class);
                    txtClave.setText(clave);

                }else{

                    Toast.makeText(getApplicationContext(), "Usuario no existe" , Toast.LENGTH_LONG).show();
                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void volverDash(){

        Intent intent = new Intent(this, DashBoardCliente.class);
        startActivity(intent);
    }

}