package com.example.javig.proy_conecta4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Game juego;
    private int[][] arrayTablero = {
            {R.id.boton00, R.id.boton01, R.id.boton02, R.id.boton03, R.id.boton04, R.id.boton05, R.id.boton06},
            {R.id.boton10, R.id.boton11, R.id.boton12, R.id.boton13, R.id.boton14, R.id.boton15, R.id.boton16},
            {R.id.boton20, R.id.boton21, R.id.boton22, R.id.boton23, R.id.boton24, R.id.boton25, R.id.boton26},
            {R.id.boton30, R.id.boton31, R.id.boton32, R.id.boton33, R.id.boton34, R.id.boton35, R.id.boton36},
            {R.id.boton40, R.id.boton41, R.id.boton42, R.id.boton43, R.id.boton44, R.id.boton45, R.id.boton46},
            {R.id.boton50, R.id.boton51, R.id.boton52, R.id.boton53, R.id.boton54, R.id.boton55, R.id.boton56}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int turno = Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("jugadorEmpieza","1"));
        juego = new Game(Game.JUGADOR);
        if (juego.getTurno() == Game.MAQUINA && !juego.estado.equals("Terminado")) {
            int col = juego.maquinaRespondeMovimientoA((int) Math.round(Math.random()*(6 - 0)));
            jugar(col);
        }

        setTitle("Conecta 4");
    }

    protected void onResume(){
        if(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("musica",true));
        super.onResume();
        Musica.play(this,getResources().getIdentifier("purpleplanet", "raw",getPackageName()));
    }

    protected void onPause(){
        if(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("musica",true))
            super.onPause();
        Musica.stop(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuSendMessage:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Este es mi texto para enviar.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return true;
            case R.id.menuSettings:
                startActivity(new Intent(this, Settings.class));
                return true;
            case R.id.menuAbout:

        }
        return super.onOptionsItemSelected(item);
    }

    void pintarTablero(){
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero[i].length; j++) {
                pintarFicha(i,j,juego.tablero[i][j]);
            }
        }
    }
    void pintarFicha(int i, int j, int turno) {
        ImageView imageviev = (ImageView) findViewById(arrayTablero[i][j]);
        if (turno == Game.JUGADOR)
            imageviev.setImageResource(R.drawable.fichaverde);
        else if (turno == Game.MAQUINA)
            imageviev.setImageResource(R.drawable.ficharoja);
    }

    public void pulsarFicha(View v) {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero[i].length; j++) {
                if (v.getId() == arrayTablero[i][j]) {
                    if (juego.estado != "Terminado")
                        jugar(j);
                    else
                        mostrarGanador();
                }
                if (juego.getTurno() == Game.MAQUINA && !juego.estado.equals("Terminado")) {
                    int col = juego.maquinaRespondeMovimientoA(j);
                    jugar(col);
                }
            }
        }
    }

    public void jugar(int j) {
        for (int i = 0; i < arrayTablero.length; i++) {
            if ((i == (arrayTablero.length - 1) || !juego.isVacio(i + 1, j)) && juego.isVacio(i, j)) {
                if (juego.estado == "Jugando") {
                    juego.setFicha(i, j);
                    pintarFicha(i, j, juego.getTurno());
                }
                if (juego.comprobarPartida(i, j)) {
                    mostrarGanador();
                    juego.estado = "Terminado";
                }
                juego.cambiarTurno();
            } else if (juego.estado == "Terminado") {
                mostrarGanador();
            }
        }
    }
    private void mostrarGanador() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AppTheme));
        if(juego.ganador == "Jugador") {
            builder.setMessage(R.string.mensajeGanadorJugador);

        }else if(juego.ganador == "Maquina"){
            builder.setMessage(R.string.mensajeGanadorMaquina);

        }
        builder.setTitle(R.string.mensajeTitulo);
        builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.salir, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onBackPressed();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}