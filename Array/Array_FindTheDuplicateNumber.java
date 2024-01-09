public class Array_FindTheDuplicateNumber {

  // using binary search without space and sorting

  public int findDuplicate(int[] nums) {

    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int count = 0;

      for (int e : nums) {
        if (e <= mid)
          count++;
      }

      if (count <= mid)
        low = mid + 1;
      else
        high = mid - 1;
    }

    return low;
  }
}
