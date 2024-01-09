import java.util.Arrays;

public class Array_LnogestCommonPrefix {
  String longestCommonPrefix(String arr[], int n) {

    if (n == 0)
      return "-1";
    if (n == 1)
      return arr[0];

    Arrays.sort(arr);

    int length = Math.min(arr[0].length(), arr[n - 1].length());

    int i = 0;
    while (i < length && arr[0].charAt(i) == arr[n - 1].charAt(i)) {
      i++;
    }

    String ans = arr[n - 1].substring(0, i);

    return (i == 0) ? "-1" : ans;

  }
}
