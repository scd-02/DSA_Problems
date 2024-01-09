import java.util.ArrayList;

public class Bit_RotateBits {
  ArrayList<Integer> rotate(int N, int D) {
    ArrayList<Integer> ans = new ArrayList<>();

    D = D % 16;

    ans.add(rotateLeft(N, D));
    ans.add(rotateRight(N, D));

    return ans;
  }

  int rotateLeft(int n, int d) {

    return ((n << d) | (n >> (16 - d))) & 0xFFFF;
  }

  int rotateRight(int n, int d) {

    return ((n >> d) | (n << (16 - d))) & 0xffff;
  }
}