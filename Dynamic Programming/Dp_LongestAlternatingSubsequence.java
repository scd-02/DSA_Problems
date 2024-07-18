public class Dp_LongestAlternatingSubsequence {
  public int alternatingMaxLengthTab(int[] arr) {

    int n = arr.length;
    int dp[][] = new int[n][2];

    dp[0][0] = dp[0][1] = 1;

    int res = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {

        if (arr[j] < arr[i] && dp[i][0] < dp[j][1] + 1) {
          dp[i][0] = dp[j][1] + 1;
        }

        if (arr[j] > arr[i] && dp[i][1] < dp[j][0] + 1) {
          dp[i][1] = dp[j][0] + 1;
        }

      }

      res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
    }

    return res;
  }

  public int alternatingMaxLengthSO(int[] arr) {
        
    int inc = 1, dec = 1;
    
    for(int i = 1; i < arr.length; i++){
        
        if(arr[i] > arr[i - 1]){
            inc = dec + 1;
        }else if(arr[i] < arr[i - 1]){
            dec = inc + 1;
        }
    }
    
    return Math.max(inc, dec);
}
}
