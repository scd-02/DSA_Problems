import java.util.List;

public class Array_MaximumProductSubsetOfAnArrray {
  public long findMaxProduct(List<Integer> arr) {
    int n = arr.size();
    int mod = 1_000_000_000 + 7;

    long product = 1;

    int count_0 = 0, count_neg = 0;
    int max_neg = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      if (arr.get(i) == 0) {
        count_0++;
        continue;
      }

      if (arr.get(i) < 0) {
        count_neg++;
        max_neg = Math.max(max_neg, arr.get(i));
      }

      product = (product % mod * arr.get(i) % mod) % mod;

    }

    if (count_0 == n)
      return 0;

    if (count_neg % 2 == 1) {

      if (count_neg == 1 && count_0 == n - 1)
        return 0;

      product /= max_neg;
    }

    return product;
  }
}
