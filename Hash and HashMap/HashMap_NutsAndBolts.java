import java.util.HashMap;

public class HashMap_NutsAndBolts {

  void matchPairs(int n, char nuts[], char bolts[]) {

    char order[] = { '!', '#', '$', '%', '&', '*', '?', '@', '^' };

    HashMap<Character, Integer> freq = new HashMap<>();
    for (char ele : nuts) {
      freq.put(ele, freq.getOrDefault(ele, 0) + 1);
    }

    int i = 0;
    for (char ch : order) {

      if (freq.containsKey(ch)) {
        int count = freq.get(ch);
        while (count > 0) {
          nuts[i] = ch;
          bolts[i] = ch;
          i++;
          count--;
        }
      }

    }
  }
}