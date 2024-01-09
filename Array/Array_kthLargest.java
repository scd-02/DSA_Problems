public class Array_kthLargest {
  private static int result = 0;

  public static int kthSmallest(int[] arr, int l, int r, int k) {

    quickSelect(arr, l, r, k);
    return result;
  }

  public static void quickSelect(int arr[], int l, int r, int k) {
    if (l <= r) {
      int p = partition(arr, l, r);

      if (p == k - 1) {
        result = arr[p];
      } else if (p > k - 1) {
        kthSmallest(arr, l, p - 1, k);
      } else {
        kthSmallest(arr, p + 1, r, k);
      }
    }
  }

  public static int partition(int a[], int low, int high) {

    int pivot = a[low];
    int i = low;
    int j = high;

    while (i < j) {
      while (i < high && a[i] <= pivot)
        i++;
      while (a[j] > pivot)
        j--;

      if (i < j)
        swap(a, i, j);
    }

    swap(a, low, j);
    return j;
  }

  public static void swap(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(kthSmallest(new int[] { 5, 2, 3, 6, 7, 1 }, 0, 5, 5));
  }
}
