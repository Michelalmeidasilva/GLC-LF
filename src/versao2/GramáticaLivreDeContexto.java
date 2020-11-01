//package versao2;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//public class GramáticaLivreDeContexto {
//
//    static Alfabeto alfabeto ;
//    static Regras regras ;
//    static Árvore raíz ;
//
//    public static void main(String[] args) {
//        String[][] matrizregrasinicial = new String[4][2];
//        String símboloraíz = "A";
//        String símbolosterminais = "ab";
//        String símbolosnãoterminais = "A";
//        matrizregrasinicial[0][0] = "A";
//        matrizregrasinicial[0][1] = "a";
//        matrizregrasinicial[1][0] = "A";
//        matrizregrasinicial[1][1] = "b";
//        matrizregrasinicial[2][0] = "A";
//        matrizregrasinicial[2][1] = "aAa";
//        matrizregrasinicial[3][0] = "A";
//        matrizregrasinicial[3][1] = "bAb";
//        int quantidade = 10;
//        alfabeto = new Alfabeto(símbolosterminais, símbolosnãoterminais);
//        regras = new Regras(matrizregrasinicial);
//        raíz = new Árvore(símboloraíz, alfabeto, regras );
//        gerarPalavras(10);
//        raíz.imprimirÁrvore(alfabeto);
//        raíz.palavrasGeradas.forEach(palavra->{
//            System.out.println(palavra);
//        });
//    }
//
//    static public void gerarPalavras(int quantidade) {
//        raíz.preencherÁrvore( 10 );
//    }
//}