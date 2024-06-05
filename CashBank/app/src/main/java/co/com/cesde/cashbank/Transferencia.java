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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Transferencia extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("Usuarios");


    EditText telOrigen;
    EditText telDestino;
    EditText cantidad;
    TextView txtTelOrigen;
    TextView txtCantidad;
    Button btnTransferir;
    Button btnVolver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        telOrigen = findViewById(R.id.input_tel_origen);
        telDestino = findViewById(R.id.input_tel_destino);
        cantidad = findViewById(R.id.input_cantidad);

        txtTelOrigen = findViewById(R.id.txt_origen);
        txtCantidad = findViewById(R.id.txt_cantidad);

        btnTransferir = findViewById(R.id.btn_transferir);
        btnVolver = findViewById(R.id.btn_volver_dash2);


        btnTransferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recargarCuenta();
            }
        });





    }



    public void enviarRecursos(){


    }


    public void recargarCuenta(){

        String telefono = telDestino.getText().toString();

        double montoRecibido = Double.parseDouble(cantidad.getText().toString());

        DatabaseReference saldoRef = reference.child(telefono).child("Saldo");

        saldoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    double saldoActual= snapshot.getValue(Double.class);
                    double nuevoSaldo = saldoActual + montoRecibido;

                    saldoRef.setValue(nuevoSaldo).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "El saldo se actualizó exitosamente", Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "El saldo no se actualizó", Toast.LENGTH_LONG).show();
                        }
                    });

                }else{
                    Toast.makeText(getApplicationContext(), "El usuario no poseé cuenta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











    }


    public void volverDashboard(){


        Intent intent  = new Intent(this, DashBoardCliente.class);

        startActivity(intent);
    }







}