public class String_CheckIfFrequenciesCanBeEqual {
  boolean sameFreq(String s) {

    int freq[] = new int[26];

    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }

    if (allSame(freq))
      return true;

    for (int i = 0; i < 26; i++) {

      if (freq[i] > 0) {
        freq[i]--;
        if (allSame(freq)) {
          return true;
        }
        freq[i]++;
      }

    }

    return false;
  }

  boolean allSame(int freq[]) {

    int same = -1;

    int i;

    for (i = 0; i < freq.length; i++) {
      if (freq[i] > 0) {
        same = freq[i];
        break;
      }
    }

    for (int j = i + 1; j < freq.length; j++) {
      if (freq[j] > 0 && freq[j] != same)
        return false;
    }

    return true;
  }
}
