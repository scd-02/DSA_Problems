public class Bs_KthSmallestPrimeFraction {
  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    int n = arr.length;
    int ans[] = new int[2];

    double low = 0, high = 1, mid = 0;

    while(low <= high){
        mid = (low + high) / 2;

        int num = 0, deno = 0, j = 1;
        int total = 0;
        double maxFrac = 0;

        for(int i = 0; i < n; i++){

            while(j < n && arr[i] >= arr[j] * mid){
                ++j;
            }

            total += n - j;

            if(j < n && maxFrac < arr[i] * 1.0 / arr[j]){
                maxFrac = arr[i] * 1.0 / arr[j];
                num = i;
                deno = j;
            }

        }

        if(total == k){
            ans[0] = arr[num];
            ans[1] = arr[deno];
            break;
        }else if(total < k){
            low = mid;
        }else{
            high = mid;
        }
    }

    return ans;
}
}
