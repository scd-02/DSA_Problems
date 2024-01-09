import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_WordLadder1 {
  public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
    // creating hashset for O(1) search
    HashSet<String> hs = new HashSet<>();
    for (String s : wordList) {
      hs.add(s);
    }

    // BFS
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(startWord, 1));

    if (hs.contains(startWord))
      hs.remove(startWord);

    while (!q.isEmpty()) {

      Pair p = q.poll();

      String s = p.word;
      int len = p.len;
      int n = s.length();

      if (s.equals(targetWord)) {
        return len;
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 26; j++) {

          String newstr = s.substring(0, i) + (char) ('a' + j) + s.substring(i + 1, n);

          if (hs.contains(newstr)) {
            q.add(new Pair(newstr, len + 1));
            hs.remove(newstr);
          }

        }
      }

    }

    return 0;
  }

  class Pair {
    int len;
    String word;

    Pair(String word, int len) {
      this.len = len;
      this.word = word;
    }
  }
}
