public class Bs_SearchA2DMatrix {
  class SolutionFlatteningMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

      int n = matrix.length;
      int m = matrix[0].length;

      int low = 0, high = n * m - 1;

      while (low <= high) {

        int mid = (low + high) / 2;
        int row = mid / m;
        int col = mid % m;

        if (matrix[row][col] == target)
          return true;
        else if (matrix[row][col] < target)
          low = mid + 1;
        else
          high = mid - 1;

      }

      return false;
    }

  }

  class SolutionBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {

      int m = matrix.length;
      int n = matrix[0].length;

      int rs = 0, re = m - 1;

      int probableIndex = binarySearch(rs, re, matrix, target);

      if (probableIndex < 0) {
        probableIndex += 1;
      }
      System.out.println(probableIndex);
      int s = 0, e = n - 1;
      while (s <= e) {
        int mid = (s + e) / 2;

        if (matrix[probableIndex][mid] == target) {
          return true;
        } else if (matrix[probableIndex][mid] > target) {
          e = mid - 1;
        } else {
          s = mid + 1;
        }
      }

      return false;
    }

    public int binarySearch(int s, int e, int matrix[][], int target) {

      while (s <= e) {

        int mid = (s + e) / 2;
        if (matrix[mid][0] == target) {
          return mid;
        } else if (matrix[mid][0] > target) {
          e = mid - 1;
        } else {
          s = mid + 1;
        }

      }
      return e;
    }
  }
}
