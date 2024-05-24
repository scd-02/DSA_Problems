public class Bs_FindNthRoot {
  public int NthRoot(int n, int m) {
    int low = 1, high = m;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (helper(mid, n, m) == 1)
        return mid;
      else if (helper(mid, n, m) == 0)
        low = mid + 1;
      else
        high = mid - 1;

    }
    return -1;
  }

  int helper(int mid, int n, int m) {

    long mul = 1;
    for (int i = 0; i < n; i++) {
      mul *= mid;
      if (mul > m)
        return 2;
    }

    return mul == m ? 1 : 0;
  }
}
