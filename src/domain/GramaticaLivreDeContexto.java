package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class GramaticaLivreDeContexto {

    protected String matriz [][];

    private String raiz ;

    private Alfabeto alfabeto;

    int quantidadeDePalavrasGeradas;

    private TreeSet<String> palavrasGeradas = new TreeSet<String>();

    private List<Regras> regras;

    public  GramaticaLivreDeContexto(String simbolosTerminais, String simbolosNaoTerminais, String[][] matriz, String raiz){
        this.alfabeto = new Alfabeto(simbolosTerminais, simbolosNaoTerminais);
        this.matriz = matriz;
        this.raiz = raiz;
    }

    public void gerarPalavras(int quantidade){
        setarRegras();
        this.quantidadeDePalavrasGeradas = quantidade;
        for (int i = 0; i < quantidade; i++) {
            gerarPalavra();
        }
    }
    public TreeSet<String> gerarPalavra() {
        int x = 0;
        String palavra = new String(this.raiz);
        String naoTerminaisStr = alfabeto.getNãoTerminais();
        /**
         * subistituição de palavras  randomicamente
         */
        int countTerminais = 0;
        while(x  < 10) {
            String palavraVetor [] = palavra.split("");
            for (int i = 0; i < palavraVetor.length; i++) {
                for (int j = 0; j < alfabeto.naoTerminais.length; j++) {
                    if (palavraVetor[i].contains(alfabeto.naoTerminais[j])) {
                        /**
                         * se na palavraVetor possui mais de 10 temrinais retornar tudo e trocar para terminais ;fazer logica
                         */
                        int pos = randomRegra(palavraVetor[i]);
                        String substituir = regras.get(j).regraDireita.get(pos);
                        palavra = changeCharInPosition(i, substituir, palavra);
                    }

                }
            }
            x++;
        }
        palavra = transformaEmterminal(palavra);
        palavrasGeradas.add(palavra);
        return palavrasGeradas;
    }

    private String transformaEmterminal(String palavra ) {
        String[] palavraArray = palavra.toString().split("");
        Random generate = new Random();
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 0; j < alfabeto.naoTerminais.length; j++) {
                int random = generate.nextInt(alfabeto.terminais.length);
                if(palavraArray[i].contains(alfabeto.naoTerminais[j]) == true){
                    palavraArray[i] = alfabeto.terminais[random];
                }
            }
        }

        return arrayToString(palavraArray);
        /**
         * subistuição certinha fazer um for do inicio até o fim subsitituindo só por terminais
         */
    }

    private String arrayToString(String [] palavraVetor) {
        String palavraString ="";
        for (int i = 0; i < palavraVetor.length; i++)
            palavraString = palavraString + palavraVetor[i];

        return palavraString;
    }

    public String changeCharInPosition(int position, String ch, String str){
        char []test = str.toCharArray();
        String[] charArray= new String[test.length];
        for (int i = 0; i <charArray.length ; i++) {
            charArray[i] = test[i] + "";
        }
        charArray[position] = ch;
        String palavra = "";
        for (int i = 0; i < charArray.length; i++) {
            palavra = palavra + charArray[i];
        }
        return palavra;
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
     * @return'
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

    public TreeSet<String> getPalavrasGeradas() {
        return palavrasGeradas;
    }
}