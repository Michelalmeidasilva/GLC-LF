
package versao2;

import java.util.ArrayList;

public class Nódulo {
    String[] data;
    String value;
    int nivel = 0;
    Nódulo pai;
    ArrayList<Nódulo> filhos = new ArrayList<>();
    
    public Nódulo(String[] datarecebida, Nódulo pairecebido , int nivel ) {
        this.data = datarecebida;
        this.pai = pairecebido;
        this.nivel = nivel;
    }

    public Nódulo() {
    }

    public String getData() {
        String dataString= "";
        for (int i = 0; i < data.length; i++) {
            dataString = dataString + data[i];
        }
        return dataString;
    }
}
