public class String_CheckIfStringIsRotatedByTwoPlaces {
  public static boolean isRotated(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;

    boolean left = true, right = true;
    int n = str1.length();

    for (int i = 0, j = 2; i < n; i++, j++) {
      if (str1.charAt(j % n) != str2.charAt(i))
        left = false;
    }

    for (int i = 0, j = 2; i < n; i++, j++) {
      if (str1.charAt(i) != str2.charAt(j % n))
        right = false;
    }

    return left || right;
  }
}
