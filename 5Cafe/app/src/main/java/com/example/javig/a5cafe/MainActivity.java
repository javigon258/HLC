package com.example.javig.a5cafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView cantidad;
    private EditText etNombre;
    private CheckBox cbCrema,cbChoco;
    private Button btCantidadMas,btCantidadMenos,mandar;
    private int contador = 0;
    private String crema,choco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre =  findViewById(R.id.nombCliente);
        cbCrema =  findViewById(R.id.cbCrema);
        cbChoco =  findViewById(R.id.cbChoco);
        btCantidadMas =  findViewById(R.id.btMas1);
        btCantidadMenos =  findViewById(R.id.btMenos1);
        mandar = findViewById(R.id.ordenar);
        cantidad =  findViewById(R.id.variable);

        btCantidadMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador += 1;
                cantidad.setText(String.valueOf(contador));

            }
        });

        btCantidadMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador = contador - 1;
                if (contador < 0){
                    contador = 0;
                    cantidad.setText(String.valueOf(contador));
                }else{
                    cantidad.setText(String.valueOf(contador));
                }
                cantidad.setText(String.valueOf(contador));

            }
        });
        cbCrema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cbCrema.isChecked()){
                    crema = "Sin crema";
                }else{
                    crema = "Con crema";
                }
            }
        });

        cbChoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cbChoco.isChecked()){
                    choco = "Sin chocolate";
                }else{
                    choco = "Con chocolate";
                }
            }
        });

       mandar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this," Nombre: "+etNombre.getText() +
                        "\n Crema: "+ crema +
                        "\n Chocolate: "+ choco +
                        "\n Cantidad: "+ contador +
                        "\n Gracias",Toast.LENGTH_SHORT).show();
            }

        });

}

}
