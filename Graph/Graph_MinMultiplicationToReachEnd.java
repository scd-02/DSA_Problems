import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_MinMultiplicationToReachEnd {

  class Pair {
    int v;
    int dis;

    Pair(int v, int dis) {
      this.v = v;
      this.dis = dis;
    }
  }

  int minimumMultiplicationsDjikstra(int[] arr, int start, int end) {

    if (start == end)
      return 0;

    // djikstra's algo
    int steps[] = new int[100000];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[start] = 0;

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(start, 0));

    while (!q.isEmpty()) {
      Pair node = q.poll();
      int u = node.v;
      int dis = node.dis;

      if (u == end)
        return steps[u];

      for (int num : arr) {

        int v = (u * num) % 100_000;

        if (dis + 1 < steps[v]) {

          steps[v] = dis + 1;
          q.add(new Pair(v, steps[v]));

        }
      }
    }

    return -1;

  }

  int minimumMultiplications(int[] arr, int start, int end) {

    if (start == end)
      return 0;

    // BFS
    // using this approach giving tle
    // Queue<Integer> q = new LinkedList<>();
    // q.offer(start);

    // HashMap<Integer, Integer> map = new HashMap<>();
    // map.put(start, 0);

    // while(!q.isEmpty()){

    // int currStart = q.poll();
    // int currOper = map.get(currStart);

    // for(int i = 0; i < arr.length; i++){

    // int newStart = ((currStart % 100000) * (arr[i] % 100000)) % 100000;

    // if(newStart == end) return currOper + 1;

    // if(!map.containsKey(newStart)){
    // map.put(newStart, currOper + 1);
    // q.offer(newStart);
    // }

    // }
    // }

    // return -1;

    int maxLimit = 100001;
    int[] steps = new int[maxLimit];
    Arrays.fill(steps, -1);

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    steps[start] = 0;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      if (current == end) {
        return steps[current];
      }

      for (int number : arr) {
        int newStart = (current * number) % 100000;
        if (steps[newStart] == -1) {
          steps[newStart] = steps[current] + 1;
          queue.offer(newStart);
        }
      }
    }

    return -1;

  }

  // for small cases it can handle but for large case it gets stack overflow error
  // static int minLen = Integer.MAX_VALUE;
  // static void dfs(int arr[], int start, int end, int count){

  // if(start > end || count >= minLen){
  // return ;
  // }

  // if(start == end){
  // minLen = Math.min(minLen, count);
  // return;
  // }

  // for(int i = 0; i < arr.length; i++){

  // int mul = (start * arr[i]) % 100000;

  // dfs(arr, mul, end, count+1);

  // }

  // }

}
