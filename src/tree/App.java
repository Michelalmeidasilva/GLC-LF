package tree;

public class App {

  public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();
    /* Let us create below tree
                  A
            /   /   \       \
          B    F     D       E
         /  \         \    /  |  \
         K   J         G  C   H   I
         /\                    \
        N  M                    L
                                 \
                                  O
     */

//    Node root = bst.newNode(new char[]{'A'});
    Node root = bst.newNode('A');
    (root.children).add(bst.newNode('B'));
    (root.children).add(bst.newNode('F'));
    (root.children).add(bst.newNode('D'));
    (root.children).add(bst.newNode('E'));
    (root.children.get(0).children).add(bst.newNode('K'));
    (root.children.get(0).children).add(bst.newNode('J'));
    (root.children.get(2).children).add(bst.newNode('G'));
    (root.children.get(3).children).add(bst.newNode('C'));
    (root.children.get(3).children).add(bst.newNode('H'));
    (root.children.get(3).children).add(bst.newNode('I'));
    (root.children.get(0).children.get(0).children).add(bst.newNode('N'));
    (root.children.get(0).children.get(0).children).add(bst.newNode('M'));
    (root.children.get(3).children.get(2).children).add(bst.newNode('L'));
//      System.out.println("Inicio");
      System.out.print("tamanho"+ bst.depthOfTree(root) + "\n");

  }


}
