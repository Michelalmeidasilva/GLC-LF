package versao1;

import arquivo.JsonFormatter;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

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
    GLC.gerarPalavras(10);
    criarArquivo(GLC);

  }

  private static void criarArquivo(GramaticaLivreDeContexto glc) {
    Scanner ler = new Scanner(System.in);
    String pergunta;
    String s;
    System.out.printf("Informe o nome do arquivo a ser gerado:(para sair digite X)\n");
    s = ler.next(); //
    if(s.toLowerCase().equals("X")) return;
    System.out.println("Tem certeza que deseja colocar o nome do arquivo de: \""   + s + ".json\" ?(S/N)" );
    pergunta = ler.next();
    if(pergunta.toLowerCase().equals("s") ){
      System.out.println("Arquivo será criado no diretório atual");

      JsonFormatter json = new JsonFormatter();
      json.writeObject(glc, s);
      if(pergunta.toLowerCase().equals("X")) return;

    } else if(pergunta.toLowerCase().equals("n")){
      System.out.println("Entendi, redigite para um novo nome(para sair digite X)\"");
      criarArquivo(glc);
    }
    return;
  }
}
