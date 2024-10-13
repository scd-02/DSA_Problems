import java.util.List;
import java.util.PriorityQueue;

public class Greedy_SmallestRangeCoveringElementsFromKLists {
  public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    int maxVal = Integer.MIN_VALUE, rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

    for (int i = 0; i < nums.size(); i++) {
      pq.offer(new int[] { nums.get(i).get(0), i, 0 });
      maxVal = Math.max(nums.get(i).get(0), maxVal);
    }

    while (pq.size() == nums.size()) {

      int data[] = pq.poll();
      int minVal = data[0], currList = data[1], currEleInd = data[2];

      int currRange = maxVal - minVal;
      if (currRange < rangeEnd - rangeStart) {
        rangeStart = minVal;
        rangeEnd = maxVal;
      }

      if (currEleInd + 1 < nums.get(currList).size()) {
        int nextVal = nums.get(currList).get(currEleInd + 1);
        pq.offer(new int[] { nextVal, currList, currEleInd + 1 });
        maxVal = Math.max(maxVal, nextVal);
      }
    }

    return new int[] { rangeStart, rangeEnd };
  }
}
