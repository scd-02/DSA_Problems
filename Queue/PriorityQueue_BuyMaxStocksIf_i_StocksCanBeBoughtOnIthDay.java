import java.util.PriorityQueue;

public class PriorityQueue_BuyMaxStocksIf_i_StocksCanBeBoughtOnIthDay {
  public static int buyMaximumProducts(int n, int k, int[] price) {

    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.price - b.price);

    for (int i = 0; i < n; i++) {
      q.add(new Pair(price[i], i + 1));
    }

    int no_of_stocks = 0;

    while (!q.isEmpty()) {

      Pair p = q.poll();
      // System.out.println(p.price + " " + p.stocks);
      int maxAmount = p.price * p.stocks;

      if (maxAmount <= k) {
        no_of_stocks += p.stocks;
        k -= maxAmount;
      } else {
        no_of_stocks += k / p.price;
        break;
      }

    }

    return no_of_stocks;
  }

  static class Pair {
    int price;
    int stocks;

    Pair(int p, int i) {
      price = p;
      stocks = i;
    }
  }
}
