package tree;// Java program to find the height of
// an N-ary tree 
import java.util.*;

public class BinarySearchTree {

  Node newNode(int key) {
    Node temp = new Node(key, new Vector<Node>());
    return temp;
  }

  int depthOfTree(Node ptr) {
    // Base case
    if (ptr == null)
    return 0;

    // checa todos nós filhos
    int maxdepth = 0;
    for (Node it : ptr.children){
      System.out.println(it.key);
      maxdepth = Math.max(maxdepth, depthOfTree(it));
    }
    return maxdepth + 1 ;
  }

}