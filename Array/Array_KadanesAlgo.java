public class Array_KadanesAlgo {
    long maxSubarraySum(int a[], int n) {

        long maxSum = Integer.MIN_VALUE;

        long currSum = 0;

        for (int i = 0; i < n; i++) {

            currSum += a[i];
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;

    }
}
