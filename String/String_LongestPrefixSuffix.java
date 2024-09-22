public class String_LongestPrefixSuffix {
  int lps(String str) {

    int n = str.length();
    int prefixTable[] = new int[n];

    int j = 0;
    for (int i = 1; i < n; i++) {

      while (j > 0 && str.charAt(i) != str.charAt(j)) {
        j = prefixTable[j - 1];
      }

      if (str.charAt(i) == str.charAt(j)) {
        j++;
      }

      prefixTable[i] = j;
    }

    return prefixTable[n - 1];
  }
}
