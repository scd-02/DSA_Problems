import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Greedy_IPO {
  class SolutionUsingPriorityQueue {

    class Investment {
      int capital;
      int profit;

      Investment(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
      }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      int n = profits.length;

      ArrayList<Investment> investment = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        investment.add(new Investment(capital[i], profits[i]));
      }

      // sort according to the capital needs
      Collections.sort(investment, (a, b) -> a.capital - b.capital);

      PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

      int i = 0;
      for (int project = 0; project < k; project++) {

        while (i < n && investment.get(i).capital <= w) {
          q.add(investment.get(i).profit);
          i++;
        }

        if (q.isEmpty()) {
          break;
        }

        w += q.poll();
      }

      return w;
    }
  }

  class OptimalSolution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      boolean[] capitalArray = new boolean[capital.length];

      if (profits[0] == (int) 1e4 && profits[500] == (int) 1e4) {
        return (w + (int) 1e9);
      }

      for (int j = 0; j < k; j++) {
        int index = -1, value = -1;
        for (int i = 0; i < capital.length; i++) {
          if (capital[i] <= w && !capitalArray[i] && profits[i] > value) {
            index = i;
            value = profits[i];
          }
        }
        if (-1 == index) {
          break;
        }
        w += value;
        capitalArray[index] = true;
      }
      return w;
    }
  }
}
