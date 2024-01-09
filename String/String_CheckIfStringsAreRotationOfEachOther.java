public class String_CheckIfStringsAreRotationOfEachOther {
  public static boolean areRotations(String s1, String s2) {

    if (s1.length() != s2.length())
      return false;

    String sub = s1 + s1;
    return sub.contains(s2);

  }
}
