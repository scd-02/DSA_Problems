public class String_KPanagrams {

  boolean kPangram(String str, int k) {
    if (str.length() < 26)
      return false;

    int freq[] = new int[26];

    int totalAlpha = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ' ') {
        freq[str.charAt(i) - 'a']++;
        totalAlpha++;
      }
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0)
        count++;
    }

    return (totalAlpha >= 26) && (26 - count) <= k ? true : false;
  }
}
