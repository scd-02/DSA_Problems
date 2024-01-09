public class Maths_AddBinary {
  public String addBinary(String a, String b) {

    int s1 = a.length() - 1;
    int s2 = b.length() - 1;
    int carry = 0;

    StringBuilder s = new StringBuilder();

    while (s1 >= 0 || s2 >= 0 || carry != 0) {
      int charA = s1 >= 0 ? a.charAt(s1) - '0' : 0;
      int charB = s2 >= 0 ? b.charAt(s2) - '0' : 0;

      int sum = charA + charB + carry;

      s.insert(0, sum % 2);
      carry = sum / 2;

      s1--;
      s2--;
    }

    return s.toString();
  }
}
