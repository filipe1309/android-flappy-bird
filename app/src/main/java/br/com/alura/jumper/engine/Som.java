package br.com.alura.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import br.com.alura.jumper.R;

public class Som {
    private final SoundPool soundPool;
    public static int PULO;
    public static int PONTUACAO;
    public static int COLISAO;

    public Som(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        PONTUACAO = soundPool.load(context, R.raw.pontos, 0);
        COLISAO = soundPool.load(context, R.raw.colisao, 0);
    }

    public void toca(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
