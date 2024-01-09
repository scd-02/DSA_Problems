import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy_MaximumMeetingsInOneRoom {
  public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {

    Meeting[] m = new Meeting[N];

    for (int i = 0; i < N; i++) {
      m[i] = new Meeting(S[i], F[i], i + 1);
    }

    Arrays.sort(m, (a, b) -> a.end - b.end);

    ArrayList<Integer> schedule = new ArrayList<>();
    int end = -1;

    for (int i = 0; i < N; i++) {
      if (m[i].start > end) {
        schedule.add(m[i].index);
        end = m[i].end;
      }
    }

    Collections.sort(schedule);

    return schedule;
  }

  static class Meeting {

    int start;
    int end;
    int index;

    Meeting(int s, int e, int i) {
      start = s;
      end = e;
      index = i;
    }
  }
}