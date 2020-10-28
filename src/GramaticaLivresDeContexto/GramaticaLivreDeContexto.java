
package GramaticaLivresDeContexto;

public class GramaticaLivreDeContexto {

  public static void main(String[] args) {
    String símboloraíz;
    String símbolosterminais;
    String símbolosnãoterminais;
    String[][] matrizregrasinicial = new String[4][2];
    String[][] saída;

    Alfabeto alfabeto;
    Regras regras;
    Árvore árvore;

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

    alfabeto = new Alfabeto(símboloraíz, símbolosterminais, símbolosnãoterminais);
    regras = new Regras(matrizregrasinicial);
    árvore = new Árvore(símboloraíz);

    árvore.preencherÁrvore(10, 0, alfabeto, regras, árvore, árvore.raíz);
  }

}