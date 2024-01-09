public class String_RomanToDecimal {
  public int romanValue(char ch) {

    if (ch == 'I')
      return 1;
    if (ch == 'V')
      return 5;
    if (ch == 'X')
      return 10;
    if (ch == 'L')
      return 50;
    if (ch == 'C')
      return 100;
    if (ch == 'D')
      return 500;
    if (ch == 'M')
      return 1000;

    return -1;
  }

  public int romanToDecimal(String str) {

    int decimal = 0;

    for (int i = 0; i < str.length(); i++) {

      int c1 = romanValue(str.charAt(i));

      if (i + 1 < str.length()) {

        int c2 = romanValue(str.charAt(i + 1));

        if (c1 >= c2)
          decimal = decimal + c1;
        else {
          decimal = decimal + (c2 - c1);
          i++;
        }

      } else {

        decimal = decimal + c1;
      }

    }

    return decimal;

  }
}
