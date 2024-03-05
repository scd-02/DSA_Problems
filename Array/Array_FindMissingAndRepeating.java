public class Array_FindMissingAndRepeating {
  int[] findTwoElement(int arr[], int n) {

    int duplicate = -1, missing = -1;

    for (int i = 0; i < n; i++) {

      int index = Math.abs(arr[i]) - 1;

      if (arr[index] > 0) {
        arr[index] = -arr[index];
      } else {
        duplicate = Math.abs(arr[i]);
      }

    }

    for (int i = 0; i < n; i++) {

      if (arr[i] > 0) {
        missing = i + 1;
      }
    }

    return new int[] { duplicate, missing };
  }
}
