package com.example.javig.a3operacionesaritmeticas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int n1,n2,resultado;
    private EditText EditTnum1, EditTnum2;
    private TextView cresultado;
    private Button btnSuma, btnRestar, btnDividir, btnMultiplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTnum1 = (EditText) findViewById(R.id.numero1);
        EditTnum2 = (EditText) findViewById(R.id.numero2);
        btnSuma = (Button) findViewById(R.id.suma);
        btnRestar = (Button) findViewById(R.id.resta);
        btnDividir = (Button) findViewById(R.id.division);
        btnMultiplicar = (Button) findViewById(R.id.multiplicar);
        cresultado = (TextView) findViewById(R.id.resul);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n1 = Integer.parseInt(EditTnum1.getText().toString());
                Integer n2 = Integer.parseInt(EditTnum2.getText().toString());
                resultado = n1 + n2;
                cresultado.setText(Integer.toString(resultado));
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n1 = Integer.parseInt(EditTnum1.getText().toString());
                Integer n2 = Integer.parseInt(EditTnum2.getText().toString());
                resultado = n1 - n2;
                cresultado.setText(Integer.toString(resultado));
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n1 = Integer.parseInt(EditTnum1.getText().toString());
                Integer n2 = Integer.parseInt(EditTnum2.getText().toString());
                resultado = n1 / n2;
                cresultado.setText(Integer.toString(resultado));
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer n1 = Integer.parseInt(EditTnum1.getText().toString());
                Integer n2 = Integer.parseInt(EditTnum2.getText().toString());
                resultado = n1 * n2;
                cresultado.setText(Integer.toString(resultado));
            }
        });
    }
}
