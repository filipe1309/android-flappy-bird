package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.alura.jumper.graphic.Tela;

/**
 * Created by filipe1309 on 04/07/17.
 */

public class Canos {

    public static final int DISTANCIA_ENTRE_CANOS = 200;
    public static final int QUANTIDADE_DE_CANOS = 5;
    private final List<Cano> canos = new ArrayList<Cano>();
    private final Tela tela;
    private Context context;
    private final Pontuacao pontuacao;

    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.pontuacao = pontuacao;
        this.tela = tela;
        this.context = context;
        int posicao = 400;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao, context);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.move();
            if (cano.saiuDaTela()) {
                pontuacao.aumenta();
                // create another pipe
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(outroCano);
            }
        }
    }

    public int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano: canos) {
            if (cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
