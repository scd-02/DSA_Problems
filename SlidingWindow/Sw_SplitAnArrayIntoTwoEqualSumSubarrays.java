public class Sw_SplitAnArrayIntoTwoEqualSumSubarrays {
  public boolean canSplit(int arr[]) {

    int leftSum = 0;

    for (int ele : arr) {
      leftSum += ele;
    }

    int rightSum = 0;

    for (int i = arr.length - 1; i >= 1; i--) {

      leftSum -= arr[i];
      rightSum += arr[i];

      if (leftSum == rightSum)
        return true;
    }

    return false;
  }
}
