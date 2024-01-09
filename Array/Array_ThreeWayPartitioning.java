public class Array_ThreeWayPartitioning {
  public static void threeWayPartition(int arr[], int a, int b) {
    int size = arr.length;
    int start = 0;
    int end = size - 1;

    while (start < end) {
      while (start < size && arr[start] < a)
        start++;
      while (end >= 0 && arr[end] >= a)
        end--;
      if (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }
    }

    end = arr.length - 1;

    while (start < end) {
      while (start < size && arr[start] <= b)
        start++;
      while (end >= 0 && arr[end] > b)
        end--;
      if (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }
    }

  }

  public static void main(String[] args) {
    int a []= {3, 18, 93, 53, 57, 2, 81, 87, 42, 66, 90, 4,5, 20 ,41 ,30, 32 ,18, 98};

    threeWayPartition(a, 22, 53);

    for(int e:a){
      System.out.print(e+" ");
    }
  }
}
