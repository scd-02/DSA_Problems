import java.util.List;

public class Array_MaxSumPathInTwoArrays {
  public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {

    int n1 = arr1.size(), n2 = arr2.size();

    int totalSum = 0, sum1 = 0, sum2 = 0;

    int i = 0, j = 0;
    while (i < n1 || j < n2) {

      int a = i < n1 ? arr1.get(i) : Integer.MAX_VALUE;
      int b = j < n2 ? arr2.get(j) : Integer.MAX_VALUE;

      if (a < b) {
        sum1 += a;
        i++;
      } else if (b < a) {
        sum2 += b;
        j++;
      } else {
        totalSum += Math.max(sum1, sum2) + a;
        sum1 = 0;
        sum2 = 0;
        i++;
        j++;
      }

      // System.out.println(sum1 + " " + sum2);
    }
    return totalSum + Math.max(sum1, sum2);
  }
}
