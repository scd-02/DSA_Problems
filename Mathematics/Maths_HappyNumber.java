import java.util.HashSet;

public class Maths_HappyNumber {
  public boolean isHappy(int n) {

    HashSet<Integer> hs = new HashSet<>();

    while (true) {

      if (n == 1) {
        return true;
      }

      if (hs.contains(n)) {
        return false;
      }

      hs.add(n);
      n = sumOfSq(n);
    }

  }

  public boolean isHappyHareATort(int n) {
    int slow = n;
    int fast = sumOfSq(n);

    while (slow != fast) {
      slow = sumOfSq(slow);
      fast = sumOfSq(sumOfSq(fast));
    }

    return slow == 1;
  }

  public static int sumOfSq(int n) {

    int sum = 0;

    while (n != 0) {
      sum += Math.pow((n % 10), 2);
      n = n / 10;
    }

    return sum;
  }
}
