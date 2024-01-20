import java.util.ArrayList;
import java.util.PriorityQueue;

public class Greedy_MinimumPlatforms {
  static int findPlatform(int arr[], int dep[], int n) {
    ArrayList<ArrayList<Integer>> schedule = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(arr[i]);
      temp.add(dep[i]);
      schedule.add(temp);
    }

    schedule.sort((a, b) -> a.get(0) - b.get(0));

    int platforms = 1;

    PriorityQueue<Integer> q = new PriorityQueue<>();
    q.add(schedule.get(0).get(1));

    for (int i = 1; i < schedule.size(); i++) {

      int nextTrain_Time = schedule.get(i).get(0);

      if (nextTrain_Time > q.peek()) {
        q.remove();
        q.add(schedule.get(i).get(1));
      } else {
        q.add(schedule.get(i).get(1));
      }

      platforms = Math.max(platforms, q.size());
    }

    return platforms;
  }

}
