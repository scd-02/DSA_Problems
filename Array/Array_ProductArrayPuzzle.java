public class Array_ProductArrayPuzzle {
  public static long[] productExceptSelf(int nums[], int n) {
    long ans[] = new long[n];
    ans[0] = nums[0];

    for (int i = 1; i < n; i++) {
      ans[i] = nums[i] * ans[i - 1];
    }

    long product = 1;

    for (int i = n - 1; i >= 1; i--) {
      ans[i] = product * ans[i - 1];
      product = product * nums[i];
    }

    ans[0] = product;
    return ans;
  }

  public static void main(String[] args) {
    int a[] = { 7, 8, 6, 4, 6, 7, 3, 10, 2, 3, 8, 1, 10, 4, 7, 1, 7, 3, 7, 2, 9, 8, 10, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1,
        1 };
    long[] ans = productExceptSelf(a, a.length);
    for (long e : ans) {
      System.out.println(e);
    }

  }
}
