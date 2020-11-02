package main.arquivo;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.gramatica.GLC;

import java.io.*;

public class JsonFormatter {

  /**
   * @author Michel Silva
   * Recebe um objeto gramatica para ser escrito
   * em JSON
   * @param gramatica
   * @param nome
   */
  public void writeObject(GLC gramatica, String nome)   {
    String userDirectory =  System.getProperty("user.dir") + "/";
    String nomeDoArquivo;
    String test = "";
    if(nome.length()> 5){
      test = nome.substring(nome.length() -5 , nome.length());
    }
    if(test.equals(".json")){
      nomeDoArquivo= nome;
    }else {
      nomeDoArquivo = nome +  ".json";
    }

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
      @Override
      public boolean shouldSkipField(FieldAttributes f) {
        return f.getName().contains("_");
      }
      @Override
      public boolean shouldSkipClass(Class<?> aClass) {
        return false;
      }
    });

    Gson gson = gsonBuilder.setPrettyPrinting().create();
    try (FileWriter writer = new FileWriter(userDirectory + nomeDoArquivo)) {
      gson.toJson(gramatica, writer);
      if(gramatica.is_gramaticaValida()) System.out.println("Arquivo criado com sucesso no diretorio:" + userDirectory + nomeDoArquivo);
      else return;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @author Michel Silva
   * Le um caminho do usuario para leitura de arquivo
   * @param nome
   * @param diretorioAtual
   * @return
   * @throws FileNotFoundException
   */
  public GLC readJson(String nome, boolean diretorioAtual) throws FileNotFoundException {
    String userDirectory= System.getProperty("user.dir") + "/";
    String nomeDoArquivo=nome;
    String pathAbsoluto = userDirectory + nomeDoArquivo;
    if(!diretorioAtual){
      pathAbsoluto = nome;
    }
    System.out.println("arquivo:" + pathAbsoluto);
    Gson gson = new Gson();
    Reader reader = new FileReader(pathAbsoluto );
    // Convert JSON File to Java Object
    GLC gramatica = gson.fromJson(reader, GLC.class);

    return gramatica;
  }
}
