public class Array_ThreeConsecutiveOdds {
  public boolean threeConsecutiveOdds(int[] arr) {
    int window = 0;
    for (int i = 0; i < arr.length; i++) {

      if (arr[i] % 2 != 0) {
        window++;
        if (window % 3 == 0)
          return true;
      } else {
        window = 0;
      }

    }

    return false;
  }
}
