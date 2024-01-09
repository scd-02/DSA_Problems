import java.util.Arrays;

// Basically use of Comparator class (no intution)

public class Array_SortBySetBitCount {
  static void sortBySetBitCount(Integer arr[], int n) {
    Arrays.sort(arr, (i, j) -> {
      return Integer.bitCount(j) - Integer.bitCount(i);
    });
  }
}
