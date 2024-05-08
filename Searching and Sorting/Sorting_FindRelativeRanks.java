import java.util.Arrays;
import java.util.HashMap;

public class Sorting_FindRelativeRanks {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;

    int[] sortedScore = score.clone();
    Arrays.sort(sortedScore);

    String[] ranks = new String[n];

    for (int i = 0; i < n; i++) {
      int rank = Arrays.binarySearch(sortedScore, score[i]);
      if (rank == n - 1) {
        ranks[i] = "Gold Medal";
      } else if (rank == n - 2) {
        ranks[i] = "Silver Medal";
      } else if (rank == n - 3) {
        ranks[i] = "Bronze Medal";
      } else {
        ranks[i] = String.valueOf(n - rank);
      }
    }

    return ranks;
  }

  public String[] findRelativeRanks2(int[] score) {

    int n = score.length;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < n; i++) {
      hm.put(score[i], i);
    }

    Arrays.sort(score);
    String ans[] = new String[n];

    for (int i = 0; i < n; i++) {
      int index = hm.get(score[n - i - 1]);
      if (i == 0) {
        ans[index] = "Gold Medal";
      } else if (i == 1) {
        ans[index] = "Silver Medal";
      } else if (i == 2) {
        ans[index] = "Bronze Medal";
      } else {
        ans[index] = "" + (i + 1);
      }
    }

    return ans;
  }
}
