import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rec_UniquePermutationOfString {
  public List<String> find_permutation(String S) {

    List<String> ans = new ArrayList<>();
    permutations(S, 0, ans);
    Collections.sort(ans);
    return ans;

  }

  public static void permutations(String ip, int i, List<String> ans) {

    // base case
    if (ip.length() == i) {

      if (!ans.contains(ip)) {
        ans.add(ip);
      }

      return;
    }

    for (int j = i; j < ip.length(); j++) {
      ip = swap(ip, i, j);
      permutations(ip, i + 1, ans);
      ip = swap(ip, i, j);
    }

  }

  public static String swap(String s, int i, int j) {

    char[] arr = s.toCharArray();

    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    return String.valueOf(arr);

  }
}
