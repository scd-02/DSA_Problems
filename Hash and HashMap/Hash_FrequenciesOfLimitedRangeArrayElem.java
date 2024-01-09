public class Hash_FrequenciesOfLimitedRangeArrayElem {
  /*
   * Given an array arr[] of N positive integers which can contain integers from 1
   * to P where elements can be repeated or can be absent from the array. Your
   * task is to count the frequency of all numbers from 1 to N. Make in-place
   * changes in arr[], such that arr[i] = frequency(i). Assume 1-based indexing.
   * Note: The elements greater than N in the array can be ignored for counting
   * and do modify the array in-place.
   */
  public static void frequencyCount(int arr[], int n, int P) {
    // encoding Or hashing technique
    for (int i = 0; i < n; i++) {
      if (arr[i] > n)
        arr[i] = 0;
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] % (n + 1) > 0) {
        arr[(arr[i] % (n + 1)) - 1] += (n + 1);
      }
    }

    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] / (n + 1);
    }
  }
}