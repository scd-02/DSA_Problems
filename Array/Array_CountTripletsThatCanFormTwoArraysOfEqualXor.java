public class Array_CountTripletsThatCanFormTwoArraysOfEqualXor {
  public int countTriplets(int[] arr) {

    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      int xorSum = arr[i];
      for (int j = i + 1; j < arr.length; j++) {

        xorSum ^= arr[j];
        if (xorSum == 0)
          count += (j - i);
      }
    }

    return count;
  }
}
