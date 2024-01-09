import java.util.ArrayList;

/*
 * without constructing tree (array implementation)
 * i/p: {{4, 5}, {4, 2}, {2, 3}, {2, 1}, {3, 6}, {3, 12}}
 * o/p: 6
 */

public class Tree_MaxGCDOfSibling {
  static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }
    if (a % b == 0) {
      return b;
    }
    return gcd(b, a % b);
  }

  static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {

    arr.sort((a, b) -> (a.get(0) - b.get(0)));
    int maxGCD = 0;
    for (int i = 0; i < arr.size(); i++) {
      int j = i + 1;
      if (j < arr.size() && arr.get(i).get(0) == arr.get(j).get(0)) {
        maxGCD = Math.max(maxGCD, gcd(arr.get(i).get(1), arr.get(j).get(1)));
      }
    }
    return maxGCD;
  }
}
