package com.example.javig.proyecto1_baloncesto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NombreActivity extends AppCompatActivity {

    private Button btEnvia;
    private EditText etLocal,etVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        btEnvia = (Button) findViewById(R.id.btEnvia);
        etLocal = (EditText) findViewById(R.id.etLocal);
        etVisitante = (EditText) findViewById(R.id.etVisitante);

        btEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NombreActivity.this, MainActivity.class);
                intent.putExtra("local",etLocal.getText().toString());
                intent.putExtra("visitante",etVisitante.getText().toString());
                startActivity(intent);
            }
        });
    }
}
