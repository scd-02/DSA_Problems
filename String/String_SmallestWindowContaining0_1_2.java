public class String_SmallestWindowContaining0_1_2 {
  public int smallestSubstring(String S) {

    int arr[] = new int[3];

    int start = 0;
    int length = Integer.MAX_VALUE;

    for (int i = 0; i < S.length(); i++) {

      int ch = S.charAt(i) - '0';

      arr[ch]++;

      while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {

        length = Math.min(arr[0] + arr[1] + arr[2], length);

        int start_ch = S.charAt(start) - '0';

        arr[start_ch]--;
        start++;

      }

    }

    return length == Integer.MAX_VALUE ? -1 : length;
  }
}
