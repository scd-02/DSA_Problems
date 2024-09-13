public class Bit_XORQueriesOfASubarray {
  public int[] xorQueries(int[] arr, int[][] queries) {

    int ans[] = new int[queries.length];

    for (int i = 1; i < arr.length; i++) {
      arr[i] ^= arr[i - 1];
    }

    for (int i = 0; i < queries.length; i++) {
      int query[] = queries[i];

      if (query[0] > 0) {
        ans[i] = arr[query[0] - 1] ^ arr[query[1]];
      } else {
        ans[i] = arr[query[1]];
      }
    }

    return ans;
  }
}
