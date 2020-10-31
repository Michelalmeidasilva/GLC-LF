package versao1;

import versao2.Alfabeto;
import versao2.Regras;
import versao2.Árvore;

public class GramaticaLivreDeContexto {

    Alfabeto alfabeto;
    Regras regras ;
    String raíz ;
    Gerador geradorDeSentencas;

    public  GramaticaLivreDeContexto(String simbolosTerminais, String simbolosNaoTerminais, String[][] matriz, String raiz){
        alfabeto = new Alfabeto(simbolosTerminais, simbolosNaoTerminais);
        regras = new Regras(matriz);
        raíz = new String(raiz);
    }


    void gerarPalavras(int quantidade) {
        geradorDeSentencas.gerar( quantidade);
        geradorDeSentencas.palavrasGeradas.forEach((palavra)->{
            System.out.println(palavra);
        });

    }
}