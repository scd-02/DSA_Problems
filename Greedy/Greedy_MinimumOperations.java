public class Greedy_MinimumOperations {
  public int minOperation(int n) {
    if (n == 0)
      return 0;

    if (n == 1)
      return 1;

    int count = 0;

    while (n != 0) {

      if (n % 2 == 0)
        n = n >> 1;

      else
        n = n - 1;

      count++;

    }

    return count;
  }
}