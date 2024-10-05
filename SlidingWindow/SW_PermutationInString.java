public class SW_PermutationInString {
  public boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length())
      return false;

    int initialFreq[] = new int[26];
    int runningFreq[] = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      initialFreq[s1.charAt(i) - 'a']++;
      runningFreq[s2.charAt(i) - 'a']++;
    }

    for (int i = s1.length(); i < s2.length(); i++) {
      if (matches(initialFreq, runningFreq))
        return true;
      runningFreq[s2.charAt(i) - 'a']++;
      runningFreq[s2.charAt(i - s1.length()) - 'a']--;
    }

    return matches(initialFreq, runningFreq);
  }

  public boolean matches(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i])
        return false;
    }

    return true;
  }
}
