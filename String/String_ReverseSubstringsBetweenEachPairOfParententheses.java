import java.util.Stack;

public class String_ReverseSubstringsBetweenEachPairOfParententheses {

  // Approach 1: Stack with reverse operation
  class Solution {

    public String reverseParentheses(String s) {
      Stack<Integer> openParenthesesIndices = new Stack<>();
      StringBuilder result = new StringBuilder();

      for (char currentChar : s.toCharArray()) {
        if (currentChar == '(') {
          // Store the current length as the start index for future reversal
          openParenthesesIndices.push(result.length());
        } else if (currentChar == ')') {
          int start = openParenthesesIndices.pop();
          // Reverse the substring between the matching parentheses
          reverse(result, start, result.length() - 1);
        } else {
          // Append non-parenthesis characters to the processed string
          result.append(currentChar);
        }
      }

      return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
      while (start < end) {
        char temp = sb.charAt(start);
        sb.setCharAt(start++, sb.charAt(end));
        sb.setCharAt(end--, temp);
      }
    }
  }

  // Approach 2: warmhole teleportation technique
  public String reverseParentheses(String s) {
    int n = s.length();
    Stack<Integer> openParenthesesIndices = new Stack<>();
    int[] pair = new int[n];

    // First pass: Pair up parentheses
    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == '(') {
        openParenthesesIndices.push(i);
      }
      if (s.charAt(i) == ')') {
        int j = openParenthesesIndices.pop();
        pair[i] = j;
        pair[j] = i;
      }
    }

    // Second pass: Build the result string
    StringBuilder result = new StringBuilder();
    for (int currIndex = 0, direction = 1; currIndex < n; currIndex += direction) {
      if (s.charAt(currIndex) == '(' || s.charAt(currIndex) == ')') {
        currIndex = pair[currIndex];
        direction = -direction;
      } else {
        result.append(s.charAt(currIndex));
      }
    }

    return result.toString();
  }
}
