public class Array_ContainerWithMostWater {

  public int maxArea(int[] height) {

    int left = 0, right = height.length - 1;

    int maxArea = 0;

    while (left < right) {
      int currArea = Math.min(height[left], height[right]) * (right - left);
      maxArea = Math.max(currArea, maxArea);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }

  public int maxArea2(int[] height) {

    int left = 0, right = height.length - 1;
    int maxArea = 0;
    int minHeight = 0;

    while (left < right) {
      minHeight = Math.min(height[left], height[right]);

      if (minHeight * (right - left) > maxArea)
        maxArea = minHeight * (right - left);

      while (left < right && height[left] <= minHeight)
        left++;
      while (left < right && height[right] <= minHeight)
        right--;
    }

    return maxArea;
  }
}
