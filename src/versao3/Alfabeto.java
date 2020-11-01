
package versao3;

public class Alfabeto {
    String[] terminais;
    String[] nãoterminais;
    
    public Alfabeto(String símbolosterminaisrecebidos, String símbolosnãoterminaisrecebidos) {
        terminais = símbolosterminaisrecebidos.split("");
        nãoterminais = símbolosnãoterminaisrecebidos.split("");
    }
}
