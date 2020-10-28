
package GramaticaLivresDeContexto;

import java.util.ArrayList;
import java.util.List;

public class Árvore {
    gramáticalivredecontexto.Nódulo raíz = new gramáticalivredecontexto.Nódulo();
    List<String> palavrasGeradas = new ArrayList<String>();
    public Árvore(String símboloraíz) {
        this.raíz.data = símboloraíz.split("");
        this.raíz.pai = null;
        this.raíz.irmãoesquerdo = null;
        this.raíz.irmãodireito = null;
        this.raíz.filhos = new ArrayList<>();
    }
    
    public void preencherÁrvore(int quantidade, int qtdgeradas, Alfabeto alfabeto, Regras regras, Árvore árvore, gramáticalivredecontexto.Nódulo novo) {
        while(qtdgeradas < quantidade) {                    /// condição recursiva
            for(int x = 0; x < novo.data.length; x++) {     //Cada elemento da chave do nodulo    aAa
                System.out.println(novo.data[x]);
                qtdgeradas = hasTerminal(x, novo, alfabeto, qtdgeradas);
                searchNaoTerminal(x, novo, alfabeto, qtdgeradas, regras, árvore, quantidade);
                return;
            }
        }
    }

    private int hasTerminal(int x, gramáticalivredecontexto.Nódulo novo, Alfabeto alfabeto , int qtdgeradas) {
        for(int y = 0; y < alfabeto.terminais.length; y++) {
            if(novo.data[x].contains(alfabeto.terminais[y])) {          //primeira iteração = A raiz
                qtdgeradas = qtdgeradas +1;
                palavrasGeradas.add(novo.data[x].toString());
                if(novo.data.length == 1) {
                    System.out.println("palavra gerada" + novo.data[x]);
                } else {
                    System.out.print(novo.data[x]);
                }
            }
        }
        return qtdgeradas;
    }
    private void searchNaoTerminal(int x, gramáticalivredecontexto.Nódulo novo, Alfabeto alfabeto , int qtdgeradas, Regras regras , Árvore árvore, int quantidade){
        for(int y = 0; y < alfabeto.nãoterminais.length; y++) { //alfabeto A
            if(novo.data[x].contains(alfabeto.nãoterminais[y])) {   // primeira iteração contem A
                for(int z = 0; z < regras.matrizregras.length; z++) {       //le matriz de regras
                    if(novo.data[x].contains(regras.matrizregras[z][0])) {
                        gramáticalivredecontexto.Nódulo auxiliar = new gramáticalivredecontexto.Nódulo();
                        auxiliar.pai = novo;
                        auxiliar.data = regras.matrizregras[z][1].split("");
                        if(novo.filhos.size() >= 1) {
                            auxiliar.irmãoesquerdo = novo.filhos.get(z - 1);
                            auxiliar.irmãoesquerdo.irmãodireito = auxiliar;
                        }
                        auxiliar.filhos = null;
                        novo.filhos.add(auxiliar);
                        árvore.preencherÁrvore(quantidade, qtdgeradas, alfabeto, regras, árvore, auxiliar);
                    }
                }
            }
        }
    }

}
