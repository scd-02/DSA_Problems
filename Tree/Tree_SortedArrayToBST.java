public class Tree_SortedArrayToBST {

  /*
   * i/p: 1 2 3 4 5 6 7
   * o/p: 4,2,1,3,6,5,7
   */

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
