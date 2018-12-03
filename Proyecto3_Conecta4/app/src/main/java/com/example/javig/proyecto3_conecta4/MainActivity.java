package com.example.javig.proyecto3_conecta4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Game juego;
    private boolean reproMusica = true;

    private int[][] arrayId = {{R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton03, R.id.boton04, R.id.boton05, R.id.boton06},
            {R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton13, R.id.boton14, R.id.boton15, R.id.boton16},
            {R.id.boton20, R.id.boton21, R.id.boton22, R.id.boton23, R.id.boton24, R.id.boton25, R.id.boton26},
            {R.id.boton30, R.id.boton31, R.id.boton32, R.id.boton33, R.id.boton34, R.id.boton35, R.id.boton36},
            {R.id.boton40, R.id.boton41, R.id.boton42, R.id.boton43, R.id.boton44, R.id.boton45, R.id.boton46},
            {R.id.boton50, R.id.boton51, R.id.boton52, R.id.boton53, R.id.boton54, R.id.boton55, R.id.boton56}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        juego = new Game(Game.player);

    }

    public void jugar(int j) {
        for (int k = 0; k < arrayId.length; k++) {
            if ((k == (arrayId.length - 1) || !juego.isVacio(k + 1, j)) && juego.isVacio(k, j)) {
                if (juego.estado == "play") {
                    juego.setFicha(k, j);
                    rechenarCirculo(k, j, juego.getTurno());

                    if (juego.comprobarPartida(k, j)) {
                        mensajeGanador();
                        juego.estado = "finished";
                    }else{
                        juego.cambiarTurno();
                    }
                } else if (juego.estado == "finished") {
                    mensajeGanador();

                }
            }
        }
    }


    public void rechenarCirculo(int k, int j, int turno) {

        ImageView iv = (ImageView) findViewById(arrayId[k][j]);
        if (turno == Game.player) {
            iv.setImageResource(R.drawable.circuloamarillo);
        } else if (turno == Game.IA){
            iv.setImageResource(R.drawable.circulorojo);
        }
    }

    public void pulsarCirculo(View v) {

        for (int i = 0; i < arrayId.length; i++) {
            for (int j = 0; j < arrayId[i].length; j++) {
                if (v.getId() == arrayId[i][j]) {
                    if (juego.estado != "finished") {
                        jugar(j);
                    } else {
                        mensajeGanador();
                    }
                }
                if (juego.getTurno() == juego.IA && juego.estado != "finished") {
                    int col = juego.IApattern1(j);
                    jugar(col);
                }
            }
        }
    }

    private void mensajeGanador() {
        Musica.stop(this);
        reproMusica = false;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme));
        if (juego.ganador == "player") {
            builder.setMessage("¡¡Has ganado!!");
        } else if (juego.ganador == "IA") {
            builder.setMessage("¡¡Has perdido!!");
        }

        builder.setTitle("Partida finalizada");
        builder.setPositiveButton("Nueva partida", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                onBackPressed();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Musica.play(this,getResources().getIdentifier("purpleplanet", "raw",getPackageName()));

        if(!reproMusica) {
            Musica.stop(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Musica.stop(this);
    }
}