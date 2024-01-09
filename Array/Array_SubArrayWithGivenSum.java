import java.util.ArrayList;

public class Array_SubArrayWithGivenSum {
  static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
    ArrayList<Integer> ans = new ArrayList<>();

    int currSum = 0;
    int pointer = 0;

    for (int i = 0; i < n; i++) {

      currSum += arr[i];

      while (currSum > sum && pointer < i) {
        currSum = currSum - arr[pointer];
        pointer++;
      }

      if (currSum == sum) {
        ans.add(pointer + 1);
        ans.add(i + 1);
        break;
      }
    }

    if (ans.size() == 0) {
      ans.add(-1);
      return ans;
    }

    return ans;
  }
}
