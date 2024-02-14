public class Dp_GeepJump {
  public int minimumEnergy(int arr[],int N){
    // return rec(arr, N - 1);
    
    // int dp[] = new int[N];
    // Arrays.fill(dp, -1);
    // return mem(arr, N - 1, dp);
    
    return tab(arr, N);
}

public int rec(int arr[], int n){
    
    if(n == 0){
        return 0;
    }
    
    int step_1 = rec(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
    int step_2 = Integer.MAX_VALUE;
    
    if(n > 1)
        step_2 = rec(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
    
    return Math.min(step_1, step_2);
}

public int mem(int arr[], int n, int dp[]){
    
    if(n == 0){
        return 0;
    }
    
    if(dp[n] != -1){
        return dp[n];
    }
    
    int step_1 = rec(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
    int step_2 = Integer.MAX_VALUE;
    
    if(n > 1)
        step_2 = rec(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
    
    return dp[n] = Math.min(step_1, step_2);
    
}

public int tab(int arr[], int n){
    
    int dp[] = new int[n];
    
    dp[0] = 0;
    
    for(int i = 1; i < n; i++){
        int step_1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
        int step_2 = Integer.MAX_VALUE;
        
        if(i > 1){
            step_2 = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
        }
        
        dp[i] = Math.min(step_1, step_2);
    }
    
    return dp[n - 1];
}
}
