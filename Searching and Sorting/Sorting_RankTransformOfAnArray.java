import java.util.Arrays;
import java.util.HashMap;

public class Sorting_RankTransformOfAnArray {
  public int[] arrayRankTransform(int[] arr) {

    int dup[] = arr.clone();
    Arrays.sort(dup);

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < dup.length; i++) {
      map.putIfAbsent(dup[i], map.size() + 1);
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = map.get(arr[i]);
    }

    return arr;
  }
}
