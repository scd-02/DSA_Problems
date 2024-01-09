import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Graph_WordLadder2 {
  public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    // Creating hashset for searching and deletion in O(1) time
    HashSet<String> hs = new HashSet<>();
    for (String s : wordList) {
      hs.add(s);
    }

    ArrayList<String> usedOnLevel = new ArrayList<>();
    usedOnLevel.add(startWord);

    Queue<ArrayList<String>> q = new LinkedList<>();
    ArrayList<String> list = new ArrayList<>();
    list.add(startWord);
    q.add(list);

    int level = 0;

    while (!q.isEmpty()) {

      ArrayList<String> seq = q.poll();

      // Remove the visited words in the previous level from hashset so that it never
      // gets looped
      if (seq.size() > level) {
        level++;
        for (String word : usedOnLevel) {
          hs.remove(word);
        }
      }

      String lastWord = seq.get(seq.size() - 1);
      // add sequences to the ans list
      if (lastWord.equals(targetWord)) {

        if (ans.size() == 0) {
          ans.add(seq);
        } else if (ans.get(0).size() == seq.size()) {
          ans.add(seq);
        }
      }

      int n = lastWord.length();

      // getting seq for next iteration of bfs
      for (int i = 0; i < n; i++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {

          String newStr = lastWord.substring(0, i) + ch + lastWord.substring(i + 1, n);
          if (hs.contains(newStr)) {

            seq.add(newStr);
            ArrayList<String> temp = new ArrayList<>(seq);
            q.add(temp);
            usedOnLevel.add(newStr);
            seq.remove(seq.size() - 1);

          }
        }
      }

    }

    return ans;
  }
}
