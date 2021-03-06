package br.com.alura.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Cores {
    public static Paint getCorDoPassaro() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000); // ARGB
        return paint;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00); // ARGB
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF); // ARGB
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);
        return branco;
    }

    public static Paint getCorDoGameOver() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000); // ARGB
        vermelho.setTextSize(50);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2, 3, 3, 0xFF000000);
        return vermelho;
    }
}
