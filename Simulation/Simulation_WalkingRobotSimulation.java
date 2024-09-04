import java.util.HashSet;
import java.util.Set;

public class Simulation_WalkingRobotSimulation {

  private static final int MUL = 60001;

  public int robotSim(int[] commands, int[][] obstacles) {

    // store the obstacles in hashset for efficient lookup
    Set<Integer> obstacleSet = new HashSet<>();
    for (int[] obs : obstacles) {
      obstacleSet.add(hashCoordinates(obs[0], obs[1]));
    }

    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    int currDir = 0;
    int maxDistSqr = 0;
    int currPos[] = { 0, 0 };

    for (int command : commands) {
      if (command == -1) {
        currDir = (currDir + 1) % 4;
        continue;
      }

      if (command == -2) {
        currDir = (currDir + 3) % 4;
        continue;
      }

      int direction[] = directions[currDir];

      for (int step = 0; step < command; step++) {
        int nextX = currPos[0] + direction[0];
        int nextY = currPos[1] + direction[1];

        if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
          break;
        }
        currPos[0] = nextX;
        currPos[1] = nextY;
      }

      maxDistSqr = Math.max(maxDistSqr, squaredDistance(currPos[0], currPos[1]));
    }

    return maxDistSqr;
  }

  private int hashCoordinates(int x, int y) {
    return x + MUL * y;
  }

  private int squaredDistance(int x, int y) {
    return x * x + y * y;
  }
}