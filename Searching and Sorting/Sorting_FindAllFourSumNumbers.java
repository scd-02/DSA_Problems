import java.util.ArrayList;
import java.util.Arrays;

public class Sorting_FindAllFourSumNumbers {
  public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        int n = arr.length;
        
        for(int i = 0; i < n - 3; i++){
            
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            
            for(int j = i + 1; j < n - 2; j++){
                
                if(j > i + 1 && arr[j] == arr[j - 1]) continue;
                
                int s = j + 1;
                int e = n - 1;
                
                while(s < e){
                    int sum = arr[i] + arr[j] + arr[s] + arr[e];
                    
                    if(sum == k){
                        ArrayList<Integer> temp = new ArrayList<>();
                        
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[s]);
                        temp.add(arr[e]);
                        
                        ans.add(temp);
                        
                        while(s < e && arr[s] == arr[s + 1]) s++;
                        while(e > s && arr[e] == arr[e - 1]) e--;
                        
                        s++; e--;
                        
                    }else if(sum < k){
                        s++;
                    }else{
                        e--;
                    }
                }
            }
        }
        
        return ans;
    }
}
