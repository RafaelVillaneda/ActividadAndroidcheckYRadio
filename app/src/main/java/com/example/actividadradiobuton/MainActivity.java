package com.example.actividadradiobuton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RadioButton radioDecimal,radioBinario,radioOctal,radioHexa;
    CheckBox checkBinario,checkOctal,checkHexa;
    TextView cajaNumeroIngresado,cajaResOctal,cajaResBinario,CajaresHexa;
    int numeroIngresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioDecimal=findViewById(R.id.radioDecimal);
        radioBinario=findViewById(R.id.radioBinario);
        radioOctal=findViewById(R.id.radioOctal);
        radioHexa=findViewById(R.id.radioHexa);

        checkBinario=findViewById(R.id.checkBinario);
        checkOctal=findViewById(R.id.checkOctal);
        checkHexa=findViewById(R.id.checkHexa);

        cajaNumeroIngresado=findViewById(R.id.cajaNumeroIngresado);
        cajaResBinario=findViewById(R.id.cajaResultadoBinario);
        cajaResOctal=findViewById(R.id.cajaResultadoOctal);
        CajaresHexa=findViewById(R.id.cajaResultadoHexa);

    }

    @Override
    public void onClick(View v) {

        boolean checked = ((RadioButton) v).isChecked();
        boolean checked2=((CheckBox) v).isChecked();

        switch (v.getId()){
            case R.id.radioDecimal:
                if (checked)
                    Toast.makeText(this, "Decimal", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioBinario:
                System.out.println("Se selecciono radio Binario");
                break;
            case R.id.radioHexa:
                System.out.println("Se selecciono radio Hexa");
                break;
            case R.id.radioOctal:
                System.out.println("Se selecciono radio Octal");
                break;

            default:

        }


    }
    public long decimalABinario(int decimal) {
        long binario = 0;
        int digito;
        final int DIVISOR = 2;
        for (int i = decimal, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = i % DIVISOR;
            binario += digito * Math.pow(10, j);
        }
        return binario;
    }
}