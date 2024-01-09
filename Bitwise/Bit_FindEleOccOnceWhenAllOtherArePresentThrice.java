public class Bit_FindEleOccOnceWhenAllOtherArePresentThrice {
  static int singleElement(int[] arr, int N) {

    int ans = 0;

    for (int bit = 0; bit < 32; bit++) {

      int mask = 1 << bit;
      int count = 0;

      for (int i = 0; i < N; i++) {

        if ((arr[i] & mask) != 0) {
          count++;
        }

      }

      if (count % 3 != 0) {
        ans |= mask;
      }

    }

    return ans;
  }
}
