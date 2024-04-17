public class Array_CountPairsInAnArray {
  static int countPairs(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      arr[i] = i * arr[i];
    }

    return countInversions(arr, n);
  }

  static int countInversions(int arr[], int n) {
    return mergeSort(arr, 0, n - 1);
  }

  static int mergeSort(int arr[], int s, int e) {
    if (s >= e)
      return 0;

    int mid = (s + e) / 2;
    int inversion = 0;

    inversion += mergeSort(arr, s, mid);
    inversion += mergeSort(arr, mid + 1, e);
    inversion += merge(arr, s, mid, e);

    return inversion;
  }

  static int merge(int arr[], int s, int mid, int e) {

    int n1 = mid - s + 1;
    int n2 = e - mid;

    int left[] = new int[n1];
    int right[] = new int[n2];

    for (int i = s; i <= mid; i++) {
      left[i - s] = arr[i];
    }

    for (int j = mid + 1; j <= e; j++) {
      right[j - (mid + 1)] = arr[j];
    }

    int i = 0, j = 0, k = s, inversion = 0;

    while (i < n1 && j < n2) {
      if (left[i] > right[j]) {
        inversion += n1 - i;
        arr[k] = right[j];
        j++;
        k++;
      } else {
        arr[k] = left[i];
        i++;
        k++;
      }
    }

    while (i < n1) {
      arr[k++] = left[i++];
    }

    while (j < n2) {
      arr[k++] = right[j++];
    }

    return inversion;
  }
}
