import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rec_CombinationSum2 {
  public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {

    Arrays.sort(arr);

    List<List<Integer>> ans = new ArrayList<>();
    rec(arr, n, 0, 0, k, new ArrayList<>(), ans);

    return ans;

  }

  public void rec(int arr[], int n, int index, int sum, int k, List<Integer> temp, List<List<Integer>> ans) {

    if (sum == k) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    if (sum > k)
      return;

    for (int i = index; i < n; i++) {
      if (i > index && arr[i] == arr[i - 1])
        continue;

      temp.add(arr[i]);
      sum += arr[i];
      rec(arr, n, i + 1, sum, k, temp, ans);
      temp.remove(temp.size() - 1);
      sum -= arr[i];

    }

  }
}
