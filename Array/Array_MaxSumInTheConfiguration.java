public class Array_MaxSumInTheConfiguration {
  int max_sum(int A[], int n) {

    int sum = 0, currSum = 0;
    for (int i = 0; i < n; i++) {
      sum += A[i];
      currSum += A[i] * i;
    }

    int maxSum = currSum;

    for (int i = 0; i < n; i++) {
      currSum = currSum - sum + A[i] * n;
      maxSum = Math.max(maxSum, currSum);
    }

    return maxSum;
  }
}
