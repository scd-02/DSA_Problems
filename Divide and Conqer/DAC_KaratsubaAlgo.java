public class DAC_KaratsubaAlgo {
  static Long karatsubaAlgo(String a, String b) {

    // making both string of equal lengths
    int n = Math.max(a.length(), b.length());
    a = String.format("%" + n + "s", a).replace(' ', '0');
    b = String.format("%" + n + "s", b).replace(' ', '0');

    if (n == 0)
      return 0l;

    if (n == 1)
      return Long.parseLong(a) * Long.parseLong(b);

    int fh = n >> 1;
    int sh = n - fh;

    // dividing the string
    String al = a.substring(0, fh);
    String ar = a.substring(fh);

    String bl = b.substring(0, fh);
    String br = b.substring(fh);

    long p1 = karatsubaAlgo(al, bl);
    long p2 = karatsubaAlgo(ar, br);
    long p3 = karatsubaAlgo(
        Long.toBinaryString(Long.parseLong(al, 2) + Long.parseLong(ar, 2)),
        Long.toBinaryString(Long.parseLong(bl, 2) + Long.parseLong(br, 2)));

    return (1l << (2 * sh)) * p1 + (1l << sh) * (p3 - p2 - p1) + p2;
  }
}
