public class Maths_HowManyXs {
  int countX(int L, int R, int X) {

    int result = 0;

    for (int i = L + 1; i < R; i++) {

      result += solve(i, X);

    }

    return result;
  }

  int solve(int num, int x) {

    int count = 0;

    while (num > 0) {

      if ((num % 10) == x)
        count++;

      num = num / 10;

    }

    return count;
  }
}
