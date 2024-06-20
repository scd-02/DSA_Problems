public class Maths_IntegralPointsInATriangle {
  long InternalCount(long p[], long q[], long r[]) {

    /*
     * Pick's Theorem:
     * A = I + (B/2) -1
     * 
     * A ==> Area of Polygon
     * B ==> Number of integral points on edges of polygon
     * I ==> Number of integral points inside the polygon
     * 
     * Using the above formula, we can deduce,
     * I = (2A - B + 2) / 2
     */

    long boundaryPoints = getBoundaryPoints(p, q) +
        getBoundaryPoints(q, r) +
        getBoundaryPoints(p, r) + 3;

    /*
     * Shoelace formula:
     * A = 1/2 * abs(x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2))
     */
    long doubled_area = Math.abs(p[0] * (q[1] - r[1]) +
        q[0] * (r[1] - p[1]) +
        r[0] * (p[1] - q[1]));

    return (doubled_area - boundaryPoints + 2) / 2;
  }

  long gcd(long a, long b) {

    if (a < b)
      return gcd(b, a);

    if (b == 0)
      return a;

    return gcd(b, a % b);
  }

  long getBoundaryPoints(long p[], long q[]) {

    // if points have same x-axis
    if (p[0] == q[0])
      return Math.abs(p[1] - q[1]) - 1;

    // if points have same y-axis
    if (p[1] == q[1])
      return Math.abs(p[0] - q[0]) - 1;

    return gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1])) - 1;
  }
}
