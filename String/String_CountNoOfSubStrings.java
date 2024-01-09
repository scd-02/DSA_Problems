public class String_CountNoOfSubStrings {

  long substrCount(String s, int k) {

    return atmost_k_chr(s, k) - atmost_k_chr(s, k - 1);

  }

  long atmost_k_chr(String s, int k) {

    if (s.length() == 0)
      return 0;

    int chrFre[] = new int[26];
    int distinct = 0;

    long count = 0;
    int left = 0;

    for (int i = 0; i < s.length(); i++) {

      chrFre[s.charAt(i) - 'a']++;

      if (chrFre[s.charAt(i) - 'a'] == 1)
        distinct++;

      while (distinct > k) {
        chrFre[s.charAt(left) - 'a']--;

        if (chrFre[s.charAt(left) - 'a'] == 0)
          distinct--;

        left++;

      }

      count += i - left + 1;
    }

    return count;
  }
}
