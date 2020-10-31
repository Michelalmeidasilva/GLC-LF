package versao2;


import java.util.*;

public class Árvore {
  TreeSet<String> palavrasGeradas = new TreeSet<String>();
  Nódulo raiz;
  List<Nódulo> fila = new ArrayList<>();
  int nivel = 1;
  int galhoPreenchido = 0;

  int nrPalavrasGeradas;

  public Árvore(String datarecebida) {
    Nódulo raíz = new Nódulo(datarecebida.split(""), null, 0);
    this.raiz = raíz;
    fila.add(raíz);
  }

  public void preencherÁrvore(Alfabeto alfabeto, Regras regras) {
    while (nrPalavrasGeradas < 100) {
      Nódulo pai = fila.remove(0);
      for (int x = 0; x < pai.data.length; x++) {
        for (int y = 0; y < alfabeto.nãoterminais.length; y++) {
          if (pai.data[x].contains(alfabeto.nãoterminais[y])) {
            for (int z = 0; z < regras.matrizregras.length; z++) {
              nrPalavrasGeradas++;
              if (pai.data[x].contains(regras.matrizregras[z][0])) {
                Nódulo novo = new Nódulo(regras.matrizregras[z][1].split(""), pai, nivel);
                pai.filhos.add(novo);
                if (novo != raiz) {
                  galhoPreenchido++;
                }
                fila.add(novo);
              }
              if (galhoPreenchido >= regras.matrizregras.length) {
                galhoPreenchido = 0;
                nivel++;
              }
            }
          }
        }
      }
    }
    System.out.println(nrPalavrasGeradas);
  }

  public void ordenarNiveis(Nódulo rootNode, int count) {
    count++;
    if (rootNode.filhos.size() != 0) {
      for (Nódulo ch : rootNode.filhos) {
        ch.nivel = count;
        fila.add(ch);
        ordenarNiveis(ch, count);
      }
    }
  }


  public void imprimirÁrvore(Alfabeto alfabeto) {
    fila = new ArrayList<>();
    ordenarNiveis(raiz, 0);
    while (!fila.isEmpty()) {
      Nódulo auxiliar = fila.remove(0);
      for(int i = 0 ; i < auxiliar.data.length; i++){
        String formattedString = Arrays.toString(auxiliar.data);
//          formattedString.replaceAll(",", "")  //remove the commas
//          .replaceAll("[", "")  //remove the right bracket
//          .replace("]", "")  //remove the left bracket
//          .trim();           //remove trailing spaces from partially initialized arrays
        System.out.println("" + formattedString);
      }
    }

  }


}