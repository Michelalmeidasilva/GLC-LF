package arquivo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import versao1.GramaticaLivreDeContexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

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


  public GramaticaLivreDeContexto readJson() {
    String userDirectory =  System.getProperty("user.dir") + "/";
    String nomeDoArquivo = "glc.json";
    Gson gson = new Gson();
    System.out.println(System.getProperty("user.dir"));
    try (Reader reader = new FileReader(userDirectory + nomeDoArquivo )) {
      // Convert JSON File to Java Object
      GramaticaLivreDeContexto glc = gson.fromJson(reader, GramaticaLivreDeContexto.class);
      return glc;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}