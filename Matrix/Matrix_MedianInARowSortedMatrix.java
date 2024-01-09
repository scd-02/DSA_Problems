public class Matrix_MedianInARowSortedMatrix {
  int median(int matrix[][], int R, int C) {

    int N = (R * C) / 2;

    int start = 1;
    int end = 2000;

    while (start <= end) {

      int assumedMedian = (start + end) / 2;
      int lessThanAssumMedi = lessThan(matrix, assumedMedian);

      if (lessThanAssumMedi <= N) {
        start = assumedMedian + 1;
      } else {
        end = assumedMedian - 1;
      }

    }

    return start;
  }

  int lessThan(int matrix[][], int median) {

    int totalEle = 0;

    for (int i = 0; i < matrix.length; i++) {

      int start = 0;
      int end = matrix[i].length - 1;

      while (start <= end) {

        int mid = (start + end) / 2;

        if (matrix[i][mid] <= median) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }

      }

      totalEle += start;

    }

    return totalEle;

  }
}
