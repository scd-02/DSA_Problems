public class Dp_LongestCommonSubsequence {

  static int lcs(int x, int y, String s1, String s2) {
    int state[][] = new int[x + 1][y + 1];

    for (int i = 0; i < state.length; i++) {
      for (int j = 0; j < state[i].length; j++) {

        if (i == 0 || j == 0) {
          state[i][j] = 0;
          continue;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          state[i][j] = 1 + state[i - 1][j - 1];
        } else {
          state[i][j] = Math.max(state[i][j - 1], state[i - 1][j]);
        }
      }
    }

    return state[x][y];
  }

  static int lcsRec(int x, int y, String s1, String s2) {

    if (x == 0 || y == 0) {
      return 0;
    }

    if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
      return 1 + lcsRec(x - 1, y - 1, s1, s2);
    }

    return Math.max(lcsRec(x, y - 1, s1, s2), lcsRec(x - 1, y, s1, s2));

  }
}
