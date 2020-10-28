
package GramaticaLivresDeContexto;

import java.util.ArrayList;
import java.util.List;

public class Árvore {
  Nodulo raíz = new Nodulo();
  List<String> palavrasGeradas = new ArrayList<String>();
  Alfabeto alfabeto;
  Regras regras;

  int linha = 0;
  public Árvore(String símboloraíz, Regras regras, Alfabeto alfabeto) {
    this.regras = regras;
    this.alfabeto = alfabeto;
    this.raíz.data = símboloraíz.split("");
    this.raíz.pai = null;
    this.raíz.irmãoesquerdo = null;
    this.raíz.irmãodireito = null;
    this.raíz.filhos = new ArrayList<>();
  }


  public Nodulo preencherÁrvore(int quantidade,  Árvore árvore, Nodulo novo) {
    if( palavrasGeradas.size() > quantidade)    return raíz;           /// condição recursiva

    while( this.linha < regras.matriz.length ) {     // procura uma regra em cada linha da matriz
      String regraLadoEsquerdo = regras.matriz[linha][0];       // armazena regra do lado esquerdo
      String[] regrasLadoDireito = convertToStringArray(regras.matriz[linha][1]); //armazena regra do lado direito
      for (int i = 0; i < regrasLadoDireito.length; i++) {//para cada regra do lado esquerdo insere um nó pai
        for (int j = 0; j < alfabeto.nãoterminais.length; j++) {
          novo = insereNodulo(regrasLadoDireito, i, j, novo);    // se tiver só nao terminais
        }
      }
      this.linha++;
      for(int x = 0; x < novo.data.length; x++) {     //Cada elemento da chave do nodulo    aAa
        verificaPalavraNoNodulo(x, novo, alfabeto);
      }
      preencherÁrvore(quantidade,   árvore,  novo);
    }

    return novo;
  }

//  private void regrasLadoDireitoMistos(String[] regrasLadoDireito, int i, int j, Nodulo novo){
//    if(regrasLadoDireito){
//
//    }
//  }
  private Nodulo insereNodulo(String[] regrasLadoDireito, int posRegra, int j, Nodulo novo ) {
    boolean regraHasTerminal= false;
    for ( String regra: regrasLadoDireito) {
      if(regra.contains(alfabeto.naoTerminaisToString())) regraHasTerminal = true;
    }
    if(regraHasTerminal == false){   // se nao contem nao terminais entao insere os teminais
      Nodulo auxiliar = new Nodulo();
      auxiliar.pai = novo;
      auxiliar.data = regrasLadoDireito;
      auxiliar.filhos = null;
      auxiliar.irmãodireito = null;
      auxiliar.irmãoesquerdo = null;
      auxiliar.pai.filhos.add(auxiliar);
      return auxiliar.pai;
    } else {
      Nodulo auxiliar = new Nodulo();
      auxiliar.pai = novo;
      auxiliar.data = regrasLadoDireito;
      auxiliar.filhos = null;
      if(auxiliar.pai.filhos != null && auxiliar.pai.filhos.size() > 0){
        auxiliar.irmãoesquerdo = auxiliar.pai.filhos.get(posRegra );
        auxiliar.irmãodireito = auxiliar.pai.filhos.get(posRegra + 1);
      }
      auxiliar.pai.filhos.add(auxiliar);
      return auxiliar.pai;
    }
  }


  private String[]  convertToStringArray(String regraDireitaNaMatriz) {
    return regraDireitaNaMatriz.split("");
  }

  private void  verificaPalavraNoNodulo(int x, Nodulo novo, Alfabeto alfabeto ) {
    for(int y = 0; y < novo.filhos.size(); y++) {
      boolean hasNaoterminal= false;
      for ( String nodo: novo.data) {
          if(nodo.contains(alfabeto.naoTerminaisToString())== true) hasNaoterminal = true;
      }
      if(hasNaoterminal  == false)  novaPalavraGerada(novo.data);

      hasNaoterminal = false;
      for (String nodo: novo.filhos.get(y).data) {
        if(nodo.contains(alfabeto.naoTerminaisToString())== true) hasNaoterminal = true;
      }
      if(hasNaoterminal  == false)  novaPalavraGerada(novo.filhos.get(y).data);

    }
  }

  private void novaPalavraGerada(String[] elementos) {
    String palavra = "";
    for ( String elemento: elementos) {
      palavra= palavra +""+ elemento;
    }
    palavrasGeradas.add(palavra);
  }
}
