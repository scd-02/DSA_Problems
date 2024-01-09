public class Maths_ShortestPathFrom1ToN {
  public int minStep(int n) {

    int step = 0;

    while (n > 1) {

      if (n % 3 == 0)
        n = n / 3;

      else
        n = n - 1;

      step++;
    }

    return step;
  }
}
