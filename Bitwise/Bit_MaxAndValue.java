public class Bit_MaxAndValue {
  public static int maxAND(int arr[], int N) {

    // Your code here
    // You can add extra function (if required)
    int res = 0;

    for (int i = 31; i >= 0; i--) {

      int mask = 1 << i;

      int count = similarPattern(arr, N, (res | mask));

      if (count > 1) {
        res = res | mask;
      }

    }

    return res;
  }

  static int similarPattern(int arr[], int n, int pattern) {

    int count = 0;

    for (int i = 0; i < n; i++) {
      if ((pattern & arr[i]) == pattern)
        count++;
    }

    return count;
  }

}
