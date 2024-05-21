import java.util.ArrayList;
import java.util.List;

public class Rec_Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;

    for (int counter = 0; counter < (int) Math.pow(2, n); counter++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((counter & (1 << j)) > 0) {
          temp.add(nums[j]);
        }
      }
      ans.add(temp);
    }

    return ans;
  }
}
