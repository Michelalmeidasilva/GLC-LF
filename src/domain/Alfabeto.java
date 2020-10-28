
package domain;

public class Alfabeto {
    String raiz;
    String[] terminais;
    String[] nãoterminais;
    
    public Alfabeto(String símboloraíz, String símbolosterminais, String símbolosnãoterminais) {
        raiz = símboloraíz;
        terminais = símbolosterminais.split("");
        nãoterminais = símbolosnãoterminais.split("");
    }

    public String naoTerminaisToString() {
        String naoTerminaisString = "";
        for (int i = 0; i <nãoterminais.length ; i++) {
            naoTerminaisString = naoTerminaisString + ""+nãoterminais[i];
        }
        return naoTerminaisString;
    }
}
