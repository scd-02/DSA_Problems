import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph_DSU_PossiblePathsInATree {
  class DSU {

    int parent[], size[];

    DSU(int n) {

      parent = new int[n + 1];
      size = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    int find(int x) {

      if (parent[x] == x) {
        return x;
      }

      return parent[x] = find(parent[x]);
    }

    int union(int a, int b) {

      int root_a = find(a);
      int root_b = find(b);

      int res = size[root_a] * size[root_b];

      if (root_a == root_b) {
        return res;
      }

      if (size[root_a] < size[root_b]) {

        parent[root_a] = root_b;
        size[root_b] += size[root_a];

      } else {

        parent[root_b] = root_a;
        size[root_a] += size[root_b];

      }

      return res;
    }
  }

  class Solution {
    ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {

      DSU dsu = new DSU(n);

      Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

      TreeMap<Integer, Integer> map = new TreeMap<>();
      int prevPaths = 0;

      for (int[] edge : edges) {

        int union = dsu.union(edge[0], edge[1]);
        int paths = prevPaths + union;

        map.put(edge[2], paths);
        prevPaths = paths;

      }

      ArrayList<Integer> ans = new ArrayList<>();

      for (int i = 0; i < q; i++) {

        Map.Entry<Integer, Integer> val = map.floorEntry(queries[i]);

        if (val == null)
          ans.add(0);
        else
          ans.add(val.getValue());
      }

      return ans;
    }

     ArrayList<Integer> maximumWeightUingHashMap(int n, int edges[][], int q, int queries[]) {
        
        DSU dsu = new DSU(n);
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int prevPaths = 0;
        
        for(int[] edge: edges){
            
            int union = dsu.union(edge[0], edge[1]);
            int paths = prevPaths + union;
            
            map.put(edge[2], paths); 
            prevPaths = paths;
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < q; i++){
            
            int maxPaths = 0;
            for(Map.Entry<Integer, Integer> ele: map.entrySet()){
                if(ele.getKey() <= queries[i]){
                    maxPaths = Math.max(maxPaths, ele.getValue());
                }
            }
            
            ans.add(maxPaths);
        }
        
        return ans;    
    }
  }
}
