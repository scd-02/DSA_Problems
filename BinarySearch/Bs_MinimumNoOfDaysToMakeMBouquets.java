public class Bs_MinimumNoOfDaysToMakeMBouquets {
  public int minDays(int[] bloomDay, int m, int k) {

    // base case
    long totalFlowers = (long) m * k;
    if (totalFlowers > bloomDay.length)
      return -1;

    int low = bloomDay[0], high = bloomDay[0];
    for (int day : bloomDay) {
      low = Math.min(day, low);
      high = Math.max(day, high);
    }

    while (low <= high) {
      int mid = (low + high) / 2;

      int noOfBouquet = totalBouquet(bloomDay, mid, k);

      if (noOfBouquet >= m) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  int totalBouquet(int[] bloomDay, int day, int k) {
    int count = 0, bouquet = 0;

    for (int i = 0; i < bloomDay.length; i++) {

      if (bloomDay[i] <= day) {
        count++;
      } else {
        bouquet += count / k;
        count = 0;
      }
    }

    bouquet += count / k;

    return bouquet;
  }
}
