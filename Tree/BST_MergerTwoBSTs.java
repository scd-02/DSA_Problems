import java.util.ArrayList;
import java.util.List;

public class BST_MergerTwoBSTs {
  class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  public List<Integer> merge(Node root1, Node root2) {

    List<Integer> head1 = new ArrayList<>();
    inorder(root1, head1);
    List<Integer> head2 = new ArrayList<>();
    inorder(root2, head2);

    int n1 = head1.size(), n2 = head2.size();
    List<Integer> ans = new ArrayList<>();

    int i = 0, j = 0;

    while (i < n1 && j < n2) {
      if (head1.get(i) <= head2.get(j)) {
        ans.add(head1.get(i));
        i++;
      } else {
        ans.add(head2.get(j));
        j++;
      }
    }

    while (i < n1) {
      ans.add(head1.get(i));
      i++;
    }

    while (j < n2) {
      ans.add(head2.get(j));
      j++;
    }

    return ans;
  }

  void inorder(Node root, List<Integer> arr) {
    if (root == null)
      return;

    inorder(root.left, arr);
    arr.add(root.data);
    inorder(root.right, arr);
  }
}
