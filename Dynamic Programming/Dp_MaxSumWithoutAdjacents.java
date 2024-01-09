public class Dp_MaxSumWithoutAdjacents {
  int findMaxSum_Dp(int arr[], int n) {

    if (n == 1)
      return arr[0];

    int prev3 = arr[0];
    int prev2 = arr[1];

    if (n == 2)
      return Math.max(prev3, prev2);

    int prev1 = arr[2] + arr[0];

    for (int i = 3; i < n; i++) {

      int curr = arr[i] + Math.max(prev3, prev2);

      prev3 = prev2;
      prev2 = prev1;
      prev1 = curr;
    }

    return Math.max(prev1, prev2);
  }
}
