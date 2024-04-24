package co.com.cesde.repasoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnSumar;
    EditText inputDato1;
    EditText inputDato2;
    TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSumar = findViewById(R.id.btn_sumar);
        txtResultado = findViewById(R.id.txt_ver_dato);
        inputDato1 = findViewById(R.id.input_dato_1);
        inputDato2 = findViewById(R.id.input_dato_2);



        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dato1 = Integer.parseInt(inputDato1.getText().toString());
                int dato2 = Integer.parseInt(inputDato2.getText().toString());

                int resultadoSuma = sumar(dato1,dato2);

                String resultado = resultadoSuma + "";

                txtResultado.setText(resultado);
            }
        });


    }

    // Metodos propios

    public int sumar(int dato1 , int dato2){

        int resultSuma = dato1 + dato2;

        return resultSuma;
    }
}