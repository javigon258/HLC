package com.example.javig.proyecto2_calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0;
    private Button btmas,btmenos,btpor,btdivide,btclear,btigual,btcoma,btcambiarsigno;
    private String operador;
    private double num1,num2,result;
    private TextView tvResultado,tvcontadorResultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = (TextView) findViewById(R.id.resultado);
        bt1 = (Button) findViewById(R.id.btuno);
        bt2 = (Button) findViewById(R.id.btdos);
        bt3 = (Button) findViewById(R.id.bttres);
        bt4 = (Button) findViewById(R.id.btcuatro);
        bt5 = (Button) findViewById(R.id.btcinco);
        bt6 = (Button) findViewById(R.id.btseis);
        bt7 = (Button) findViewById(R.id.btsiete);
        bt8 = (Button) findViewById(R.id.btocho);
        bt9 = (Button) findViewById(R.id.btnueve);
        bt0 = (Button) findViewById(R.id.btcero);
        btmas = (Button) findViewById(R.id.btmas);
        btmenos = (Button) findViewById(R.id.btmenos);
        btpor = (Button) findViewById(R.id.btpor);
        btdivide = (Button) findViewById(R.id.btdivision);
        btclear = (Button) findViewById(R.id.btclear);
        btigual = (Button) findViewById(R.id.btigual);
        btcambiarsigno = (Button) findViewById(R.id.btcambiarSigno);
        btcoma = (Button) findViewById(R.id.btcoma);
        tvcontadorResultados = (TextView) findViewById(R.id.contadorResultados);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"0");
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(tvResultado.getText()+"9");
            }
        });
        btcoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if ()
                //tvResultado.setText();
            }
        });

    }

    public void Exit(){
      /*  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }*/
    }

    public void calcularOperacion(View view){
        num1 = Double.parseDouble(tvResultado.getText().toString());
        tvResultado.setText("  ");
    }

    public void Sumar(View view){
        operador = "+";
        calcularOperacion(view);
    }

    public void Restar(View view){
        operador = "-";
        calcularOperacion(view);
    }

    public void Multiplicar(View view){
        operador = "*";
        calcularOperacion(view);
    }

    public void Dividir(View view){
        operador = "/";
        calcularOperacion(view);
    }


    public void conComa(View view){
        operador = ",";
        calcularOperacion(view);
    }

    public void Igual(View view){
        num2 = Double.parseDouble(tvResultado.getText().toString());
        if (operador.equals("+")){
            tvcontadorResultados.setText(""+num1+"+"+""+num2);
            result = num1 + num2;
        }else if(operador.equals("-")){
            tvcontadorResultados.setText(""+num1+"-"+""+num2);
            result = num1 - num2;
        }else if(operador.equals("*")){
            tvcontadorResultados.setText(""+num1+"x"+""+num2);
            result = num1 * num2;
        }else if(operador.equals("/")){
            tvcontadorResultados.setText(""+num1+"/"+""+num2);
            result = num1 / num2;
        }
        tvResultado.setText(" "+result);
    }

    public void borrarUlt(View view){
        if (tvResultado.getText().toString().equals(" ")){
            tvResultado.setText(tvResultado.getText().subSequence(0, tvResultado.getText().length()-1) + " ");
        }
    }

    public void BorrarTodo(View view){
        num1 = 0.0;
        num2 = 0.0;
        tvResultado.setText(" ");
        tvcontadorResultados.setText(" ");
    }
}
