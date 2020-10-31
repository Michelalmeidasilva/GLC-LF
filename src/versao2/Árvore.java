package versao2;


import java.util.*;

public class Árvore {
  Nódulo noduloAuxiliar;
  TreeSet<String> auxiliar = new TreeSet<String>();
  Nódulo raiz;
  List<Nódulo> fila = new ArrayList<>();
  int nivel = 1;
  int galhoPreenchido = 0;

  int nrauxiliar;

  public Árvore(String datarecebida) {
    Nódulo raíz = new Nódulo(datarecebida.split(""), null, 0);
    this.raiz = raíz;
    fila.add(raíz);
  }


  /**
   * pra cada nivel eu tenho um somatorio de todos os filhos
   * primeiro tenho que transformar todos a Aa
   *
   * @param alfabeto
   * @param regras
   */


  public Nódulo preencherÁrvore(Alfabeto alfabeto, Regras regras, Nódulo pai) {
    if (nrauxiliar > 100) return pai;

    for (int x = 0; x < pai.data.length; x++) {
      for (int y = 0; y < alfabeto.nãoterminais.length; y++) {
        if (pai.data[x].contains(alfabeto.nãoterminais[y])) {
          for (int z = 0; z < regras.matrizregras.length; z++) {
            nrauxiliar++;
            if (pai.data[x].contains(regras.matrizregras[z][0])) {
              Nódulo novo = new Nódulo(regras.matrizregras[z][1].split(""), pai, nivel);
              pai.filhos.add(novo);
              if (novo != raiz) {
                galhoPreenchido++;
              }
              noduloAuxiliar = novo;
//                  fila.add(novo);
              if (galhoPreenchido >= regras.matrizregras.length) {
                galhoPreenchido = 0;
                nivel++;
              }
            }
          }
        }
      }
    }
    pai = preencherÁrvore(alfabeto, regras, noduloAuxiliar);
    return pai;
//    nivel = 0;
//    ordenarNiveis(raiz, 0);
}

  int test = 0;
  public int ordenarNiveis(Nódulo rootNode, int count) {

    if (rootNode.filhos.size() != 0) {
      System.out.println("Acabo os filhos de um");
      for (Nódulo ch : rootNode.filhos) {
        ch.nivel = count;
        fila.add(ch);
        count = ordenarNiveis(ch, count);
      }

    }
    test++;
    System.out.println("test:" + test  +  "nivel" + count);
    return count + 1;
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