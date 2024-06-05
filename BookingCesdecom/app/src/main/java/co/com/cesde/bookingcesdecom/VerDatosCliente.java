package co.com.cesde.bookingcesdecom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VerDatosCliente extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference reference = database.getReference().child("Clientes");


    TextView txtVerId;
    TextView txtVerNOmbreUsuario;
    TextView txtVerApellidoUsuario;
    TextView txtVerTelefonoUsuario;
    TextView txtVerCorreoUsuario;
    TextView txtVerContrasena;

    Button btnConsultarUsuario;
    Button btnVolverDashboard;

    EditText inputIdUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_cliente);





    }


    public void verDatosCliente(){

        //String id =



    }



}