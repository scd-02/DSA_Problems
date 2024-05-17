import java.util.Arrays;

public class Sorting_FindPairWithGivenDifference {
  public int findPair(int n, int x, int[] arr) {

    Arrays.sort(arr);

    int s = 0, e = 1;

    while (s < n && e < n) {
      int diff = arr[e] - arr[s];

      if (diff == x && s != e)
        return 1;
      else if (s == e)
        e++;
      else if (diff < x)
        e++;
      else
        s++;
    }

    return -1;
  }
}
