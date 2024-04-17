public class Searching_CountInversions {
  static long inversionCount(long arr[], long N) {
    return mergeSort(arr, 0, (int) N - 1);
  }

  static long mergeSort(long arr[], int s, int e) {
    if (s >= e)
      return 0;

    int mid = (s + e) / 2;
    long inversion = 0;

    inversion += mergeSort(arr, s, mid);
    inversion += mergeSort(arr, mid + 1, e);
    inversion += merge(arr, s, mid, e);

    return inversion;
  }

  static long merge(long arr[], int s, int mid, int e) {

    int n1 = mid - s + 1;
    int n2 = e - mid;

    long left[] = new long[n1];
    long right[] = new long[n2];

    for (int i = s; i <= mid; i++) {
      left[i - s] = arr[i];
    }

    for (int j = mid + 1; j <= e; j++) {
      right[j - (mid + 1)] = arr[j];
    }

    int i = 0, j = 0, k = s;
    long inversion = 0;

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
