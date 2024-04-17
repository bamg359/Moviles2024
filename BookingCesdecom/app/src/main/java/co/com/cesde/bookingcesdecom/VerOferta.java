package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VerOferta extends AppCompatActivity {


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


    }
}