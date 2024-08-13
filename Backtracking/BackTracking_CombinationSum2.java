import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking_CombinationSum2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);

    backtrack(candidates, target, 0, ans, new ArrayList<>());
    return ans;
  }

  void backtrack(int[] candidates, int targetLeft, int index, List<List<Integer>> ans, List<Integer> temp) {

    if (targetLeft < 0)
      return;

    if (targetLeft == 0) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for (int i = index; i < candidates.length && targetLeft >= candidates[i]; i++) {
      if (i > index && candidates[i] == candidates[i - 1])
        continue;

      temp.add(candidates[i]);
      backtrack(candidates, targetLeft - candidates[i], i + 1, ans, temp);
      temp.remove(temp.size() - 1);
    }

  }
}
