import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueue_TheNumberOfTheSmallestUnoccupiedChair {
  public int smallestChair(int[][] times, int targetFriend) {

    int arrivalTarget = times[targetFriend][0];
    Arrays.sort(times, (a, b) -> a[0] - b[0]);

    PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
    for (int i = 0; i < times.length; i++)
      availableChairs.add(i);

    PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    for (int[] time : times) {

      int arrivalTime = time[0];
      int leavingTime = time[1];

      while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrivalTime) {
        availableChairs.add(occupiedChairs.poll()[1]);
      }

      if (arrivalTime == arrivalTarget) {
        return availableChairs.peek();
      }

      occupiedChairs.add(new int[] { leavingTime, availableChairs.poll() });
    }

    return -1;
  }
}
