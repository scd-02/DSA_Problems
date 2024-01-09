public class String_LongestDistinctCharactersInString {
  static int longestSubstrDistinctChars(String S) {

    int arr[] = new int[256];

    int prev = 0;
    int ans = Integer.MIN_VALUE;

    for (int i = 0; i < S.length(); i++) {

      arr[S.charAt(i)]++;
      if (arr[S.charAt(i)] > 1) {

        while (prev <= i && S.charAt(i) != S.charAt(prev)) {
          arr[S.charAt(prev)]--;
          prev++;
        }

        arr[S.charAt(prev)]--;
        prev++;
      }

      ans = Math.max(ans, i - prev + 1);

    }

    return ans;
  }
}
