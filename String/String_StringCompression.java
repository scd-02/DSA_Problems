public class String_StringCompression {
  public int compress(char[] chars) {

    char prevChar = chars[0];
    int count = 1;
    int k = 1;

    for (int i = 1; i < chars.length; i++) {

      if (prevChar == chars[i]) {
        count++;
      } else {
        if (count != 1) {
          String temp = "" + count;
          for (int j = 0; j < temp.length(); j++) {
            chars[k + j] = temp.charAt(j);
          }
          k += temp.length();
        }

        prevChar = chars[i];
        count = 1;
        chars[k++] = prevChar;
      }
    }

    if (count != 1) {
      String temp = "" + count;
      for (int j = 0; j < temp.length(); j++) {
        chars[k + j] = temp.charAt(j);
      }
      k += temp.length();
    }

    return k;
  }
}
