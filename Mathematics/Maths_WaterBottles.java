public class Maths_WaterBottles {
  public int numWaterBottles(int numBottles, int numExchange) {
    int total = numBottles;
    int empty = numBottles;
    while (empty >= numExchange) {
      int newBottles = empty / numExchange;
      total += newBottles;
      empty = newBottles + empty % numExchange;
    }
    return total;
  }

  public int numWaterBottles2(int numBottles, int numExchange) {
    return numBottles + (numBottles - 1) / (numExchange - 1);
  }
}
