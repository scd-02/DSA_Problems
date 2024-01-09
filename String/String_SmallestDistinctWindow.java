import java.util.HashMap;
import java.util.HashSet;

public class String_SmallestDistinctWindow {
  public int findSubString(String str) {

    int count = countChar(str);

    int j = 0;
    int i = 0;
    int length = 0;
    int minLength = Integer.MAX_VALUE;

    HashMap<Character, Integer> hm = new HashMap<>();

    while (j < str.length()) {

      hm.put(str.charAt(j), hm.getOrDefault(str.charAt(j), 0) + 1);

      while (count == hm.size()) {

        length = (j - i) + 1;
        minLength = Math.min(length, minLength);

        hm.put(str.charAt(i), hm.get(str.charAt(i)) - 1);

        if (hm.get(str.charAt(i)) == 0) {
          hm.remove(str.charAt(i));
        }

        i++;
      }

      j++;

    }

    return minLength;
  }

  public int countChar(String str) {

    HashSet<Character> hs = new HashSet<>();

    for (char ch : str.toCharArray()) {
      hs.add(ch);
    }

    return hs.size();
  }
}
