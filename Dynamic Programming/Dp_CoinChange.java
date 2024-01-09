public class Dp_CoinChange {
  public long count(int coins[], int N, int sum) {

    long states[] = new long[sum + 1];
    states[0] = 1l;

    for (int denom = 0; denom < N; denom++) {
      for (int s = coins[denom]; s <= sum; s++) {
        states[s] = states[s - coins[denom]] + states[s];
      }
    }

    return states[sum];
  }
}
