public class Heap_DoesArrayRepresentHeap {
  public boolean countSub(long arr[], long n) {
    int index = arr.length / 2 - 1;

    for (int i = index; i >= 0; i--) {

      if (2 * i + 1 < n && arr[i] < arr[2 * i + 1]) {
        return false;
      }

      if (2 * i + 2 < n && arr[i] < arr[2 * i + 2]) {
        return false;
      }
    }

    return true;
  }
}