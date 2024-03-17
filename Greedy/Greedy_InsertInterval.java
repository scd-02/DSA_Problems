import java.util.ArrayList;

public class Greedy_InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    ArrayList<int[]> storage = new ArrayList<>();

    int i = 0;

    while (i < n && intervals[i][1] < newInterval[0]) {
      storage.add(intervals[i]);
      i++;
    }

    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }

    storage.add(newInterval);

    while (i < n) {
      storage.add(intervals[i]);
      i++;
    }

    return storage.toArray(new int[storage.size()][2]);

  }
}
