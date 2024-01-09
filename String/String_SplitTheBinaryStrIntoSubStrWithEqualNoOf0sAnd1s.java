public class String_SplitTheBinaryStrIntoSubStrWithEqualNoOf0sAnd1s {
  public static int maxSubStr(String str) {

    int count0 = 0, count1 = 0;
    int cuts = 0;

    for (int i = 0; i < str.length(); i++) {

      if (str.charAt(i) == '0')
        count0++;
      else
        count1++;

      if (count0 == count1) {
        cuts++;
        count0 = 0;
        count1 = 0;
      }

    }

    return (count0 != 0 || count1 != 0) ? -1 : cuts;
  }
}
