import java.util.Arrays;
import java.util.Comparator;

public class String_LargestNumberFormedFromAnArray {
  String printLargest(int n, String[] arr) {

    Comparator<String> comparator = (String a, String b) -> {

      String s1 = a + b;
      String s2 = b + a;

      return s2.compareTo(s1);
    };

    Arrays.sort(arr, comparator);

    String res = "";
    for (int i = 0; i < n; i++) {
      res += arr[i];
    }

    return res;
  }
}
