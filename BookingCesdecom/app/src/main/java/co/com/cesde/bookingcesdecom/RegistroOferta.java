package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegistroOferta extends AppCompatActivity {

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

    }
}