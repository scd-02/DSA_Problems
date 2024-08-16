import java.util.List;

public class Greedy_MaxDistanceInArrays {

  public int maxDistance(List<List<Integer>> arrays) {

    int smallest = arrays.get(0).get(0);
    int biggest = arrays.get(0).get(arrays.get(0).size() - 1);

    int maxDistance = 0;

    for (int i = 1; i < arrays.size(); i++) {
      List<Integer> arr = arrays.get(i);

      maxDistance = Math.max(maxDistance, Math.abs(biggest - arr.get(0)));
      maxDistance = Math.max(maxDistance, Math.abs(arr.get(arr.size() - 1) - smallest));

      smallest = Math.min(smallest, arr.get(0));
      biggest = Math.max(biggest, arr.get(arr.size() - 1));

    }

    return maxDistance;
  }
}