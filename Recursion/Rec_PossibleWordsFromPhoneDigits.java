import java.util.ArrayList;

public class Rec_PossibleWordsFromPhoneDigits {
  static ArrayList<String> possibleWords(int a[], int N) {
    ArrayList<String> ans = new ArrayList<>();
    String[] numsVal = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    int index = 0;
    ArrayList<Character> output = new ArrayList<>();

    solve(a, numsVal, index, output, N, ans);

    return ans;

  }

  static void solve(int a[], String[] numsVal, int index, ArrayList<Character> output, int n, ArrayList<String> ans) {

    if (index == n) {
      String result = "";
      for (Character ch : output) {
        result += ch;
      }
      ans.add(result);
      return;
    }

    int number = a[index];
    String corresponding_String = numsVal[number];

    for (int i = 0; i < corresponding_String.length(); i++) {

      output.add(corresponding_String.charAt(i));
      solve(a, numsVal, index + 1, output, n, ans);
      output.remove(output.size() - 1);

    }
  }
}
