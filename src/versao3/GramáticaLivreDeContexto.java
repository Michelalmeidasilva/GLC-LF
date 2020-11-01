
package versao3;

public class GramáticaLivreDeContexto {
    
    static int quantidade;
    static String símboloraíz;
    static String símbolosterminais;
    static String símbolosnãoterminais;
    static String[][] matrizregrasinicial = new String[4][2];
    static String[][] saída = new String[10][5];
    
    static Alfabeto alfabeto;
    static Regras regras;
    static Árvore raíz;
    
    public static void main(String[] args) {
        quantidade = 10;

        símboloraíz = "A";
        símbolosterminais = "ab";
        símbolosnãoterminais = "A";

        matrizregrasinicial[0][0] = "A";
        matrizregrasinicial[0][1] = "a";
        matrizregrasinicial[1][0] = "A";
        matrizregrasinicial[1][1] = "b";
        matrizregrasinicial[2][0] = "A";
        matrizregrasinicial[2][1] = "aAa";
        matrizregrasinicial[3][0] = "A";
        matrizregrasinicial[3][1] = "bAb";

        alfabeto = new Alfabeto(símbolosterminais, símbolosnãoterminais);
        regras = new Regras(matrizregrasinicial);
        raíz = new Árvore(símboloraíz);
        
        GramáticaLivreDeContexto.gerarPalavras(quantidade, saída);
    }
    
    static public void gerarPalavras(int quantidade, String[][] palavras) {
        raíz.preencherÁrvore(quantidade, saída, raíz, alfabeto, regras);
        raíz.imprimirÁrvore(alfabeto);
    }
}