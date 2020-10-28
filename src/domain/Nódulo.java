
package domain;

import java.util.ArrayList;
import java.util.List;

public class Nódulo {
    String[] data;
    Nódulo pai;
    List<Nódulo> filhos = new ArrayList<Nódulo>();
    List<Nódulo> Irmãos = new ArrayList<Nódulo>();

    public Nódulo(String[] data, Nódulo pai, Nódulo irmãoesquerdo, Nódulo irmãodireito, List<Nódulo> filhos){
        this.data =data;
        this.pai =pai;
        this.filhos = filhos;
    }

    public Nódulo(){
    };

    public String dataToString() {
        String dataStr = "";
        for (int i = 0; i <this.data.length ; i++) {
            dataStr = dataStr + ""+this.data[i];
        }
        return dataStr;
    }


}
