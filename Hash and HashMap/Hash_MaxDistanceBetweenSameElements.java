import java.util.HashMap;

public class Hash_MaxDistanceBetweenSameElements {
  public int maxDistance(int[] arr) {
        
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int dis = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            if(indexMap.containsKey(arr[i])){
                dis = Math.max(dis, i - indexMap.get(arr[i]));
            }else{
                indexMap.put(arr[i], i);
            }
            
        }
        
        return dis;    
    }
}
