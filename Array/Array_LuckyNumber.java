public class Array_LuckyNumber {
  public static boolean isLucky(int n) {
    return lucky(n, 2);

  }

  static boolean lucky(int n, int count) {

    if (count > n)
      return true;

    if (n % count == 0)
      return false;

    n = n - n / count;
    count++;
    return lucky(n, count);
  }

  public static boolean isLuckyUsingLoop(int n) {

    int counter = 2;
    while (counter <= n) {
      if (n % counter == 0) {
        // the element will be deleted
        return false;
      }
      n = n - n / counter;
      counter++;

    }
    return true;

  }
}
