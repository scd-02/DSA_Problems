public class String_SumString {
  public int isSumString(String S) {

    int n = S.length();

    for (int i = 1; i < n; i++) {
      for (int j = 1; i + j < n; j++) {

        if (check(S, 0, i, j, n)) {
          return 1;
        }

      }
    }

    return 0;
  }

  public boolean check(String s, int start, int l1, int l2, int n) {

    String s1 = s.substring(start, start + l1);
    String s2 = s.substring(start + l1, start + l1 + l2);

    String s3 = addString(s1, s2);
    int l3 = s3.length();

    if (l3 > n - start - l1 - l2)
      return false;

    if (s3.equals(s.substring(start + l1 + l2, start + l1 + l2 + l3))) {

      if (start + l1 + l2 + l3 == n)
        return true;

      return check(s, start + l1, l2, l3, n);
    }

    return false;
  }

  public String addString(String s1, String s2) {

    String result = "";
    int carry = 0;

    int i = s1.length() - 1;
    int j = s2.length() - 1;

    while (i >= 0 || j >= 0 || carry != 0) {
      int a = i < 0 ? 0 : s1.charAt(i) - '0';
      int b = j < 0 ? 0 : s2.charAt(j) - '0';

      int sum = a + b + carry;
      carry = sum / 10;

      result = (sum % 10) + result;
      i--;
      j--;
    }

    return result;
  }
}
