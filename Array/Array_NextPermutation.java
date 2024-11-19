public class Array_NextPermutation {
  void nextPermutation(int[] arr) {
    int n = arr.length;

    if (n == 1)
      return;

    int i = n - 2;
    while (i >= 0) {
      if (arr[i] < arr[i + 1]) {
        break;
      }
      i--;
    }

    if (i == -1) {
      reverse(arr, 0, n - 1);
      return;
    }

    // swap with next largest value
    for (int j = n - 1; j > i; j--) {
      if (arr[j] > arr[i]) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        break;
      }
    }

    reverse(arr, i + 1, n - 1);
  }

  void reverse(int arr[], int s, int e) {

    while (s < e) {
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }
}
