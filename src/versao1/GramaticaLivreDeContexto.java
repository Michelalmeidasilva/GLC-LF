package versao1;

import versao1.Alfabeto;
import versao1.Regras;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class GramaticaLivreDeContexto {
    String matriz [][];
    private Alfabeto alfabeto;
    private String raiz ;
    private TreeSet<String> palavrasGeradas = new TreeSet<String>();
    private List<Regras> regras;

    public  GramaticaLivreDeContexto(String simbolosTerminais, String simbolosNaoTerminais, String[][] matriz, String raiz){
        this.alfabeto = new Alfabeto(simbolosTerminais, simbolosNaoTerminais);
        this.matriz = matriz;
        this.raiz = raiz;
    }

    public TreeSet<String> gerarPalavras(int quantidade) {
        setarRegras();

        String palavra = this.raiz;
        String palavraVetor [] = palavra.split("");

        for (int i = 0; i < palavraVetor.length; i++) {
            for (int j = 0; j < alfabeto.naoTerminais.length; j++) {
                if(palavraVetor[i].contains(alfabeto.naoTerminais[j])){
                    int pos = randomRegra(palavraVetor[i]);
                    String substituir = regras.get(j).regraDireita.get(pos);
                    palavraVetor[i] = substituir;
                }
            }
        }

        String palavraString = arrayToString(palavraVetor);
        palavrasGeradas.add(palavraString);
        return palavrasGeradas;
    }

    private String arrayToString(String [] palavraVetor) {
        String palavraString ="";
        for (int i = 0; i < palavraVetor.length; i++)
            palavraString = palavraString + palavraVetor[i];

        return palavraString;
    }

    private void setarRegras(){
        regras = new ArrayList<Regras>(alfabeto.naoTerminais.length);
        for (int i = 0; i < alfabeto.naoTerminais.length; i++) {
                Regras aux = new Regras(alfabeto.naoTerminais[i], new ArrayList<String>());
                regras.add(aux);
        }
        for (int i = 0; i < matriz.length; i++) {
            String ladoEsquerdo = matriz[i][0];
            String ladoDireito = matriz[i][1];
            for (int j = 0; j < regras.size(); j++) {
                if(ladoEsquerdo.contains(regras.get(j).variavel)){
                    regras.get(j).regraDireita.add(ladoDireito);
                }
            }
        }
    }

    /**
     *
     * Retorna a posição randomica para subsitituir o vetor
     * e retornar o "lado direito"
     * @param variavelNaoTerminal
     * @return
     */
    int randomRegra(String variavelNaoTerminal){
        int tam = 0;
        for (int i = 0; i < regras.size(); i++) {
            if(variavelNaoTerminal.contains(regras.get(i).variavel)){
                Random gerador = new Random();
                tam  = gerador.nextInt(regras.get(i).regraDireita.size());
            }
        }
        return tam;
    }
}