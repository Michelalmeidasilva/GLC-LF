package arquivo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.GramaticaLivreDeContexto;

import java.io.*;

public class JsonFormatter {
  GramaticaLivreDeContexto glc;

  public JsonFormatter(GramaticaLivreDeContexto glc) {
    this.glc = glc;
  }

  public JsonFormatter() {
  }

  public void writeObject(GramaticaLivreDeContexto glc, String nome) {
    String userDirectory =  System.getProperty("user.dir") + "/";
    String nomeDoArquivo = nome+".json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(glc);
    try (FileWriter writer = new FileWriter(userDirectory + nomeDoArquivo)) {
      gson.toJson(glc, writer);
      System.out.println("Arquivo criado com sucesso no diretorio:" + userDirectory + nomeDoArquivo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public GramaticaLivreDeContexto readJson(String nome, boolean diretorioAtual) throws FileNotFoundException {
    String userDirectory ;
    String nomeDoArquivo ;
    String pathAbsoluto;
    if(diretorioAtual){
     userDirectory =  System.getProperty("user.dir") + "/";
     nomeDoArquivo = nome + ".json";
     pathAbsoluto = userDirectory + nomeDoArquivo;
    } else {
      pathAbsoluto = nome;
    }
    System.out.println("Leitura do arquivo" + pathAbsoluto);
    Gson gson = new Gson();
    Reader reader = new FileReader(pathAbsoluto );
    GramaticaLivreDeContexto glc = gson.fromJson(reader, GramaticaLivreDeContexto.class);
    return glc;

  }

}