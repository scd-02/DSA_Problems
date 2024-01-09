import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String_PrintAnagramsTogether {
  public List<List<String>> Anagrams(String[] string_list) {

    int n = string_list.length;

    List<List<String>> ans = new ArrayList<>();

    List<String> temp = new ArrayList<>();
    temp.add(string_list[0]);

    ans.add(temp);

    for (int i = 1; i < n; i++) {

      boolean isAnagram = false;
      for (int j = 0; j < ans.size(); j++) {

        if (checkAnagrams(string_list[i], ans.get(j).get(0))) {
          ans.get(j).add(string_list[i]);
          isAnagram = true;
        }

      }

      if (!isAnagram) {
        temp = new ArrayList<>();
        temp.add(string_list[i]);
        ans.add(temp);
      }

    }

    return ans;

  }

  public boolean checkAnagrams(String s1, String s2) {

    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for (int j = 0; j < s2.length(); j++) {

      if (!map.containsKey(s2.charAt(j))) {
        return false;
      } else {
        map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
        if (map.get(s2.charAt(j)) == 0) {
          map.remove(s2.charAt(j));
        }
      }

    }

    return (map.size() == 0);
  }
}
