package com.example.javig.proyecto1_baloncesto;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView marcador1,marcador2;
    private int contador1 = 0;
    private int contador2 = 0;
    private Button btReiniciar,btDecrementa1,btDecrementa2,btmas1,btmas2,btmas3,btmas4,btmas5,btmas6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcador1 = (TextView) findViewById(R.id.tvContador1);
        marcador2 = (TextView) findViewById(R.id.tvContador2);
        btReiniciar = (Button) findViewById(R.id.btReiniciar);
        btDecrementa1 = (Button) findViewById(R.id.btDecrementa1);
        btDecrementa2 = (Button) findViewById(R.id.btDecrementa2);
        btmas1 = (Button) findViewById(R.id.btmas1);
        btmas2 = (Button) findViewById(R.id.btmas2);
        btmas3 = (Button) findViewById(R.id.btmas3);
        btmas4 = (Button) findViewById(R.id.btmas4);
        btmas5 = (Button) findViewById(R.id.btmas5);
        btmas6 = (Button) findViewById(R.id.btmas6);

        btmas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador1 += 1;
                marcador1.setText(String.valueOf(contador1));
            }
        });

        btmas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador1 += 2;
                marcador1.setText(String.valueOf(contador1));
            }
        });

        btmas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador1 += 3;
                marcador1.setText(String.valueOf(contador1));
            }
        });

        btmas4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador2 += 1;
                marcador2.setText(String.valueOf(contador2));
            }
        });

        btmas5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador2 += 2;
                marcador2.setText(String.valueOf(contador2));
            }
        });

        btmas6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador2 += 3;
                marcador2.setText(String.valueOf(contador2));
            }
        });

        btReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Reiniciar marcador");
                builder.setMessage("¿Quieres reiniciar el marcador?");
                builder.setPositiveButton(R.string.opsi, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Borrado",Toast.LENGTH_SHORT).show();
                        contador1 = 0;
                        contador2 = 0;
                        marcador1.setText(String.valueOf(contador1));
                        marcador2.setText(String.valueOf(contador2));
                    }
                });
                builder.setNegativeButton(R.string.opno, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        marcador1.setText(String.valueOf(contador1));
                        marcador2.setText(String.valueOf(contador2));
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btDecrementa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador1 == 0)
                    marcador1.setText(String.valueOf(contador1));
                else
                    contador1--;
                    marcador1.setText(String.valueOf(contador1));
            }
        });

        btDecrementa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador2 == 0)
                    marcador2.setText(String.valueOf(contador2));
                else
                    contador2--;
                    marcador2.setText(String.valueOf(contador2));
            }
        });
    }
}
