import java.util.HashMap;

public class String_LongestKUniqueCharactersSubstring {
  public int longestkSubstr(String s, int k) {

    int i = 0, j = 0;

    HashMap<Character, Integer> map = new HashMap<>();

    int length = 0;
    int maxLength = -1;

    while (j < s.length()) {

      map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

      if (map.size() < k) {
        j++;
      } else if (map.size() == k) {
        length = (j - i) + 1;
        maxLength = Math.max(maxLength, length);
        j++;
      } else {
        while (map.size() > k) {

          map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

          if (map.get(s.charAt(i)) == 0) {
            map.remove(s.charAt(i));
          }

          i++;

        }

        j++;
      }

    }

    return maxLength;
  }
}
