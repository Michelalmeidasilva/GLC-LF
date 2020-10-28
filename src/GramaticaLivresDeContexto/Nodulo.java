
package GramaticaLivresDeContexto;

import java.util.List;

public class Nodulo {
    String[] data;
    Nodulo pai;
    Nodulo irmãoesquerdo;
    Nodulo irmãodireito;
    List<Nodulo> filhos;

    public String getData() {
        String dataString = "";
        for (int i = 0; i <data.length ; i++) {
            dataString = dataString + ""+data[i];
        }
        return dataString;
    }
}
