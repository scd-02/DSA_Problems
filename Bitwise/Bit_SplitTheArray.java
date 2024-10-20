public class Bit_SplitTheArray {
  public static int countgroup(int arr[]) {
    int xor = 0;

    for (int ele : arr) {
      xor ^= ele;
    }

    if (xor != 0)
      return 0;

    int mod = 1_000_000_000 + 7;
    int ans = 1;

    for (int i = 0; i < arr.length - 1; i++) {
      ans = (ans << 1) % mod;
    }

    return (ans - 1) % mod;
  }
}
