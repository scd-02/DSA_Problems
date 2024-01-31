public class String_PanagramChecking {
  public static boolean checkPangram(String s) {

    int n = s.length();

    if (n < 26)
      return false;

    int arr[] = new int[26];

    for (int i = 0; i < n; i++) {

      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        arr[s.charAt(i) - 'A']++;
      } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
        arr[s.charAt(i) - 'a']++;
      }

    }

    for (int i = 0; i < 26; i++) {
      if (arr[i] == 0) {
        return false;
      }
    }

    return true;
  }
}
