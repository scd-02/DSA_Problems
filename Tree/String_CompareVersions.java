public class String_CompareVersions {
  class Solution1 {
    public int compareVersion(String version1, String version2) {

      int n = version1.length(), m = version2.length();
      int i = 0, j = 0;

      while (i < n || j < m) {

        int val1 = 0;
        for (; i < n && version1.charAt(i) != '.'; i++) {
          val1 = val1 * 10 + version1.charAt(i) - '0';
        }
        i++;

        int val2 = 0;
        for (; j < m && version2.charAt(j) != '.'; j++) {
          val2 = val2 * 10 + version2.charAt(j) - '0';
        }
        j++;

        if (val1 != val2) {
          return val1 > val2 ? 1 : -1;
        }

      }

      return 0;
    }
  }

  class Solution2 {
    public int compareVersion(String version1, String version2) {
      String[] v1Arr = version1.split("\\.");
      String[] v2Arr = version2.split("\\.");
      int i = 0;
      while (i < v1Arr.length || i < v2Arr.length) {
        String v1 = i < v1Arr.length ? v1Arr[i] : "0";
        String v2 = i < v2Arr.length ? v2Arr[i] : "0";
        int res = compare(v1, v2);
        i++;
        if (res != 0)
          return res;
      }
      return 0;
    }

    private int compare(String v1Str, String v2Str) {
      String v1 = cleanZero(v1Str);
      String v2 = cleanZero(v2Str);
      if (v1.length() > v2.length())
        return 1;
      if (v1.length() < v2.length())
        return -1;
      for (int i = 0; i < v1.length(); i++) {
        if (v1.charAt(i) - v2.charAt(i) > 0)
          return 1;
        if (v1.charAt(i) - v2.charAt(i) < 0)
          return -1;
      }
      return 0;
    }

    private String cleanZero(String v) {
      int start = 0;
      while (v.charAt(start) == '0' && start < v.length() - 1) {
        start++;
      }
      return v.substring(start);
    }
  }

  class Solution3 {
    public int compareVersion(String version1, String version2) {

      String[] v1 = version1.split("[.]");
      String[] v2 = version2.split("[.]");

      // System.out.println(Arrays.toString(v1));
      // System.out.println(Arrays.toString(v2));
      int i = 0, j = 0;
      int n1 = v1.length, n2 = v2.length;

      while (i < n1 || j < n2) {
        int val1 = i < n1 ? Integer.parseInt(v1[i]) : 0;
        int val2 = j < n2 ? Integer.parseInt(v2[j]) : 0;

        if (val1 < val2)
          return -1;
        else if (val1 > val2)
          return 1;

        i++;
        j++;
      }

      return 0;
    }
  }
}
