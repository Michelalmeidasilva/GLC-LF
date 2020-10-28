
package GramaticaLivresDeContexto;

public class Alfabeto {
    String raiz;
    String[] terminais;
    String[] nãoterminais;
    
    public Alfabeto(String símboloraíz, String símbolosterminais, String símbolosnãoterminais) {
        raiz = símboloraíz;
        terminais = símbolosterminais.split("");
        nãoterminais = símbolosnãoterminais.split("");
    }
}
