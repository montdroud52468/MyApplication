package com.example.richard.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Button siguiente,otro,ejemplo;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        siguiente =(Button)findViewById(R.id.sig);
        otro=(Button)findViewById(R.id.otr);
        ejemplo=(Button)findViewById(R.id.eje);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente= new Intent(MainActivity.this,Main2Activity.class);
                startActivity(siguiente);
            }
        });
        otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro= new Intent(MainActivity.this,Main3Activity.class);
                startActivity(otro);
            }
        });
        ejemplo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejemplo= new Intent(MainActivity.this,Main4Activity.class);
                startActivity(ejemplo);
            }
        });
        Toast.makeText(MainActivity.this,R.string.Saludo,Toast.LENGTH_LONG).show();
    }

    public void botonMensaje(View m){
        Toast mensaje = Toast.makeText(getApplicationContext(),"\t\t\t Creado por:\n  Ana Aurora Magaña Alcudia\n" +
                "Ricardo Daniel Montiel Jacinto\n\t\tProtocolos de red",Toast.LENGTH_LONG);
        mensaje.show();
    }


}