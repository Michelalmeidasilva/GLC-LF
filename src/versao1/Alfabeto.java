
package versao2;

public class Alfabeto {
    String[] terminais;
    String[] nãoterminais;
    
    public Alfabeto(String símbolosterminaisrecebidos, String símbolosnãoterminaisrecebidos) {
        terminais = símbolosterminaisrecebidos.split("");
        nãoterminais = símbolosnãoterminaisrecebidos.split("");
    }

    public String getNãoTerminais(){
        String str = "";
        for ( String termin: nãoterminais) {
            str =  str + termin;
        }
        return str;
    }
}
