
package gramáticalivredecontexto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nódulo {
    String[] data;
    Nódulo pai;
    List<Nódulo> filhos;
    
    public Nódulo(String[] datarecebida, Nódulo pairecebido) {
        this.data = datarecebida;
        this.pai = pairecebido;
        this.filhos = new ArrayList<>();
    }
}
