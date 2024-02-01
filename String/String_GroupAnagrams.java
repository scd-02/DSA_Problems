import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){

            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String sortStr = new String(s);

            if(map.containsKey(sortStr)){
                map.get(sortStr).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(sortStr, temp);
            }

        }

        for(Map.Entry<String, List<String>> e: map.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}
