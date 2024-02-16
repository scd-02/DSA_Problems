public class Dp_GeeksTraining {
  public int maximumPoints(int points[][], int N) {

    // return rec(points, N - 1, 3);

    // int dp[][] = new int[N][4];
    // for(int i = 0; i < N; i++){
    // Arrays.fill(dp[i], -1);
    // }

    // return mem(points, N - 1, 3, dp);

    // return tab(points, N);

    return SO(points, N);
  }

  public int rec(int points[][], int day, int lastTask) {

    if (day == 0) {
      int maxPoints = 0;

      for (int i = 0; i < 3; i++) {

        if (i != lastTask) {
          maxPoints = Math.max(maxPoints, points[day][i]);
        }

      }

      return maxPoints;
    }

    int maxPoints = 0;

    for (int i = 0; i < 3; i++) {

      if (i != lastTask) {
        int merits = points[day][i] + rec(points, day - 1, i);
        maxPoints = Math.max(maxPoints, merits);
      }

    }

    return maxPoints;
  }

  public int mem(int points[][], int day, int lastTask, int dp[][]) {
    if (day == 0) {
      int maxPoints = 0;

      for (int i = 0; i < 3; i++) {

        if (i != lastTask) {
          maxPoints = Math.max(maxPoints, points[day][i]);
        }

      }

      return maxPoints;
    }

    if (dp[day][lastTask] != -1) {
      return dp[day][lastTask];
    }

    int maxPoints = 0;

    for (int i = 0; i < 3; i++) {

      if (i != lastTask) {
        int merits = points[day][i] + rec(points, day - 1, i);
        maxPoints = Math.max(maxPoints, merits);
      }

    }

    return dp[day][lastTask] = maxPoints;
  }

  public int tab(int points[][], int N) {

    int dp[][] = new int[N][4];

    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][1], points[0][0]);
    dp[0][3] = Math.max(dp[0][0], points[0][0]);

    for (int day = 1; day < N; day++) {

      for (int lastTask = 0; lastTask <= 3; lastTask++) {

        for (int task = 0; task < 3; task++) {

          if (task != lastTask) {
            dp[day][lastTask] = Math.max(points[day][task] + dp[day - 1][task],
                dp[day][lastTask]);
          }

        }

      }

    }
    return dp[N - 1][3];
  }

  public int SO(int points[][], int N) {

    int prev[] = new int[4];

    prev[0] = Math.max(points[0][1], points[0][2]);
    prev[1] = Math.max(points[0][0], points[0][2]);
    prev[2] = Math.max(points[0][1], points[0][0]);
    prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    for (int day = 1; day < N; day++) {
      int curr[] = new int[4];

      for (int lastTask = 0; lastTask <= 3; lastTask++) {

        for (int task = 0; task < 3; task++) {

          if (task != lastTask) {
            curr[lastTask] = Math.max(points[day][task] + prev[task],
                curr[lastTask]);
          }

        }

      }

      prev = curr;
    }
    return prev[3];
  }
  
}
