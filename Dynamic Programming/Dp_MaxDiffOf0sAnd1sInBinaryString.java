public class Dp_MaxDiffOf0sAnd1sInBinaryString {
  int maxSubstring(String S) {

    int arr[] = new int[S.length()];

    for (int i = 0; i < arr.length; i++) {

      if (S.charAt(i) == '1')
        arr[i] = -1;
      else
        arr[i] = 1;

    }

    return kadanesAlgo(arr);
  }

  int kadanesAlgo(int arr[]) {

    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {

      currSum += arr[i];

      maxSum = Math.max(currSum, maxSum);

      if (currSum < 0)
        currSum = 0;

    }

    return maxSum;
  }
}
