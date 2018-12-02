package com.example.javig.a4cambioimagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCookie;
    private TextView textVComidaM;
    private ImageView imgCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textVComidaM = (TextView) findViewById(R.id.tengohamb);
        imgCookie = (ImageView) findViewById(R.id.beforeCookie);
        btnCookie = (Button) findViewById(R.id.eatcookie);

        btnCookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCookie.setImageResource(R.mipmap.after_cookie);
                textVComidaM.setText("Estoy lleno");

            }
        });
    }

}
