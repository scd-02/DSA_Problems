public class Array_MinNoOfJumps {
  static int minJumps(int[] arr) {

    int n = arr.length;
    int max = 0;
    int maxRange = 0;
    int count = 0;

    for (int i = 0; i < n; i++) {
      max = Math.max(max, i + arr[i]);

      if (i == maxRange) {
        maxRange = max;
        count++;
        if (maxRange >= n - 1)
          return count;
      }
    }

    return -1;
  }
}
