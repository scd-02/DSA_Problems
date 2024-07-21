import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Matrix_BuildAMatrixWithConditions {
  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int orderRow[] = topoSort(rowConditions, k);
        int orderCol[] = topoSort(colConditions, k);

        if(orderRow.length == 0 || orderCol.length == 0) return new int[0][0];
        
        int ans[][] = new int[k][k];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(orderRow[i] == orderCol[j]){
                    ans[i][j] = orderRow[i];
                }
            }
        }
        
        return ans;
    }

    int[] topoSort(int[][] edges, int n){

        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        int inDeg[] = new int[n + 1];
        int order[] = new int[n];

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            inDeg[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(inDeg[i] == 0) q.offer(i);
        }

        int ind = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            order[ind++] = u;
            n--;

            for(int v: adj[u]){
                inDeg[v]--;
                if(inDeg[v] == 0) q.offer(v);
            }
        }

        if(n != 0) return new int[0];
        return order;
    }
}
