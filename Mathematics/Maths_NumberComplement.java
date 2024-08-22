public class Maths_NumberComplement {
  public int findComplement(int num) {

    int res = 0;
    int i = 0;

    while (num > 0) {
      res |= ((num & 1) ^ 1) << i;
      num = num >> 1;
      i++;
      // System.out.println(res + " " + num);
    }

    return res;
  }
}
