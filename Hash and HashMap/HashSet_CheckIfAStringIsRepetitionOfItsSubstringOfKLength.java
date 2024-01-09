import java.util.HashSet;

public class HashSet_CheckIfAStringIsRepetitionOfItsSubstringOfKLength {
  int kSubstrConcat(int n, String s, int k) {
    if (n % k != 0)
      return 0;

    HashSet<String> hs = new HashSet<>();

    for (int i = 0; i < n; i += k) {
      hs.add(s.substring(i, i + k));
    }

    return (hs.size() == 1 || hs.size() == 2) ? 1 : 0;
  }
}
