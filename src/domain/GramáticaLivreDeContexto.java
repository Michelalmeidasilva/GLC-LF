
package domain;

public class GramáticaLivreDeContexto {

    public static void main(String[] args) {
        String[][] saída;
        String[][] matrizregrasinicial = new String[4][2];
        matrizregrasinicial[0][0] = "A";
        matrizregrasinicial[0][1] = "a";
        matrizregrasinicial[1][0] = "A";
        matrizregrasinicial[1][1] = "b";
        matrizregrasinicial[2][0] = "A";
        matrizregrasinicial[2][1] = "aAa";
        matrizregrasinicial[3][0] = "A";
        matrizregrasinicial[3][1] = "bAb";

        String símboloraíz = "A";
        String símbolosterminais = "ab";
        String símbolosnãoterminais = "A";

        Alfabeto alfabeto = new Alfabeto(símboloraíz, símbolosterminais, símbolosnãoterminais);
        Regras regras = new Regras(matrizregrasinicial);
        Árvore árvore = new Árvore(símboloraíz, regras ,alfabeto);

        árvore.raíz = árvore.preencherÁrvore(10,  árvore, árvore.raíz);

        árvore.palavrasGeradas.forEach(palavra -> System.out.println(palavra) );

    }

}