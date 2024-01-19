import java.util.ArrayList;
import java.util.HashMap;

public class Array_TopKNumbersInAStream {
  public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    // for storing frequency
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);

    // to store tok k elements
    int top[] = new int[K + 1];

    for (int i = 0; i < N; i++) {

      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

      top[K] = arr[i];

      int index = find(top, arr[i]);
      index -= 1;

      while (index >= 0) {

        if (map.get(top[index]) < map.get(top[index + 1])) {
          swap(top, index, index + 1);
        } else if (map.get(top[index]) == map.get(top[index + 1]) && top[index] > top[index + 1]) {
          swap(top, index, index + 1);
        } else {
          break;
        }

        index--;
      }

      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < K && top[j] != 0; j++) {
        temp.add(top[j]);
      }

      ans.add(temp);
    }

    return ans;
  }

  static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int find(int arr[], int ele) {

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ele)
        return i;
    }

    return -1;
  }
}
