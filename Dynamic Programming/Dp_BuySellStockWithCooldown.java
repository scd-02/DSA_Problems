public class Dp_BuySellStockWithCooldown {
  public int maxProfit(int[] prices) {

    int obsp = -prices[0];
    int ossp = 0;
    int ocsp = 0;

    for (int i = 1; i < prices.length; i++) {

      int nbsp = 0;
      int nssp = 0;
      int ncsp = 0;

      nbsp = (ocsp - prices[i] > obsp) ? ocsp - prices[i] : obsp;
      nssp = (obsp + prices[i] > ossp) ? obsp + prices[i] : ossp;
      ncsp = (ossp > ocsp) ? ossp : ocsp;

      obsp = nbsp;
      ossp = nssp;
      ocsp = ncsp;
    }

    return ossp;
  }
}
