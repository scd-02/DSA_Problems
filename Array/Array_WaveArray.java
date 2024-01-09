public class Array_WaveArray {
  public static void convertToWave(int n, int[] a) {

    for (int i = 1; i < n; i = i + 2) {

      swap(a, i, i - 1);

    }

  }

  static void swap(int arr[], int i, int j) {

    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

  }
}
