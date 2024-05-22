public class Bs_MinimizeMaxDistancetoGasStation {
  public static double findSmallestMaxDist(int stations[], int k) {

    double start = 0.0;
    double end = 0.0;
    int n = stations.length;

    for (int i = 1; i < n; i++) {
      end = Math.max(end, (double) (stations[i] - stations[i - 1]));
    }

    double ans = end;
    while (end - start > 1e-6) {
      double mid = start + (end - start) / 2.0;
      if (isPossible(stations, mid, k)) {
        ans = mid;
        end = mid;
      } else {
        start = mid;
      }
    }

    return ans;
  }

  static boolean isPossible(int s[], double mid, int k) {
    int n = s.length;
    int count = 0;
    for (int i = 1; i < n; i++) {
      count += Math.max(0, (int) ((s[i] - s[i - 1]) / mid));
    }

    return count <= k;
  }
}
