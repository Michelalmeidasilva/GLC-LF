//
//package versao2;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.TreeSet;
//
//public class Árvore {
//  List<Nódulo> fila = new ArrayList<>();
//  Nódulo raíz;
//  Regras regras;
//  Alfabeto alfabeto;
//  TreeSet<String> palavrasGeradas = new TreeSet<String>();
//  int qtdGerada;
//  public Árvore(String datarecebida, Alfabeto alfabeto, Regras regras) {
//    raíz = new Nódulo(datarecebida.split(""), null, 0);
//    this.alfabeto = alfabeto;
//    this.regras = regras;
//  }
//
//  public void imprimirÁrvore(Alfabeto alfabeto) {
////    fila.add(raíz);
//    preencherNodulos(this.raíz);
//    while(!fila.isEmpty() ) {
//      Nódulo auxiliar = fila.remove(0);
//      for(int x = 0; x < auxiliar.data.length; x++) {
//        for(int y = 0; y < alfabeto.terminais.length; y++) {
//          if(auxiliar.data[x].contains(alfabeto.terminais[y]) && auxiliar.data.length == 1) {
//            String[] meio = auxiliar.data;
//            String[] stringauxiliar;
//            while(auxiliar.pai != null) {
//              stringauxiliar = auxiliar.pai.data.clone();
//              for(int z = 0; z < stringauxiliar.length; z++) {
//                for(int w = 0; w < alfabeto.nãoterminais.length; w++) {
//                  if(stringauxiliar[z].contains(alfabeto.nãoterminais[w])) {
//                    stringauxiliar[z] = Arrays.toString(meio);
//                    meio = stringauxiliar;
//                  }
//                }
//              }
//              String formattedString = Arrays.toString(stringauxiliar)
//                .replace(",", "")  //remove the commas
//                .replace("[", "")  //remove the right bracket
//                .replace("]", "")  //remove the left bracket
//                .trim();           //remove trailing spaces from partially initialized arrays
//              palavrasGeradas.add(formattedString);
//              auxiliar = auxiliar.pai;
//            }
//          }
//        }
//      }
//    }
//  }
//
//  public void preencherÁrvore(int quantidade) {
//    fila.add(raíz);
//    while(qtdGerada < 40) {
//      Nódulo pai = fila.remove(0);
//      for(int x = 0; x < pai.data.length; x++) {
//
//        for(int y = 0; y < alfabeto.nãoterminais.length; y++) {//2
//          if(pai.data[x].contains(alfabeto.nãoterminais[y])) {//3
//            for(int z = 0; z < regras.matrizregras.length; z++) {//4
//              qtdGerada++;
//              if(pai.data[x].contains(regras.matrizregras[z][0])) {//5
//                Nódulo novo = new Nódulo(regras.matrizregras[z][1].split(""), pai ,0);
//                pai.filhos.add(novo);
//                fila.add(novo);
//              }
//            }
//          }
//        }
//      }
//    }
//    fila.clear();
//  }
//
//
//  void preencherNodulos(Nódulo raiz){
//      for ( Nódulo node: raiz.filhos){
//        fila.add(node);
//        preencherNodulos(node);
//      }
//    return ;
//  }
//}
