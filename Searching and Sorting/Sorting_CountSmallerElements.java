public class Sorting_CountSmallerElements {
  int[] constructLowerArray(int[] arr) {

    int n = arr.length;

    int ans[] = new int[n];

    int mapEle[][] = new int[n][2];

    for (int i = 0; i < n; i++) {
      mapEle[i][0] = arr[i];
      mapEle[i][1] = i;
    }

    mergeSort(mapEle, ans, 0, n - 1);
    return ans;
  }

  void mergeSort(int mapEle[][], int ans[], int low, int high) {

    if (low >= high)
      return;

    int mid = (low + high) / 2;

    mergeSort(mapEle, ans, low, mid);
    mergeSort(mapEle, ans, mid + 1, high);
    merge(mapEle, ans, low, mid, high);

  }

  void merge(int mapEle[][], int ans[], int low, int mid, int high) {

    int temp[][] = new int[high - low + 1][2];

    int i = low;
    int j = mid + 1;

    int k = 0;

    while (i <= mid && j <= high) {

      if (mapEle[i][0] > mapEle[j][0]) {
        ans[mapEle[i][1]] += high - j + 1;
        temp[k][0] = mapEle[i][0];
        temp[k][1] = mapEle[i][1];
        i++;
      } else {
        temp[k][0] = mapEle[j][0];
        temp[k][1] = mapEle[j][1];
        j++;
      }

      k++;
    }

    while (i <= mid) {
      temp[k][0] = mapEle[i][0];
      temp[k][1] = mapEle[i][1];
      i++;
      k++;
    }

    while (j <= high) {
      temp[k][0] = mapEle[j][0];
      temp[k][1] = mapEle[j][1];
      j++;
      k++;
    }

    for (k = 0, i = low; i <= high; i++, k++) {
      mapEle[i][0] = temp[k][0];
      mapEle[i][1] = temp[k][1];
    }
  }
}
