import java.util.HashMap;

public class HashMap_SubarrayRangeWithGivenSum {
  int subArraySum(int arr[], int tar) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    freq.put(0, 1);

    int currSum = 0;
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      currSum += arr[i];

      if (freq.containsKey(currSum - tar)) {
        count += freq.get(currSum - tar);
      }

      freq.put(currSum, freq.getOrDefault(currSum, 0) + 1);
    }

    return count;
  }
}
