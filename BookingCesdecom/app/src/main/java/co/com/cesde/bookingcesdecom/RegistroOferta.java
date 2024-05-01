package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroOferta extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("oferta");

    EditText inputCodigoOferta;
    EditText inputTituloOferta;
    EditText inputNombreHotel;
    EditText inputAcomodacion;
    EditText inputPrecioPleno;
    EditText inputPorcentajeDesc;
    TextView txtPrecioPromo;
    ImageView imgOferta;
    Button btnCrearOferta;
    Button btnCancelarCrearOferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_oferta);

        inputCodigoOferta = findViewById(R.id.input_cod_oferta);
        inputTituloOferta = findViewById(R.id.input_titulo_oferta);
        inputNombreHotel = findViewById(R.id.input_hotel);
        inputAcomodacion = findViewById(R.id.input_acomodacion);
        inputPrecioPleno = findViewById(R.id.input_precio_pleno);
        inputPorcentajeDesc = findViewById(R.id.input_descuento);
        txtPrecioPromo = findViewById(R.id.txt_descuento);
        btnCrearOferta = findViewById(R.id.btn_crear_oferta);
        btnCancelarCrearOferta = findViewById(R.id.btn_cancelar);

        btnCrearOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarOferta();
            }
        });

        btnCancelarCrearOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelarCrearOferta();
            }
        });

    }

    public void registrarOferta(){

        int idReserva = Integer.parseInt( inputCodigoOferta.getText().toString());

        DatabaseReference nuevaOferta = reference.child(String.valueOf(idReserva));

        String tituloOferta = inputTituloOferta.getText().toString();

        nuevaOferta.child("Nombre Oferta ").setValue(tituloOferta);

        String nombreHotel = inputNombreHotel.getText().toString();

        nuevaOferta.child("Nombre Hotel ").setValue(nombreHotel);

        String acomodacion = inputAcomodacion.getText().toString();

        nuevaOferta.child("Acomodación ").setValue(acomodacion);

        double precioPleno = Double.parseDouble(inputPrecioPleno.getText().toString());

        nuevaOferta.child("Precio Pleno ").setValue(precioPleno);

        double porcertajeDescuento = Double.parseDouble(inputPorcentajeDesc.getText().toString());

        nuevaOferta.child("Porcentaje Descuento ").setValue(porcertajeDescuento);

        double precioOferta = precioPleno - (precioPleno*porcertajeDescuento);

        nuevaOferta.child("Precio Final Oferta ").setValue(precioOferta);

        String precioFinal = precioOferta + "";

        txtPrecioPromo.setText(precioFinal);

        Toast.makeText(getApplicationContext(), "Oferta Registrada" , Toast.LENGTH_LONG).show();


    }

    public void cancelarCrearOferta(){

        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}