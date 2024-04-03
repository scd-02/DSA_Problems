public class Maths_SumOfAllSubstringsOfANo {
  public static long sumSubstrings(String s) {
    long mod = 1000_000_000 + 7;
    long prev = s.charAt(0) - '0';
    long ans = prev;

    for (int i = 1; i < s.length(); i++) {

      prev = ((prev * 10) % mod + ((s.charAt(i) - '0') * (i + 1)) % mod) % mod;
      ans = (ans % mod + prev % mod) % mod;

    }

    return ans;
  }
}
