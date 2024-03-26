import java.util.ArrayList;

public class Rec_PrintNBitBinaryNoHavingMore1sthan0s {
  ArrayList<String> NBitBinary(int N) {

    ArrayList<String> ans = new ArrayList<>();
    generateString("", N, 0, 0, ans);
    return ans;
  }

  void generateString(String s, int n, int count1, int count0, ArrayList<String> ans) {

    if (s.length() == n) {
      ans.add(s);
      return;
    }

    generateString(s + "1", n, count1 + 1, count0, ans);
    if (count1 > count0) {
      generateString(s + "0", n, count1, count0 + 1, ans);
    }

  }
}
