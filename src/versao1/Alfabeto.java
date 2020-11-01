
package versao1;

public class Alfabeto {
    String[] terminais;
    String[] naoTerminais;
    
    public Alfabeto(String símbolosterminaisrecebidos, String símbolosnãoterminaisrecebidos) {
        terminais = símbolosterminaisrecebidos.split("");
        naoTerminais = símbolosnãoterminaisrecebidos.split("");
    }

    public String getNãoTerminais(){
        String str = "";
        for ( String termin: naoTerminais) {
            str =  str + termin;
        }
        return str;
    }
}
