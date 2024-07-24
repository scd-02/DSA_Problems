import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting_SortTheJumbledNumbers {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    int n = nums.length;

    List<int[]> mappedNums = new ArrayList<int[]>();

    for (int i = 0; i < n; i++) {
      mappedNums.add(new int[] { convert(mapping, nums[i]), i });
    }

    Collections.sort(mappedNums, (a, b) -> a[0] - b[0]);

    int ans[] = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = nums[mappedNums.get(i)[1]];
    }

    return ans;
  }

  int convert(int[] mapping, int num) {
    if (num == 0)
      return mapping[0];

    int place = 1;
    int mappedValue = 0;

    while (num != 0) {
      mappedValue = place * mapping[num % 10] + mappedValue;
      place *= 10;
      num /= 10;
    }

    return mappedValue;
  }
}
