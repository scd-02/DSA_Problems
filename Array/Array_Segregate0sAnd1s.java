public class Array_Segregate0sAnd1s {
  void segregate0and1(int[] arr) {

    int start = 0, end = arr.length - 1;

    while (start < end) {

      if (arr[start] == 0) {
        start++;
      } else if (arr[end] == 1) {
        end--;
      } else {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }
    }

  }
}
