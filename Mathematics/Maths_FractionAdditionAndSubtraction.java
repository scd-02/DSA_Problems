public class Maths_FractionAdditionAndSubtraction {
  public String fractionAddition(String expression) {

    int runningNum = 0;
    int runningDeno = 1;

    int i = 0;

    while (i < expression.length()) {

      int currNum = 0;
      int currDeno = 0;

      boolean isNegative = false;

      // check for sign
      if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
        if (expression.charAt(i) == '-')
          isNegative = true;

        i++;
      }

      // build numerator
      while (Character.isDigit(expression.charAt(i))) {
        int val = expression.charAt(i) - '0';
        currNum = currNum * 10 + val;
        i++;
      }

      if (isNegative)
        currNum *= -1;

      // skip '/'
      i++;

      // build denominator
      while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
        int val = expression.charAt(i) - '0';
        currDeno = currDeno * 10 + val;
        i++;
      }

      runningNum = runningNum * currDeno + currNum * runningDeno;
      runningDeno = currDeno * runningDeno;
    }

    int gcd = Math.abs(findGCD(runningNum, runningDeno));

    runningNum /= gcd;
    runningDeno /= gcd;

    return runningNum + "/" + runningDeno;
  }

  private int findGCD(int a, int b) {
    if (a == 0)
      return b;

    return findGCD(b % a, a);
  }
}
