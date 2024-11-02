import java.util.HashSet;

public class SW_KthDistance {
  /*
   * Given an unsorted array arr and a number k which is smaller than the size of
   * the array. Return true if the array contains any duplicate within k distance
   * throughout the array else false.
   * 
   * 
   * Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3 
   * Output: false
   * Explanation: All duplicates are more than k distance away.
   */
  public boolean checkDuplicatesWithinK(int[] arr, int k) {
    HashSet<Integer> hs = new HashSet<>();

    int s = 0;

    // initial window
    for (int i = 0; i < k; i++) {
      if (hs.contains(arr[i]))
        return true;

      hs.add(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (hs.contains(arr[i]))
        return true;

      hs.remove(arr[s]);
      s++;
      hs.add(arr[i]);
    }

    return false;
  }
}
