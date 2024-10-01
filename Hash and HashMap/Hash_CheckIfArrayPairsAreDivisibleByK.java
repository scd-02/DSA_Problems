public class Hash_CheckIfArrayPairsAreDivisibleByK {
  public boolean canArrange(int[] arr, int k) {

    int remFreq[] = new int[k];

    for (int ele : arr) {
      int rem = ((ele % k) + k) % k;
      remFreq[rem]++;
    }

    for (int i = 0; i < k; i++) {
      if (i == 0) {
        if (remFreq[i] % 2 == 1)
          return false;
      } else if (remFreq[i] != remFreq[k - i])
        return false;
    }

    return true;
  }
}
