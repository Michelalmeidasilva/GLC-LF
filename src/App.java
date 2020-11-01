import main.arquivo.Arquivo;
import main.gramatica.Alfabeto;
import main.gramatica.GLC;
import main.gramatica.Regras;

public class App {

    public static void main(String[] args) {
      /**
       * pega todas informações do arquivo
       */
      GLC glc = Arquivo.input();
      if(glc.gerarPalavras() == true) Arquivo.output(glc);

//      gramaticaDeExpressoes(100);
//      gramaticaDeA(20);
    }

    private static void gramaticaDeA(int quantidade) {

        String simboloInicial = "A";
        String símbolosterminais = "abc";
        String símbolosnãoterminais = "A";

        String[][] matrizregrasinicial= new String[4][2];

        matrizregrasinicial[0][0] = "A";
        matrizregrasinicial[0][1] = "a";
        matrizregrasinicial[1][0] = "A";
        matrizregrasinicial[1][1] = "b";
        matrizregrasinicial[2][0] = "A";
        matrizregrasinicial[2][1] = "aAa";
        matrizregrasinicial[3][0] = "A";
        matrizregrasinicial[3][1] = "c";

        Alfabeto alfabeto = new Alfabeto(símbolosterminais, símbolosnãoterminais);
        Regras regras = new Regras(matrizregrasinicial);
        GLC  gramatica = new GLC(simboloInicial, alfabeto, regras);
        if(gramatica.is_gramaticaValida() ==false) return;
        gramatica.gerarPalavras(quantidade);

        Arquivo.output(gramatica);

    }

    private static void gramaticaDeExpressoes(int quantidade) {
       String[][] matrizRegras = new String[10][2];
       String simbolosTerminais = "abc+*()";
       String simbolosNaoTerminais = "IE";
       String simboloInicial = "E";

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

       Alfabeto alfabeto = new Alfabeto(simbolosTerminais, simbolosNaoTerminais);
       Regras regras = new Regras(matrizRegras);
       GLC gramatica = new GLC(simboloInicial, alfabeto, regras);
       if(!gramatica.is_gramaticaValida()) return;
       gramatica.gerarPalavras(quantidade);
       Arquivo.output(gramatica);

    }
}



