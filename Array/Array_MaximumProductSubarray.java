public class Array_MaximumProductSubarray {
  int maxProduct(int[] arr) {
    int n = arr.length;

    int maxProduct = Integer.MIN_VALUE;
    int leftToRight = 1, rightToLeft = 1;

    for (int i = 0; i < n; i++) {
      if (leftToRight == 0)
        leftToRight = 1;
      if (rightToLeft == 0)
        rightToLeft = 1;

      leftToRight *= arr[i];
      rightToLeft *= arr[n - 1 - i];

      maxProduct = Math.max(maxProduct, Math.max(leftToRight, rightToLeft));
    }

    return maxProduct;
  }
}
