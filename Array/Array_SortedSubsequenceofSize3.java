import java.util.ArrayList;
import java.util.List;

public class Array_SortedSubsequenceofSize3 {
  public List<Integer> find3Numbers(int[] arr) {

    int n = arr.length;

    int leftMin[] = new int[n];
    int rightMax[] = new int[n];

    leftMin[0] = arr[0];
    rightMax[n - 1] = arr[n - 1];

    for (int i = 1; i < n; i++) {

      leftMin[i] = Math.min(arr[i], leftMin[i - 1]);
      rightMax[n - 1 - i] = Math.max(arr[n - 1 - i], rightMax[n - i]);

    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i < n - 1; i++) {
      if (arr[i] > leftMin[i - 1] && arr[i] < rightMax[i + 1]) {
        ans.add(leftMin[i - 1]);
        ans.add(arr[i]);
        ans.add(rightMax[i + 1]);
        break;
      }
    }

    return ans;
  }
}
