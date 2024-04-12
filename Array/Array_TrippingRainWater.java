public class Array_TrippingRainWater {
  static long trappingWater(int arr[], int n) {

    int left[] = new int[n];
    left[0] = arr[0];

    int right[] = new int[n];
    right[n - 1] = arr[n - 1];

    for (int i = 1; i < n; i++) {

      left[i] = Math.max(left[i - 1], arr[i]);
      right[n - 1 - i] = Math.max(right[n - i], arr[n - 1 - i]);

    }

    long waterTrap = 0;

    for (int i = 0; i < n; i++) {

      waterTrap += (long) Math.min(left[i], right[i]) - (long) arr[i];

    }

    return waterTrap;
  }

  public int trap(int[] height) {
    int n = height.length;

    int water = 0;
    int left = 0, right = n - 1;
    int leftBar = height[0], rightBar = height[n - 1];

    while (left < right) {

      if (leftBar <= rightBar) {
        water += leftBar - height[left];
        left++;
        leftBar = Math.max(leftBar, height[left]);
      } else {
        water += rightBar - height[right];
        right--;
        rightBar = Math.max(rightBar, height[right]);
      }
    }

    return water;
  }
}
