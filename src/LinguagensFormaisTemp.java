import java.util.ArrayList;

public class LinguagensFormaisTemp {


  public static void main(String[] args) throws Exception {
    ArrayList<Character> variaveis = new ArrayList();
    ArrayList<Character> terminais = new ArrayList();
    ArrayList<String> regras = new ArrayList();
    char raiz = 'E';
    variaveis.add('E');
    variaveis.add('I');
    variaveis.add('a');
    variaveis.add('b');
    variaveis.add('c');
    variaveis.add('+');
    variaveis.add('*');
    variaveis.add('(');
    variaveis.add(')');

    terminais.add('a');
    terminais.add('b');
    terminais.add('c');
    terminais.add('+');
    terminais.add('*');
    terminais.add('(');
    terminais.add(')');

    regras.add("E -> I|E*E");
    regras.add("E -> E + E");
    regras.add("E -> (E)");
    regras.add("E -> a");
    regras.add("E -> c");
    regras.add("I -> a");
    regras.add("I -> b");
    regras.add("I -> Ia");
    regras.add("I -> Ib");

    System.out.println("teste");
    GLC teste = new GLC(variaveis,terminais,regras,raiz);
    System.out.println(teste.derivar("aaaaa"));
    System.out.println("teste");

    // E -> E*E | E*E - > I*E+E | I*E+E - > Ia*a+c | Ia*a+c - > aa*a+c
    System.out.println(teste.toString());
  }
}