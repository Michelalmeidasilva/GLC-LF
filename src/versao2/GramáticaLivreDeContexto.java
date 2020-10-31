package versao2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GramáticaLivreDeContexto {

    static Alfabeto alfabeto ;
    static Regras regras ;
    static Árvore raíz ;

    public static void main(String[] args) {
        String[][] matrizregrasinicial = new String[4][2];
        String símboloraíz = "A";
        String símbolosterminais = "abc";
        String símbolosnãoterminais = "A";
        matrizregrasinicial[0][0] = "A";
        matrizregrasinicial[0][1] = "a";
        matrizregrasinicial[1][0] = "A";
        matrizregrasinicial[1][1] = "b";
        matrizregrasinicial[2][0] = "A";
        matrizregrasinicial[2][1] = "aAa";
        matrizregrasinicial[3][0] = "A";
        matrizregrasinicial[3][1] = "bAb";

        int quantidade = 10;

        alfabeto = new Alfabeto(símbolosterminais, símbolosnãoterminais);
        regras = new Regras(matrizregrasinicial);
        raíz = new Árvore(símboloraíz);


        gerarPalavras(quantidade);
        raíz.imprimirÁrvore(alfabeto);
        raíz.auxiliar.forEach((palavra)->{
            System.out.println(palavra);
        });
//
//        for (int i = 0; i < auxiliar.length; i++) {
//            for (int j = 0; j < auxiliar[i].length; j++) {
//                System.out.print(auxiliar[i][j]+ " ");
//            }
//            System.out.println();
//        }

    }

    static public void gerarPalavras(int quantidade) {
        raíz.preencherÁrvore( alfabeto, regras, raíz.raiz);
    }
}