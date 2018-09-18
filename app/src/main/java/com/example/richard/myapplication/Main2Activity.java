package com.example.richard.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    int i=0;
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button aceptar = (Button)findViewById(R.id.Aceptar1);

        aceptar.setOnClickListener(this);

    }


    boolean checaTFCRC(View view,EditText IngETX,String DatETX) {
        for (int j = 0; j < IngETX.length(); j++) {
            if (DatETX.toCharArray()[j]=='1'||DatETX.toCharArray()[j]=='0') {
                System.out.println("Iteracion: "+j);
                if(j+1==IngETX.length()){
                    return true;
                }
            }
        }

        Toast mensaje = Toast.makeText(getApplicationContext(),"Por favor agrega valores",Toast.LENGTH_LONG);
        mensaje.show();
        return false;
    }


    boolean checaTF(View view,EditText IngETX,String DatETX) {
        for (int j = 0; j < IngETX.length(); j++) {
            if (DatETX.toCharArray()[j]=='1'||DatETX.toCharArray()[j]=='0') {
                if(j+1==IngETX.length()){
                    return true;
                }
            }
        }

        Toast mensaje = Toast.makeText(getApplicationContext(),"Introdusca valores Correctos Tonto :v",Toast.LENGTH_LONG);
        mensaje.show();
        return false;
    }

    public String BinCRC(View view){
        String val=" ";
        EditText IngCRC=(EditText)findViewById(R.id.IngCRC);
        String DatCRC = IngCRC.getText().toString();
        boolean a=checaTFCRC(view,IngCRC,DatCRC);
        if(IngCRC.getText().toString().length()==16) {
            //
            if(a){
                int dec = Integer.parseInt(DatCRC, 2);
                val = Integer.toHexString(dec).toUpperCase();
            }else{
                val="00";
            }
        }
        else{
            //IngCRC.setText("0000000000000000");
        }
        return val;
    }

    public String BinETX(View view) {
        String val = " ";
        String cade;
        EditText IngETX = (EditText) findViewById(R.id.IngETX);
        String DatETX = IngETX.getText().toString();
        boolean a = checaTF(view, IngETX, DatETX);
        if(IngETX.getText().toString().length()==8) {
            if (a) {
                int dec = Integer.parseInt(DatETX, 2);
                val = Integer.toHexString(dec).toUpperCase();
            } else {
                val = "00";
            }
        }
        else{
            IngETX.setText("");
        }

    return val;
    }

    public String BinCabecera(View view){
        String val=" ";
        EditText IngCabecera=(EditText)findViewById(R.id.IngCabecera);
        String DatCabecera=IngCabecera.getText().toString();
        boolean a=checaTFCRC(view,IngCabecera,DatCabecera);
        if(IngCabecera.getText().toString().length()==8) {
            //
            if(a){
                int dec = Integer.parseInt(DatCabecera, 2);
                val = Integer.toHexString(dec).toUpperCase();
            }else{
                val="00";
            }
        }
        else{
            IngCabecera.setText("");
        }
        return val;
    }

    public String BinSYN(View view){
        String val=" ";
        EditText IngSYN=(EditText)findViewById(R.id.SYN);
        String DatSYN=IngSYN.getText().toString();
        boolean a=checaTFCRC(view,IngSYN,DatSYN);
        if(IngSYN.getText().toString().length()==8) {
            if(a){
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
            }else{
                val="00";
            }
        }
        else{
            IngSYN.setText("");
        }
        return val;
    }

    public String BinSOH(View view){
        String val=" ";
        EditText IngSOH=(EditText)findViewById(R.id.IngSOH);
        String DatSOH=IngSOH.getText().toString();
        boolean a=checaTFCRC(view,IngSOH,DatSOH);
        if(IngSOH.getText().toString().length()==8) {
            if(a){
                int dec = Integer.parseInt(DatSOH, 2);
                val = Integer.toHexString(dec).toUpperCase();
            }else{
                val="00";
            }
        }
        else{
            IngSOH.setText("");
        }
        return val;
    }

    public String BinSTX(){
        EditText IngSTX=(EditText)findViewById(R.id.IngSTX);
        String DatSTX=IngSTX.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSTX,2);
        String val=Integer.toHexString(dec).toUpperCase();

        return  val;
    }

    //@Override
    public void onClick(View view) {
        int a[];

        String Arrtotal[];

        EditText MostValor= (EditText)findViewById(R.id.Res);
        EditText MostValor2 =(EditText)findViewById(R.id.Res2);
        EditText MostValor3 =(EditText)findViewById(R.id.Res3);
        EditText MostValor4 =(EditText)findViewById(R.id.Res4);
        EditText MostValor5 =(EditText)findViewById(R.id.Res5);
        EditText MostValor6 =(EditText)findViewById(R.id.Res6);
        EditText MostValor7 =(EditText)findViewById(R.id.Res7);
        EditText IngValor = (EditText)findViewById(R.id.IngValor);

        if(IngValor.getText().toString().isEmpty()){
            IngValor.setText("Ingrese Frase");
        }else {
            String RCRC=BinCRC(view);
            //BinETX(view);
            String RETX=BinETX(view);
            String RCabecera=BinCabecera(view);
            String RBinSYN =BinSYN(view);
            String RSOH =BinSOH(view);
            String RSTX =BinSTX();

            String cade = IngValor.getText().toString();
            int tam = cade.length();
            a = new int[tam];
            Arrtotal = new String[tam];

            for (int x = 0; x < cade.length(); x++) {
                int tamanio = IngValor.length();
                System.out.println(cade.charAt(x) + " = " + cade.codePointAt(x));
                int asc = cade.codePointAt(x);
                a[x] = asc;
                //ascci(asc,tamanio);
            }

            for (int i = 0; i < tam; i++) {
                int b = a[i];
                String hexa = Integer.toHexString(b).toUpperCase();
                Arrtotal[i] = hexa;
            }

            for (int i = 0; i < tam; i++) {
                System.out.print(Arrtotal[i]);


            }

            String ga =Arrays.toString(Arrtotal);

            System.out.println("Arreglo total: "+Arrays.toString(Arrtotal));

            MostValor.setText("CRC:  \n"+ RCRC);
            MostValor2.setText("Texto:\n"+ga);
            MostValor3.setText("ETX: \n"+RETX);
            MostValor4.setText("Cabecera: \n"+RCabecera);
            MostValor5.setText("SYN: \n"+RBinSYN);
            MostValor6.setText("SOH: \n"+RSOH);
            MostValor7.setText("STX: \n"+RSTX);
            cade = null;
        }
    }

}
