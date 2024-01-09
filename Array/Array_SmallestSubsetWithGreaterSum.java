import java.util.Arrays;

public class Array_SmallestSubsetWithGreaterSum {
  int minSubset(int[] arr, int n) {

    int length = 1;

    Arrays.sort(arr);

    long sum = 0;
    for (int e : arr)
      sum += e;

    long rightSum = arr[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      if (rightSum > sum - rightSum) {
        length = n - i - 1;
        break;
      }
      rightSum += arr[i];
    }

    return length;
  }
}
