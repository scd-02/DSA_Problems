public class Dp_MaximumSumProblem {
  public int maxSum(int n) 
    { 
        // return rec(n);
        
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        
        // return mem(n, dp);
        
        return tab(n);
    } 
    
    int rec(int i){
        
        if(i == 0) return 0;
    
        int d2 = rec(i/2), d3 = rec(i/3), d4 = rec(i/4);
        
        return Math.max(i, (d2 + d3 + d4)); 
    }
    
    int mem(int i, int dp[]){
        if(i == 0) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int d2 = mem(i/2, dp), d3 = mem(i/3, dp), d4 = mem(i/4, dp);
        
        return dp[i] = Math.max(i, (d2 + d3 + d4)); 
    }
    
    int tab(int n){
        
        int dp[] = new int[n + 1];
        
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++){
        
            int d2 = dp[i/2], d3 = dp[i/3], d4 = dp[i/4];
            
            dp[i] = Math.max(i, (d2 + d3 + d4)); 
        }
        
        return dp[n];
    }
}
