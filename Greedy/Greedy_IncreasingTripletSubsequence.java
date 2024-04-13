public class Greedy_IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {

    int max1 = Integer.MAX_VALUE;
    int max2 = Integer.MAX_VALUE;

    for (int ele : nums) {
      if (ele <= max1)
        max1 = ele;
      else if (ele <= max2)
        max2 = ele;
      else
        return true;
    }

    return false;
  }

}