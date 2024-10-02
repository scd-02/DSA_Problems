public class Simulation_RotateAndDelete {
  public static int rotateDelete(ArrayList<Integer> arr) {
    int n = arr.size();

    int k = 1;

    while (k < n) {

      Collections.rotate(arr, 1);

      arr.remove(arr.size() - k);
      n = arr.size();

      k++;
    }

    return arr.get(0);
  }
}
