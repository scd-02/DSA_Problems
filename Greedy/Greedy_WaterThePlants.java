import java.util.ArrayList;
import java.util.Collections;

public class Greedy_WaterThePlants {
  class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  int min_sprinklers(int gallery[], int n) {

    ArrayList<Pair> range = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (gallery[i] > -1) {
        range.add(new Pair(i - gallery[i], i + gallery[i]));
      }
    }

    Collections.sort(range, (a, b) -> a.x - b.x);

    int totalSprinkler = 0, maxRange = 0;

    int i = 0;

    while (maxRange < n) {

      if (i == range.size() || range.get(i).x > maxRange)
        return -1;

      int currMax = range.get(i).y;

      while (i + 1 < range.size() && range.get(i + 1).x <= maxRange) {

        i++;

        currMax = Math.max(currMax, range.get(i).y);
      }

      if (currMax < maxRange)
        return -1;

      totalSprinkler++;

      maxRange = currMax + 1;
    }

    return totalSprinkler;
  }
}
