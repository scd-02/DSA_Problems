import java.util.Arrays;

public class Array_IntersectionOfTwoArrays2 {
  public int[] intersect(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int res[] = new int[Math.min(n, m)];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {

      if (nums1[i] == nums2[j]) {
        res[k++] = nums1[i];
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }

    }

    return Arrays.copyOfRange(res, 0, k);
  }
}
