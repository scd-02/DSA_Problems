public class Sorting_CountingSort {
  public int[] sortArray(int[] nums) {

    int min = nums[0], max = nums[0];

    for (int ele : nums) {
      min = Math.min(min, ele);
      max = Math.max(max, ele);
    }

    int n = max - min;
    int count[] = new int[n + 1];

    for (int ele : nums) {
      count[ele - min]++;
    }

    int i = 0;

    for (int ind = 0; ind <= n; ind++) {
      while (count[ind] > 0) {
        count[ind]--;
        nums[i] = min;
        i++;
      }
      min++;
    }

    return nums;
  }
}
