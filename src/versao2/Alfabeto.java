
package versao2;

public class Alfabeto {
    private String[] terminais;
    private String[] nãoterminais;
    
    public Alfabeto(String símbolosterminaisrecebidos, String símbolosnãoterminaisrecebidos) {
        terminais = símbolosterminaisrecebidos.split("");
        nãoterminais = símbolosnãoterminaisrecebidos.split("");
    }

    public Alfabeto(){

    }

    public String getNãoTerminais(){
        String str = "";
        for ( String termin: nãoterminais) {
            str =  str + termin;
        }
        return str;
    }

    public String getTerminais(){
        String str = "";
        for ( String termin: terminais) {
            str =  str + termin;
        }
        return str;
    }


    public void setTerminais(String terminais) {
        this.terminais = terminais.split("");
    }

    public void setNaoTerminais(String NaoTerminais){
        this.nãoterminais = NaoTerminais.split("");
    }

    public boolean validacaoTerminais(){
        if (getNãoTerminais().contains(getTerminais()) == false){
            return true;
        }
        return false;
    }

}
