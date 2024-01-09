import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Rec_CombinationSum {
  static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    // Deleting all duplicates elements
    HashSet<Integer> hs = new HashSet<>(A);
    A = new ArrayList<>(hs);

    // Sorting for ascending order
    Collections.sort(A);

    combinations(A, 0, B, 0, temp, ans);

    return ans;

  }

  static void combinations(ArrayList<Integer> nums, int currSum, int sum, int index, ArrayList<Integer> temp,
      ArrayList<ArrayList<Integer>> ans) {

    if (currSum == sum) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    if (currSum > sum) {
      return;
    }

    for (int i = index; i < nums.size(); i++) {

      currSum = currSum + nums.get(i);
      temp.add(nums.get(i));

      combinations(nums, currSum, sum, i, temp, ans);

      currSum = currSum - nums.get(i);
      temp.remove(temp.size() - 1);
    }

  }
}
