import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree_DuplicateSubtrees {
  Map<String, Integer> map = new HashMap<>();
  List<Node> res = new ArrayList<>();

  public List<Node> printAllDups(Node root) {
    traverse(root);
    return res;
  }

  private String traverse(Node node) {
    if (node == null)
      return "";

    String str = traverse(node.left) + "-" + node.data + "-" + traverse(node.right);

    map.put(str, map.getOrDefault(str, 0) + 1);

    if (map.get(str) == 2)
      res.add(node);

    return str;
  }
}
