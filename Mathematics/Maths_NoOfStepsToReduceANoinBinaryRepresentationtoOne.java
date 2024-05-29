public class Maths_NoOfStepsToReduceANoinBinaryRepresentationtoOne {
  public int numSteps(String s) {

    int carry = 0;
    int steps = 0;

    for (int i = s.length() - 1; i > 0; i--) {

      int bit = s.charAt(i) - '0';
      if (((bit + carry) & 1) == 1) {
        steps += 2;
        carry = 1;
      } else {
        steps++;
      }

    }

    return steps + carry;
  }
}
