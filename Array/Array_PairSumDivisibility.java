public class Array_PairSumDivisibility {
  public boolean canPair(int[] nums, int k) {

    if (nums.length % 2 == 1)
      return false;

    int[] arr = new int[k];

    for (int i : nums)
      arr[i % k]++;

    int low = 1, high = k - 1;
    while (low <= high) {

      if (arr[low] != arr[high])
        return false;

      low++;
      high--;
    }

    return true;
  }
}
