import java.util.Arrays;

public class Dp_MaxPairWithCertainDiff {
  
  public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {

    Arrays.sort(arr);

    int sum = 0;
    int i = N - 1;
    while (i > 0) {
      if (arr[i] - arr[i - 1] < K) {
        sum += arr[i] + arr[i - 1];
        i -= 2;
      } else {
        i--;
      }
    }
    return sum;
  }
}
