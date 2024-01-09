import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_AccountMerge {
  static class DSU {

    int parent[];
    int rank[];

    DSU(int v) {
      parent = new int[v];
      rank = new int[v];

      for (int i = 0; i < v; i++) {
        parent[i] = i;
      }
    }

    int find(int x) {

      if (parent[x] == x) {
        return x;
      }

      return parent[x] = find(parent[x]);
    }

    void unionByRank(int x, int y) {
      int up_x = find(x);
      int up_y = find(y);

      if (up_x == up_y)
        return;

      if (rank[up_x] < rank[up_y]) {
        parent[up_x] = up_y;
      } else if (rank[up_x] > rank[up_y]) {
        parent[up_y] = up_x;
      } else {
        parent[up_y] = up_x;
        rank[up_x] += 1;
      }
    }
  }

  static List<List<String>> accountsMerge(List<List<String>> accounts) {

    int size = accounts.size();

    DSU dsu = new DSU(size);
    HashMap<String, Integer> map = new HashMap<>();

    // union
    for (int i = 0; i < size; i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {

        String email = accounts.get(i).get(j);

        if (map.containsKey(email)) {
          dsu.unionByRank(map.get(email), i);
        } else {
          map.put(email, i);
        }
      }
    }

    // merge
    ArrayList<ArrayList<String>> merged = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      merged.add(new ArrayList<>());
    }

    for (Map.Entry<String, Integer> it : map.entrySet()) {

      String mail = it.getKey();
      int owner = it.getValue();

      merged.get(dsu.find(owner)).add(mail);

    }

    // ans
    List<List<String>> ans = new ArrayList<>();

    for (int i = 0; i < size; i++) {

      if (merged.get(i).size() == 0) {
        continue;
      }

      Collections.sort(merged.get(i));

      List<String> temp = new ArrayList<>();
      temp.add(accounts.get(i).get(0));

      for (String e : merged.get(i)) {
        temp.add(e);
      }

      ans.add(temp);
    }

    return ans;
  }
}
