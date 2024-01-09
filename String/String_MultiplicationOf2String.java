public class String_MultiplicationOf2String {

  public String multiplyStrings(String s1, String s2) {

    StringBuilder str1 = new StringBuilder(s1);
    StringBuilder str2 = new StringBuilder(s2);

    boolean sign = false;

    if ((s1.charAt(0) == '-' && s2.charAt(0) != '-')) {
      sign = true;
      str1.deleteCharAt(0);
    } else if ((s1.charAt(0) != '-' && s2.charAt(0) == '-')) {
      sign = true;
      str2.deleteCharAt(0);
    } else if ((s1.charAt(0) == '-' && s2.charAt(0) == '-')) {
      sign = false;
      str1.deleteCharAt(0);
      str2.deleteCharAt(0);
    }

    StringBuilder ans = multiply(str1, str2, str1.length(), str2.length());

    // removal of 0s
    while (ans.length() != 0 && ans.charAt(0) == '0') {
      ans.deleteCharAt(0);
    }

    if (sign) {
      ans.insert(0, "-");
    }

    return ans.toString();
  }

  public StringBuilder multiply(StringBuilder s1, StringBuilder s2, int n1, int n2) {

    int prev[] = new int[n1 + n2 + 1];
    StringBuilder ans = new StringBuilder("");

    int i = n2 - 1, prevBack = 0;
    while (i >= 0) {

      int j = n1 - 1;
      int prevTrav = prev.length - 1 - prevBack;
      int carry = 0;
      int num2 = s2.charAt(i) - '0';

      while (j >= 0 || carry != 0) {

        int num1 = j >= 0 ? s1.charAt(j) - '0' : 0;
        int product = (num1 * num2) + carry + prev[prevTrav];

        prev[prevTrav] = product % 10;
        carry = product / 10;

        j--;
        prevTrav--;
      }

      i--;
      prevBack++;
    }

    for (int k = prev.length - 1; k >= 0; k--) {
      ans.insert(0, prev[k]);
    }

    return ans;
  }
}