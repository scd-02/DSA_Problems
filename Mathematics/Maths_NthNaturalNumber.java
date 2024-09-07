public class Maths_NthNaturalNumber {
  long findNth(long n) {

    // convert base 10 to base 9
    String ans = "";
    while (n > 0) {

      ans = (n % 9) + ans;
      n /= 9;
    }

    return Long.valueOf(ans);
  }
}
