public class Maths_LargestNumberPossible {
  static String findLargest(int N, int S) {

    if (S > N * 9 || (N != 1 && S == 0))
      return "-1";

    String ans = "";

    for (int i = 1; i <= N; i++) {

      if (S >= 9) {
        ans = ans + 9;
        S = S - 9;
      } else if (S >= 1 && S < 9) {
        ans = ans + S;
        S = 0;
      } else {
        ans = ans + 0;
      }

    }

    return ans;
  }
}
