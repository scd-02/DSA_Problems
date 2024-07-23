public class Sorting_SortArrayByIncreasingFrequency {
  public int[] frequencySort(int[] nums) {

    int[] freq = new int[202];

    for (int i = 0; i < nums.length; i++) {
      freq[nums[i] + 100]++;
    }

    quickSort(nums, freq, 0, nums.length - 1);
    return nums;

  }

  void quickSort(int[] nums, int freq[], int low, int high) {
    if (low < high) {
      int pivot = partition(nums, freq, low, high);

      quickSort(nums, freq, low, pivot - 1);
      quickSort(nums, freq, pivot + 1, high);
    }
  }

  int partition(int[] nums, int freq[], int low, int high) {

    int pivot = freq[nums[high] + 100];

    int i = low - 1;

    for (int j = low; j < high; j++) {

      if (pivot > freq[nums[j] + 100]) {
        i++;
        swap(nums, i, j);
      } else if (freq[nums[j] + 100] == pivot) {
        if (nums[high] <= nums[j]) {
          i++;
          swap(nums, i, j);
        }
      }

    }

    swap(nums, i + 1, high);
    return i + 1;
  }

  void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
