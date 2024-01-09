import java.util.Arrays;

public class leetcode {

  static long maxTasks(int n, int[] limit) {
    long maxTasks = n * limit[0];
    long task = 0;
    Arrays.sort(limit);
    for(int e: limit){
      System.out.print(e+" ");
    }
    for (int i = 1; i < limit.length; i++) {
      if (limit[i] != limit[i - 1]) {
        task = (n - i) * limit[i];
        maxTasks = Math.max(maxTasks, task);
      }
    }
    return maxTasks;
  }

  public static void main(String[] args) {
    int a[] = { 852, 940, 630, 990, 318, 886, 901, 424, 558, 523, 66, 369, 386, 969, 876, 806, 990, 818, 774, 864, 63,
        829, 651, 54, 801 };
    System.out.println(maxTasks(a.length, a));
  }
}
