public class Tree_SortedArrayToBST {

  /*
   * i/p: 1 2 3 4 5 6 7
   * o/p: 4,2,1,3,6,5,7
   */

  class Solution1 {
    int k = 0;
    int ans[];

    public int[] sortedArrayToBST(int[] nums) {

      int size = nums.length;
      int i;
      for (i = 0; i < size; i++) {
        if (Math.abs((size - 1 - i) - i) == 1 || Math.abs((size - 1 - i) - i) == 0) {
          break;
        }
      }
      ans = new int[size];
      ans[k++] = nums[i];

      preorderHB(nums, 0, i - 1);
      preorderHB(nums, i + 1, size - 1);

      return ans;
    }

    void preorderHB(int a[], int l, int h) {
      if (l > h)
        return;
      int mid = (l + h) / 2;
      ans[k++] = a[mid];
      preorderHB(a, l, mid - 1);
      preorderHB(a, mid + 1, h);

    }
  }

  class Solution2 {
    class Node {
      int val;
      Node left;
      Node right;

      Node(int val) {
        this.val = val;
        left = right = null;
      }
    }

    public Node sortedArrayToBST(int[] nums) {
      return createBST(nums, 0, nums.length - 1);
    }

    Node createBST(int[] nums, int low, int high) {

      if (low > high)
        return null;

      int mid = (low + high) / 2;

      Node root = new Node(nums[mid]);

      root.left = createBST(nums, low, mid - 1);
      root.right = createBST(nums, mid + 1, high);

      return root;
    }
  }
}
