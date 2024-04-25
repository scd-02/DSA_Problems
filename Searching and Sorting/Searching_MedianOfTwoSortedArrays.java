public class Searching_MedianOfTwoSortedArrays {
  static double medianOfArrays(int n, int m, int a[], int b[]) {
    int total = n + m;

    int i = 0, j = 0, k = 0;

    int mid1 = -1, mid2 = -1;
    boolean isMid1 = false, isMid2 = false;

    while (i < n && j < m) {

      if (a[i] < b[j]) {
        if (k == (total / 2) && !isMid2) {
          mid2 = a[i];
          isMid2 = true;
        }

        if (k == ((total - 1) / 2) && !isMid1) {
          mid1 = a[i];
          isMid1 = true;
        }

        i++;
        k++;
      } else {

        if (k == (total / 2) && !isMid2) {
          mid2 = b[j];
          isMid2 = true;
        }

        if (k == ((total - 1) / 2) && !isMid1) {
          mid1 = b[j];
          isMid1 = true;
        }

        j++;
        k++;
      }
    }

    while (i < n) {
      if (k == (total / 2) && !isMid2) {
        mid2 = a[i];
        isMid2 = true;
      }

      if (k == ((total - 1) / 2) && !isMid1) {
        mid1 = a[i];
        isMid1 = true;
      }
      i++;
      k++;
    }

    while (j < m) {

      if (k == (total / 2) && !isMid2) {
        mid2 = b[j];
        isMid2 = true;
      }

      if (k == ((total - 1) / 2) && !isMid1) {
        mid1 = b[j];
        isMid1 = true;
      }
      j++;
      k++;
    }

    if (total % 2 != 0)
      return (double) mid2;

    return (mid1 + mid2) / 2.0;
  }
}
