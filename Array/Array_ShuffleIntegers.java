public class Array_ShuffleIntegers {
  void shuffleArray(long arr[], int n) {
    int i = 0, j = n / 2;

    while (i != j) {

      if ((i & 1) == 1) {
        rotate(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }

    }
  }

  void rotate(long arr[], int i, int j) {

    long val = arr[j];

    for (int s = j; s > i; s--) {
      arr[s] = arr[s - 1];
    }

    arr[i] = val;
  }

  void shuffleArray2(long arr[], int n) {

    int i = 0;

    for (int j = n / 2; j < n; j++) {

      arr[j] = arr[j] << 10;
      arr[j] = arr[j] | arr[i];
      i++;

    }

    i = 0;

    for (int j = n / 2; j < n; j++) {
      arr[i++] = arr[j] & 1023;
      arr[i++] = arr[j] >> 10;
    }
  }
}
