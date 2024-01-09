import java.util.Arrays;

public class Greedy_Candy {
  static int minCandy(int N, int ratings[]) {

    int candy[] = new int[N];

    Arrays.fill(candy, 1);

    // check for left neighbour
    for (int i = 1; i < N; i++) {

      if (ratings[i] > ratings[i - 1]) {
        candy[i] = candy[i - 1] + 1;
      }

    }

    // check for right neighbour
    for (int i = N - 2; i >= 0; i--) {

      if (ratings[i] > ratings[i + 1]) {
        candy[i] = Math.max(candy[i], candy[i + 1] + 1);
      }

    }

    int total = 0;
    for (int c : candy) {
      total += c;
    }

    return total;
  }
}
