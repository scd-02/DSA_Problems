public class Bs_KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {

    int low = 1, high = piles[0];

    for (int ele : piles) {
      high = Math.max(ele, high);
    }

    int ans = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      int totalTime = totalHrs(piles, mid);

      // totalTime > 0 is used for handling the overflow error
      if (totalTime > 0 && totalTime <= h) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  int totalHrs(int piles[], int mid) {

    int count = 0;
    for (int ele : piles) {
      if (ele % mid == 0) {
        count += ele / mid;
      } else {
        count += (ele / mid) + 1;
      }
    }

    return count;
  }
}
