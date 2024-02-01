public class String_ImplementAtoi {
  int atoi(String s) {

    int res = 0;

    char sign = ' ';

    if (s.charAt(0) == '-') {
      sign = '-';
      s = s.substring(1);
    }

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {

        int integer = s.charAt(i) - '0';
        res = res * 10 + integer;

      } else {
        return -1;
      }

    }

    if (sign == '-') {
      res *= -1;
    }

    return res;
  }
}
