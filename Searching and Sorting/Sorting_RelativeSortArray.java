public class Sorting_RelativeSortArray {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {

    int freq[] = new int[1001];

    for (int ele : arr1) {
      freq[ele]++;
    }
    int i = 0;
    for (int ele : arr2) {

      if (freq[ele] > 0) {
        int count = freq[ele];
        while (i < arr1.length && count > 0) {
          arr1[i] = ele;
          i++;
          count--;
          freq[ele]--;
        }
      }
    }

    for (int j = 0; j < freq.length; j++) {
      if (freq[j] > 0) {
        int count = freq[j];
        while (i < arr1.length && count > 0) {
          arr1[i] = j;
          i++;
          count--;
        }
      }
    }

    return arr1;
  }
}
