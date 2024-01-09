import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_WordLadder2Optimised {
  String beginWord;
  ArrayList<ArrayList<String>> ans;
  HashMap<String, Integer> map;

  public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
    // Creating hashset for searching and deletion in O(1) time
    HashSet<String> hs = new HashSet<>();
    for (String s : wordList) {
      hs.add(s);
    }

    beginWord = startWord;

    Queue<String> q = new LinkedList<>();
    q.add(beginWord);

    if (hs.contains(beginWord))
      hs.remove(beginWord);

    map = new HashMap<>();
    map.put(beginWord, 1);

    while (!q.isEmpty()) {

      String word = q.poll();
      int steps = map.get(word);
      int n = word.length();

      for (int i = 0; i < n; i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {

          String newStr = word.substring(0, i) + ch + word.substring(i + 1, n);
          if (hs.contains(newStr)) {
            q.add(newStr);
            map.put(newStr, steps + 1);
            hs.remove(newStr);
          }

        }
      }

    }

    ans = new ArrayList<>();

    if (map.containsKey(targetWord)) {
      ArrayList<String> list = new ArrayList<>();
      list.add(targetWord);
      dfs(targetWord, list);
    }

    return ans;
  }

  public void dfs(String word, ArrayList<String> list) {

    if (word.equals(beginWord)) {

      ArrayList<String> temp = new ArrayList<>(list);
      Collections.reverse(temp);
      ans.add(temp);

      return;
    }

    int steps = map.get(word);
    int n = word.length();

    for (int i = 0; i < n; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {

        String newStr = word.substring(0, i) + ch + word.substring(i + 1, n);

        if (map.containsKey(newStr) && map.get(newStr) == steps - 1) {
          list.add(newStr);
          dfs(newStr, list);
          list.remove(list.size() - 1);
        }

      }
    }
  }
}
