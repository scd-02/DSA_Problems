import java.util.HashMap;
import java.util.Map;

public class Tree_DuplicateSubtreeInBinaryTree {
  int dupSub(Node root) {

    HashMap<String, Integer> map = new HashMap<>();
    solve(root, map);

    for (Map.Entry<String, Integer> ele : map.entrySet()) {

      if (ele.getValue() > 1)
        return 1;

    }

    return 0;
  }

  String solve(Node root, HashMap<String, Integer> map) {

    if (root == null)
      return "$";

    String s = "";

    if (root.left == null && root.right == null) {
      s = "" + root.data;
      return s;
    }

    s = s + root.data;
    s = s + solve(root.left, map);
    s = s + solve(root.right, map);

    map.put(s, map.getOrDefault(s, 0) + 1);

    return s;
  }
}
