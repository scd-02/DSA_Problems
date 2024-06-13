import java.util.Arrays;

public class Sorting_MinimumNumberOfMovesToSeatEveryone {
  public int minMovesToSeat(int[] seats, int[] students) {
    int n = seats.length;

    Arrays.sort(seats);
    Arrays.sort(students);

    int res = 0;
    for (int i = 0; i < n; i++) {
      res += Math.abs(seats[i] - students[i]);
    }

    return res;
  }

  public int minMovesToSeatCountingSort(int[] seats, int[] students) {
    int n = seats.length;
    int maxPosition = 0;

    for (int i = 0; i < n; i++) {
      maxPosition = Math.max(maxPosition, Math.max(seats[i], students[i]));
    }

    int diff[] = new int[maxPosition];

    for (int position : seats) {
      diff[position - 1]++;
    }

    for (int position : students) {
      diff[position - 1]--;
    }

    int moves = 0, unmatched = 0;
    for (int ele : diff) {
      moves += Math.abs(unmatched);
      unmatched += ele;
    }

    return moves;
  }
}
