
package versao3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Árvore {
    List<Nódulo> fila = new ArrayList<>();
    Nódulo raíz;
    
    public Árvore(String datarecebida) {
        raíz = new Nódulo(datarecebida.split(""), null);
    }
    
    public void imprimirÁrvore(Alfabeto alfabeto) {
        fila.add(raíz);
        for(int x = 0; x < fila.size(); x++){
            Nódulo auxiliar = fila.get(x);
            for(int y = 0; y < auxiliar.data.length; y++) {
                for(int z = 0; z < alfabeto.nãoterminais.length; z++) {
                    if(auxiliar.data[y].contains(alfabeto.nãoterminais[z])) {
                        fila.remove(auxiliar);
                        fila.addAll(auxiliar.filhos);
                        x--;
                        break;
                    }
                }
            }
        }

        
        while(!fila.isEmpty()) {
            Nódulo auxiliar = fila.remove(0);
            for(int x = 0; x < auxiliar.data.length; x++) {
                for(int y = 0; y < alfabeto.terminais.length; y++) {
                    if(auxiliar.data[x].contains(alfabeto.terminais[y]) && auxiliar.data.length == 1) {
                        String[] meio = auxiliar.data;
                        String[] stringauxiliar;
                        while(auxiliar.pai != null) {
                            stringauxiliar = auxiliar.pai.data.clone();
                            for(int z = 0; z < stringauxiliar.length; z++) {
                                for(int w = 0; w < alfabeto.nãoterminais.length; w++) {
                                    if(stringauxiliar[z].contains(alfabeto.nãoterminais[w])) {
                                        stringauxiliar[z] = Arrays.toString(meio);
                                        meio = stringauxiliar;
                                    }
                                }
                            }
                            String formattedString = Arrays.toString(stringauxiliar)
                            .replace(",", "")  //remove the commas
                            .replace("[", "")  //remove the right bracket
                            .replace("]", "")  //remove the left bracket
                            .trim();           //remove trailing spaces from partially initialized arrays
                            System.out.println(formattedString);
                            auxiliar = auxiliar.pai;
                        }
                    }
                }
            }
        }
    }
    
    public void preencherÁrvore(int quantidade, String[][] palavras, Árvore árvore, Alfabeto alfabeto, Regras regras) {
        int geradas = 0;
        fila.add(raíz);
        
        while(!fila.isEmpty() && geradas < quantidade) {
            Nódulo pai = fila.remove(0);
            for(int x = 0; x < pai.data.length; x++) {
                for(int y = 0; y < alfabeto.terminais.length; y++) {
                    if(pai.data[x].contains(alfabeto.terminais[y])) {
                        if(pai.data.length == 1) {
                            geradas++;
                        }
                    }
                }


                for(int y = 0; y < alfabeto.nãoterminais.length; y++) {//2
                    if(pai.data[x].contains(alfabeto.nãoterminais[y])) {//3
                        for(int z = 0; z < regras.matrizregras.length; z++) {//4
                            if(pai.data[x].contains(regras.matrizregras[z][0])) {//5
                                Nódulo novo = new Nódulo(regras.matrizregras[z][1].split(""), pai);
                                pai.filhos.add(novo);
                                fila.add(novo);
                            }
                        }
                    }
                }
            }
        }
        fila.clear();
    }
}
