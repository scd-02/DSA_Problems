public class Dp_BuyAndSellStock2 {
  public int maxProfit(int[] a) {
    int profit = 0;
    int bp = 0, sp = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i] >= a[sp]) {
        sp++;
      } else {
        profit += a[sp] - a[bp];
        bp = sp = i;
      }
    }

    profit += a[sp] - a[bp];
    return profit;
  }
}
