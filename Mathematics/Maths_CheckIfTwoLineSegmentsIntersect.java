public class Maths_CheckIfTwoLineSegmentsIntersect {
  String doIntersect(int p1[], int q1[], int p2[], int q2[]) {

    double m1 = (double) (q1[1] - p1[1]) / (q1[0] - p1[0]);
    double m2 = (double) (q2[1] - p2[1]) / (q2[0] - p2[0]);

    boolean o211 = orientation(p2, p1, m1);
    boolean o212 = orientation(q2, p1, m1);
    boolean o121 = orientation(p1, p2, m2);
    boolean o122 = orientation(q1, p2, m2);

    if ((o211 && o212) || (!o211 && !o212) || (o121 && o122) || (!o121 && !o122))
      return "false";

    return "true";

  }

  boolean orientation(int p[], int q[], double m) {

    return ((p[1] - q[1]) - m * (p[0] - q[0])) > 0;

  }
}
