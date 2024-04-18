public class Array_TwoRepeatedElements {
  public int[] twoRepeated(int arr[], int n) {
    int ans[] = new int[2];
    int k = 0;
    for (int i = 0; i < n + 2; i++) {

      int index = Math.abs(arr[i]);

      if (arr[index] > 0) {
        arr[index] = -arr[index];
      } else {
        ans[k++] = Math.abs(arr[i]);
      }

    }

    return ans;
  }
}
