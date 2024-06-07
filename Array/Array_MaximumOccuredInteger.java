public class Array_MaximumOccuredInteger {
  public static int maxOccured(int n, int l[], int r[], int maxx) {

    // used the concept of difference array
    int diffArr[] = new int[maxx + 2];

    for (int i = 0; i < n; i++) {
      diffArr[l[i]]++;
      diffArr[r[i] + 1]--;
    }

    // compute the prefix sum
    int maxSum = diffArr[0];
    int index = 0;
    for (int i = 1; i <= maxx; i++) {
      diffArr[i] = diffArr[i] + diffArr[i - 1];
      if (diffArr[i] > maxSum) {
        maxSum = diffArr[i];
        index = i;
      }
    }

    return index;
  }
}
