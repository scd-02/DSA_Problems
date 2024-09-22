public class Trie_KthSmallestInLexicographicalOrder {
  public int findKthNumber(int n, int k) {

    int currNo = 1;
    k--;

    while (k > 0) {
      int step = countSteps(n, currNo, currNo + 1);

      if (step <= k) {
        currNo++;
        k -= step;
      } else {
        currNo *= 10;
        k--;
      }
    }

    return currNo;
  }

  public int countSteps(int n, long a, long b) {

    int steps = 0;
    while (a <= n) {
      steps += Math.min(n + 1, b) - a;
      a *= 10;
      b *= 10;
    }

    return steps;
  }
}
