public class String_LookAndSayPattern {
  static String lookandsay(int n) {

    if (n == 1) {
      return "1";
    }

    String last = lookandsay(n - 1);
    String result = "";

    int count = 1;
    int i;

    for (i = 1; i < last.length(); i++) {

      if (last.charAt(i) == last.charAt(i - 1)) {
        count++;
      } else {
        result = result + count + last.charAt(i - 1);
        count = 1;
      }

    }

    result = result + count + last.charAt(i - 1);

    return result;

  }
}
