public class Tree_StepByStepDirectionsFromABinaryTreeNodeToAnother {
  
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {

    StringBuilder pathToStart = new StringBuilder();
    StringBuilder pathToDest = new StringBuilder();

    findPath(root, startValue, pathToStart);
    findPath(root, destValue, pathToDest);

    StringBuilder directions = new StringBuilder();
    int common = 0;

    while (common < pathToStart.length() &&
        common < pathToDest.length() &&
        pathToStart.charAt(common) == pathToDest.charAt(common)) {
      common++;
    }

    for (int i = 0; i < pathToStart.length() - common; i++) {
      directions.append("U");
    }

    for (int i = common; i < pathToDest.length(); i++) {
      directions.append(pathToDest.charAt(i));
    }

    return directions.toString();
  }

  boolean findPath(TreeNode root, int target, StringBuilder path) {
    if (root == null)
      return false;

    if (root.val == target)
      return true;

    path.append("L");
    if (findPath(root.left, target, path))
      return true;

    path.deleteCharAt(path.length() - 1);

    path.append("R");
    if (findPath(root.right, target, path))
      return true;

    path.deleteCharAt(path.length() - 1);

    return false;
  }
}
