public class Sorting_SwapAndMaximize {
  public long maxSum(Long[] arr) {
    int n = arr.length;
    
    Arrays.sort(arr);
    
    long sumOfDiff = 0;
    
    for(int i = 0; i < n / 2; i++){
        sumOfDiff += 2 * (arr[n - 1 - i] - arr[i]);
    }
    
    return sumOfDiff;
}
}
