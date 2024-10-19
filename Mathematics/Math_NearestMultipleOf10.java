public class Math_NearestMultipleOf10 {
  String roundToNearest(String s) {
    char[] c = s.toCharArray();
    int n = s.length();

    if (c[n - 1] == '0') {

      return s;

    } else if (c[n - 1] >= '1' && c[n - 1] <= '5') {

      c[n - 1] = '0';
      return new String(c);

    } else {
      c[n - 1] = '0';

      // process carry
      for (int i = n - 2; i >= 0; i--) {
        if (c[i] == '9')
          c[i] = '0';
        else {
          int t = c[i] - '0' + 1;
          c[i] = (char) (48 + t);
          return new String(c);
        }
      }
    }

    return "1" + new String(c);
  }
}
