public class Greedy_MaxSumWithoutAdjacents {
  int findMaxSum_greedy(int arr[], int n) {

    int include = 0;
    int exclude = 0;

    for (int i = 0; i < n; i++) {

      int temp = Math.max(arr[i] + include, exclude);

      include = exclude;
      exclude = temp;

    }

    return Math.max(include, exclude);
  }
}
