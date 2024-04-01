import java.util.ArrayList;

public class BST_PairsViolatingTheBSTProperty {

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static int pairsViolatingBST(int n, Node root) {

    ArrayList<Integer> arr = new ArrayList<>();

    inorder(root, arr);

    int ans = countInversions(arr, n);

    return ans;
  }

  static void inorder(Node root, ArrayList<Integer> arr) {
    if (root == null)
      return;

    inorder(root.left, arr);
    arr.add(root.data);
    inorder(root.right, arr);
  }

  static int countInversions(ArrayList<Integer> arr, int n) {
    return mergeSort(arr, 0, n - 1);
  }

  static int mergeSort(ArrayList<Integer> arr, int start, int end) {

    if (start >= end) {
      return 0;
    }

    int mid = (start + end) / 2;

    int inversions = 0;
    inversions += mergeSort(arr, start, mid);
    inversions += mergeSort(arr, mid + 1, end);
    inversions += merge(arr, start, mid, end);

    return inversions;
  }

  static int merge(ArrayList<Integer> arr, int start, int mid, int end) {

    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();

    for (int i = start; i <= mid; i++) {
      left.add(i - start, arr.get(i));
    }

    for (int i = mid + 1; i <= end; i++) {
      right.add(i - mid - 1, arr.get(i));
    }

    int i = 0, j = 0, k = start, inversion = 0;
    while (i < left.size() && j < right.size()) {

      if (left.get(i) > right.get(j)) {
        inversion += left.size() - i;
        arr.set(k, right.get(j));
        k++;
        j++;
      } else {
        arr.set(k, left.get(i));
        i++;
        k++;
      }

    }

    while (i < left.size()) {
      arr.set(k, left.get(i));
      k++;
      i++;
    }

    while (j < right.size()) {
      arr.set(k, right.get(j));
      j++;
      k++;
    }

    return inversion;
  }
}
