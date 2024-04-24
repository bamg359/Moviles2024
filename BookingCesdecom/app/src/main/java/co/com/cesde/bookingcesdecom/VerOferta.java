package co.com.cesde.bookingcesdecom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import org.w3c.dom.Text;

public class VerOferta extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("oferta");


    EditText inputBuscarOferta;
    TextView txtVerCodigoOferta;
    TextView txtVerTituloOferta;
    TextView txtVerHotel;
    TextView txtVerAcomodacion;
    TextView txtVerPrecioPleno;
    TextView txtVerPrecioOferta;
    Button btnConsultarOferta;
    Button btnVolverDB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_oferta);

        inputBuscarOferta = findViewById(R.id.input_buscar_oferta);
        txtVerCodigoOferta = findViewById(R.id.txt_ver_id_oferta);
        txtVerTituloOferta = findViewById(R.id.txt_ver_titulo_oferta);
        txtVerHotel = findViewById(R.id.txt_ver_nombre_hotel);
        txtVerAcomodacion = findViewById(R.id.txt_ver_acomodacion);
        txtVerPrecioPleno = findViewById(R.id.txt_ver_precio_pleno);
        txtVerPrecioOferta = findViewById(R.id.txt_ver_precio_final);
        btnConsultarOferta = findViewById(R.id.btn_consultar_oferta);
        btnVolverDB = findViewById(R.id.btn_volver);

        btnConsultarOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verDatos();
            }
        });


        btnVolverDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverInicio();
            }
        });




    }

    public void verDatos(){


        String codOferta = inputBuscarOferta.getText().toString();
        //int codOfert = Integer.parseInt(codOferta);
        DatabaseReference ofertaRef = reference.child(codOferta);

        ofertaRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if( snapshot.exists()){
                    txtVerCodigoOferta.setText(codOferta);
                    String titOferta = snapshot.child("Nombre Oferta ").getValue(String.class);
                    txtVerTituloOferta.setText(titOferta);
                    String hotel = snapshot.child("Nombre Hotel ").getValue(String.class);
                    txtVerHotel.setText(hotel);
                    String acomodacion = snapshot.child("Acomodación ").getValue(String.class);
                    txtVerAcomodacion.setText(acomodacion);
                    double precioPleno = snapshot.child("Precio Pleno ").getValue(Double.class);
                    txtVerPrecioPleno.setText(String.valueOf(precioPleno));
                    double precioOferta = snapshot.child("Precio Final Oferta ").getValue(Double.class);
                    txtVerPrecioOferta.setText(String.valueOf(precioOferta));

                }else{

                    Toast.makeText(getApplicationContext(), "Oferta no existe", Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }


    public void volverInicio(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}