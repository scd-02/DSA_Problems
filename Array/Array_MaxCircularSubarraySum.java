public class Array_MaxCircularSubarraySum {
  public int circularSubarraySum(int arr[]) {

    int maxSum = Integer.MIN_VALUE;
    int minSum = Integer.MAX_VALUE;

    int maxCurrSum = 0;
    int minCurrSum = 0;

    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      maxCurrSum += arr[i];
      minCurrSum += arr[i];

      maxSum = Math.max(maxCurrSum, maxSum);
      minSum = Math.min(minCurrSum, minSum);

      maxCurrSum = Math.max(0, maxCurrSum);
      minCurrSum = Math.min(0, minCurrSum);
    }

    if (maxSum < 0)
      return maxSum;

    // System.out.println(maxSum + " " + sum + " " + minSum);

    return Math.max(maxSum, sum - minSum);

  }
}
