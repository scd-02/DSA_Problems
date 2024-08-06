import java.util.Arrays;

public class Sorting_MinimumNoOfPushesToTypeWord2 {
  public int minimumPushes(String word) {

    int[] frequency = new int[26];

    for (char c : word.toCharArray()) {
      frequency[c - 'a']++;
    }

    Arrays.sort(frequency);

    int totalPushes = 0;
    int i = 25;
    int count = 0, type = 1;

    while (i >= 0 && frequency[i] != 0) {
      totalPushes += (type * frequency[i]);
      count++;
      if (count == 8) {
        count = 0;
        type++;
      }
      i--;
    }

    return totalPushes;
  }
}
