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
    byte checkSelec;

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

        cajaResBinario.setEnabled(false);
        cajaResOctal.setEnabled(false);
        CajaresHexa.setEnabled(false);

    }
    public void checkSelecy(View v){
        if(v.getId()==R.id.checkBinario){
            checkSelec=1;
        }else if (v.getId()==R.id.checkOctal){
            checkSelec=2;
        }else{
            checkSelec=3;
        }
    }

    @Override
    public void onClick(View v) {

        boolean checked = ((RadioButton) v).isChecked();
       // boolean checked2=((CheckBox) v).isChecked();

        switch (v.getId()){
            case R.id.radioBinario:

                Toast.makeText(this, "BINARIO", Toast.LENGTH_LONG).show();
                cajaNumeroIngresado.setText("457");

                break;
            case R.id.radioDecimal:
                System.out.println("Se selecciono radio Decimal");
                if(cajaNumeroIngresado.getText().toString().isEmpty()){
                    numeroIngresado=0;
                    cajaNumeroIngresado.setText("0");
                }else{
                    numeroIngresado=Integer.parseInt(cajaNumeroIngresado.getText().toString());
                    System.out.println("Casi entro-->"+checkBinario.isActivated());
                    if(checkSelec==1){
                        System.out.println("Entre");
                        long resultado=decimalABinario(numeroIngresado);
                        cajaResBinario.setText(resultado+"");
                    }
                }
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