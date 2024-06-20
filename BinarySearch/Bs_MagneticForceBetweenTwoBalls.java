import java.util.Arrays;

public class Bs_MagneticForceBetweenTwoBalls {

  public int maxDistance(int[] position, int m) {

    int n = position.length;
    Arrays.sort(position);

    int low = 1, high = position[n - 1];

    while (low <= high) {
      int mid = (low + high) / 2;

      int balls = countBallWithPossibleGravity(position, mid);

      if (balls >= m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return high;
  }

  int countBallWithPossibleGravity(int[] position, int mid) {

    int count = 1;
    int prevPosition = position[0];

    for (int i = 1; i < position.length; i++) {
      if (position[i] - prevPosition >= mid) {

        prevPosition = position[i];
        count++;
      }
    }

    return count;
  }
}
