import java.util.ArrayList;

public class String_SearchPattern_RabinKarp {
  int base = 579;

  ArrayList<Integer> search(String pattern, String text) {
    ArrayList<Integer> ans = new ArrayList<>();

    int p = pattern.length();
    int t = text.length();

    double patternHash = calculateHash(pattern);
    double textHash = calculateHash(text.substring(0, p));

    for (int i = 0; i <= t - p; i++) {

      if (patternHash == textHash) {
        if (pattern.equals(text.substring(i, i + p))) {
          ans.add(i + 1);
        }
      }

      if (i < t - p) {
        textHash = updatedHash(text.charAt(i), text.charAt(i + p), textHash, p);
      }

    }

    return ans;
  }

  double calculateHash(String s) {

    double hash = 0;
    for (int i = 0; i < s.length(); i++) {
      hash = hash + s.charAt(i) * Math.pow(base, i);
    }

    return hash;
  }

  double updatedHash(char oldch, char newch, double hash, int patternLen) {

    double newHash = (hash - oldch) / base;
    newHash = newHash + (newch * Math.pow(base, patternLen - 1));

    return newHash;
  }
}
