import arquivo.JsonFormatter;
import domain.GramaticaLivreDeContexto;

import java.io.IOException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
//    lerArquivo();

    GramaticaLivreDeContexto GLC = expressoes();
//    GramaticaLivreDeContexto GLC = exemplo1();
    GLC.getPalavrasGeradas().forEach(palavra-> System.out.println(palavra));
    System.out.println("Sua gramatica foi gerada!!! ");
    System.out.println("***************************\n***************************\n");

//    criarArquivo(GLC);

  }

  private static GramaticaLivreDeContexto exemplo1() {
    String[][] matrizRegras = new String[4][2];

    String simboloRaiz = "A";
    String simbolosTerminais = "ab";
    String simbolosNaoTerminais = "A";

    matrizRegras[0][0] = "A";
    matrizRegras[0][1] = "a";

    matrizRegras[1][0] = "A";
    matrizRegras[1][1] = "b";

    matrizRegras[2][0] = "A";
    matrizRegras[2][1] = "aAa";

    matrizRegras[3][0] = "A";
    matrizRegras[3][1] = "bAb";



    GramaticaLivreDeContexto GLC = new GramaticaLivreDeContexto(simbolosTerminais, simbolosNaoTerminais,  matrizRegras, simboloRaiz);
    GLC.gerarPalavras(100);
    return GLC;
  }


  static GramaticaLivreDeContexto expressoes() {
    String[][] matrizRegras = new String[10][2];

    String simboloRaiz = "E";
    String simbolosTerminais = "abc+*()";
    String simbolosNaoTerminais = "IE";

    matrizRegras[0][0] = "E";
    matrizRegras[0][1] = "I";

    matrizRegras[1][0] = "E";
    matrizRegras[1][1] = "E*E";

    matrizRegras[2][0] = "E";
    matrizRegras[2][1] = "E+E";

    matrizRegras[3][0] = "E";
    matrizRegras[3][1] = "(E)";

    matrizRegras[4][0] = "E";
    matrizRegras[4][1] = "a";

    matrizRegras[5][0] = "E";
    matrizRegras[5][1] = "c";

    matrizRegras[6][0] = "I";
    matrizRegras[6][1] = "a";

    matrizRegras[7][0] = "I";
    matrizRegras[7][1] = "b";

    matrizRegras[8][0] = "I";
    matrizRegras[8][1] = "Ia";

    matrizRegras[9][0] = "I";
    matrizRegras[9][1] = "Ib";

    GramaticaLivreDeContexto GLC = new GramaticaLivreDeContexto(simbolosTerminais, simbolosNaoTerminais,  matrizRegras, simboloRaiz);
    GLC.gerarPalavras(20);
    return GLC;
  }



}
