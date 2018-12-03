package com.example.javig.proyecto3_conecta4;

import android.content.Context;
import android.media.MediaPlayer;

public class Musica {
    public static MediaPlayer musica;


    public static void play(Context context, int id) {
        musica = MediaPlayer.create(context, id);
        musica.setLooping(true);
        musica.start();
    }

    public static void stop(Context context) {
        if (musica != null) {
            musica.stop();
            musica.release();
            musica = null;
        }
    }
}