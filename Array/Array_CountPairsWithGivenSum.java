import java.util.HashMap;

public class Array_CountPairsWithGivenSum {
    int getPairsCount(int[] arr, int n, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        // for storing frequency of elements
       for(int i = 0; i< n; i++){
           if(!map.containsKey(arr[i])){
               map.put(arr[i], 1);
           }else{
               map.put(arr[i], map.get(arr[i])+1);
           }
       }
       
        // for getting pairs
        for(int i = 0; i< n; i++){
            if(map.containsKey(k - arr[i])){
                count += map.get(k - arr[i]);
            }
            
            // if (arr[i] + arr[i] == sum) then decrement the count
            if(k - arr[i] == arr[i]){
                count--;
            }
        }
        
        // dividing by 2 because same pairs are counted twice
        return count>>1;
    }
}
