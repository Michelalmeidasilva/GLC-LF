package tree;
import java.util.Vector;

  public class Node {
    char key;
    Vector<Node> children;

    public Node(int  key, Vector<Node> children){
      this.key = (char)key;
      this.children = children;
    }

  }


