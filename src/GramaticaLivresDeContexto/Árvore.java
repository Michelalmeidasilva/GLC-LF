
package GramaticaLivresDeContexto;

import java.util.ArrayList;
import java.util.List;

public class Árvore {
  Nodulo raíz = new Nodulo();
  List<String> palavrasGeradas = new ArrayList<String>();

  public Árvore(String símboloraíz) {
    this.raíz.data = símboloraíz.split("");
    this.raíz.pai = null;
    this.raíz.irmãoesquerdo = null;
    this.raíz.irmãodireito = null;
    this.raíz.filhos = new ArrayList<>();
  }

  public Nodulo preencherÁrvore(int quantidade, Alfabeto alfabeto, Regras regras, Árvore árvore, Nodulo novo) {
    if( palavrasGeradas.size() > quantidade)    return raíz;           /// condição recursiva
    for(int x = 0; x < novo.data.length; x++) {     //Cada elemento da chave do nodulo    aAa
      hasTerminal(x, novo, alfabeto);
      searchNaoTerminal(x, novo, alfabeto, regras, árvore, quantidade);
      //
    }
    novo =   preencherÁrvore(quantidade, alfabeto, regras, árvore, novo);
    return novo;
  }


  private void  hasTerminal(int x, Nodulo novo, Alfabeto alfabeto ) {
    for(int y = 0; y < alfabeto.terminais.length; y++) {
      if(novo.data[x].contains(alfabeto.terminais[y])) {          //primeira iteração = A raiz
        novaPalavraGerada(novo.data);
      }
    }
  }

  private void novaPalavraGerada(String[] elementos) {
    String palavra = "";
    for ( String elemento: elementos) {
      palavra= palavra +""+ elemento;
    }
    palavrasGeradas.add(palavra);
  }

  private void searchNaoTerminal(int x, Nodulo novo, Alfabeto alfabeto , Regras regras , Árvore árvore, int quantidade){
    for(int y = 0; y < alfabeto.nãoterminais.length; y++) { //alfabeto A
      if(novo.data[x].contains(alfabeto.nãoterminais[y])) {   // primeira iteração contem A
        for(int z = 0; z < regras.matrizregras.length; z++) {       //le matriz de regras
          if(novo.data[x].contains(regras.matrizregras[z][0])) {
            Nodulo auxiliar = new Nodulo();
            auxiliar.pai = novo;
            auxiliar.data = regras.matrizregras[z][1].split("");
            auxiliar.filhos = null;
            //verifica se o pai já foi instanciado
            if(auxiliar.pai.filhos != null && auxiliar.pai.filhos.size() >= 1) {
              auxiliar.irmãoesquerdo = auxiliar.pai.filhos.get(z - 1);
              auxiliar.irmãoesquerdo.irmãodireito = auxiliar;
            }
            auxiliar.pai.filhos.add(auxiliar);
            novo = árvore.preencherÁrvore(quantidade, alfabeto, regras, árvore, auxiliar);
          }
        }
      }
    }
  }

}
