
package domain;

import java.util.ArrayList;
import java.util.List;

public class Árvore {
    List<String> palavrasGeradas = new ArrayList<String>();
    Nódulo raíz;
    int nivel = 0;
    int galhos = 0;
    Alfabeto alfabeto;
    Regras regras;

    public Árvore(String símboloraíz, Regras regras, Alfabeto alfabeto) {
        this.regras = regras;
        this.alfabeto =alfabeto;
        this.raíz = new Nódulo(símboloraíz.split(""), null, null, null, new ArrayList<>());
    }
    
    public Nódulo preencherÁrvore(int quantidade,  Árvore árvore, Nódulo novo) {
        if( palavrasGeradas.size() > quantidade)    return raíz;           /// condição recursiva

        for(int x = 0; x < novo.data.length; x++) {
                for(int y = 0; y < alfabeto.nãoterminais.length; y++) {
                    if(novo.data[x].contains(alfabeto.nãoterminais[y])) {
                        trocarDeNivel();
                        while( this.galhos < regras.matrizregras.length ) {
                            if(novo.data[x].contains(regras.matrizregras[this.galhos][0])) {
                                Nódulo auxiliar = new Nódulo();
                                auxiliar = preencherNodulo(regras.matrizregras[this.galhos][1], alfabeto, auxiliar, novo, 0);
                                this.galhos++;
                                árvore.preencherÁrvore(quantidade, árvore, auxiliar.pai);
                            }
                        }
                    }
                }
            }
        return raíz;
    }

    private Nódulo trocarDeNivel() {
//        if(galhos == regras.matrizregras.length){
//            /**
//             * implementar logica de inserir em cada nivel
//             */
//            System.out.println("Tamanho do galho :"+ galhos);
//            for (int galho = 0; galho<  galhos; galho++){
//
//                System.out.println(novo.filhos.get(galho).dataToString());
//            }
//            nivel++;
////                            galhos = 0;
//
//            /**
//             *   System.out.println("Final do preenchimento pelas regras");
//             */
        return this.raíz;
//        }
    }


    private Nódulo preencherNodulo(String regraADireita, Alfabeto alfabeto, Nódulo auxiliar, Nódulo pai, int i) {
        String naoTerminais = alfabeto.naoTerminaisToString();
        if (regraADireita.contains(naoTerminais) == false){     /// Nó folha
            this.palavrasGeradas.add(regraADireita);
            auxiliar.pai = pai;
            auxiliar.filhos = null;
            auxiliar.data = regras.matrizregras[this.galhos][1].split("");
            auxiliar.pai.filhos.add(auxiliar);
            return auxiliar;
        } else {//contem terminais //desce 1 nivel
            if(auxiliar.pai == null ){
                auxiliar.data = regras.matrizregras[this.galhos][1].split("");
                auxiliar.pai = pai;
                pai.filhos.add(auxiliar);
            }
            /**
             * adiciona irmaos se tiver
             * percorrendo o lado da regra direita recursivamente
             */
            if (  i < auxiliar.data.length) {
                Nódulo irmao = new Nódulo();
                irmao.pai = auxiliar.pai;
                irmao.data = auxiliar.data[i].split("");
                //adiciona o nó irmao baseado no galho que está
                pai.filhos.get(this.galhos).Irmãos.add(irmao);
                preencherNodulo( regraADireita,  alfabeto,  auxiliar,  pai,  i  = i +1);
            }
            return auxiliar;
        }
    }
}
