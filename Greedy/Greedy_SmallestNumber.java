public class Greedy_SmallestNumber {
  public String smallestNumber(int s, int d) {

    if ((d == 1 && s > 9) || (s > 9 * d))
      return "-1";

    String ans = "";

    s--;

    while (d > 0) {

      if (s > 9) {
        ans = 9 + ans;
        s -= 9;
      } else if (s <= 9 && d > 1) {
        ans = s + ans;
        s = 0;
      } else {
        ans = (s + 1) + ans;
      }

      d--;
    }

    return ans;
  }
}
