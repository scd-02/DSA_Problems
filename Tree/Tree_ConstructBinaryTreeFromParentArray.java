import java.util.HashMap;

public class Tree_ConstructBinaryTreeFromParentArray {
  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  public Node createTree(int parent[]) {

    HashMap<Integer, Node> nodeMap = new HashMap<>();

    Node root = null;

    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == -1) {

        if (nodeMap.containsKey(i)) {
          root = nodeMap.get(i);
        } else {
          root = new Node(i);
          nodeMap.put(i, root);
        }

      } else {
        int child = i, par = parent[i];

        if (!nodeMap.containsKey(child) && !nodeMap.containsKey(par)) {
          nodeMap.put(child, new Node(child));
          nodeMap.put(par, new Node(par));

        } else if (!nodeMap.containsKey(child)) {
          nodeMap.put(child, new Node(child));
        } else if (!nodeMap.containsKey(par)) {
          nodeMap.put(par, new Node(par));
        }

        if (nodeMap.get(par).left == null) {
          nodeMap.get(par).left = nodeMap.get(child);
        } else {
          nodeMap.get(par).right = nodeMap.get(child);
        }
      }
    }

    return root;
  }
}
