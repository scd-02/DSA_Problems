import java.util.Arrays;

public class Greedy_FractionalKnapsack {
  class Item {
    int value, weight;

    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }
  }

  double fractionalKnapsack(int W, Item arr[], int n) {

    double ratio[][] = new double[n][2];

    for (int i = 0; i < n; i++) {
      ratio[i][0] = arr[i].value / (double) arr[i].weight;
      ratio[i][1] = i;
    }

    Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0]));

    double maxValue = 0.0;

    for (int i = n - 1; i >= 0; i--) {
      int index = (int) ratio[i][1];

      if (arr[index].weight <= W) {
        maxValue += arr[index].value;
        W -= arr[index].weight;
      } else {
        maxValue += ratio[i][0] * W;
        break;
      }
    }

    return maxValue;
  }
}
