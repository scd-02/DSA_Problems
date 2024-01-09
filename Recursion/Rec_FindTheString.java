import java.util.HashSet;

public class Rec_FindTheString {
  public String findString(int n, int k){
       
        // find all the string of length possible from 0 to k - 1(k^n)
        StringBuilder result = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        
        for(int i = 0; i < n; i++) 
            result.append('0');
        
        // find min length string result from those strings such that all those strings are substring in result
        hs.add(result.toString());
        dfs(result, result, hs, k);
         
        return result.toString();
    }
    
    public void dfs(StringBuilder curr, StringBuilder result, HashSet<String> hs, int k){
        
        StringBuilder temp;
        
        for(int i = k - 1; i >= 0; i--){

            temp = new StringBuilder(curr.substring(1));
            
            temp.append((char)(i + '0'));
            
            if(!hs.contains(temp.toString())){
                
                hs.add(temp.toString());
                result.append((char)(i + '0'));
                dfs(temp, result, hs, k);
                return;
            }
        }
        
    }
}
