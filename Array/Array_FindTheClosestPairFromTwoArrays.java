import java.util.ArrayList;

public class Array_FindTheClosestPairFromTwoArrays {
  public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {

    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(-1);
    ans.add(-1);

    int i = 0, j = m - 1;
    int diff = Integer.MAX_VALUE;

    while (i < n && j >= 0) {

      int currDiff = Math.abs(arr[i] + brr[j] - x);

      if (currDiff < diff) {
        diff = currDiff;
        ans.add(0, arr[i]);
        ans.add(1, brr[j]);
      }

      if (arr[i] + brr[j] <= x) {
        i++;
      } else {
        j--;
      }
    }

    return ans;
  }
}
