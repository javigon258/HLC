package com.example.javig.a1erproyectoeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView vText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.myTextView);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView vText = (TextView) findViewById(R.id.myTextView);
                vText.setText("Boton pulsado");

            }
        });

    }

}
