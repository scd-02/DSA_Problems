public class String_AdditiveSeq {

  class Solution1 {
    public boolean isAdditiveSequence(String s) {

      int n = s.length();

      if (n < 3)
        return false;

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (checkAddSeq(s, s.substring(0, i + 1), s.substring(i + 1, j + 1))) {
            return true;
          }
        }
      }

      return false;
    }

    public boolean checkAddSeq(String s, String first, String second) {

      int i = first.length() + second.length();

      while (i < s.length()) {

        if ((first.length() > 1 && first.charAt(0) == '0') ||
            (second.length() > 1 && second.charAt(0) == '0')) {
          break;
        }

        String sum = add(first, second);

        // System.out.println(first + " " + second + " " + sum);
        if (i + sum.length() < s.length() && !sum.equals(s.substring(i, i +
            sum.length()))) {
          return false;
        }

        if (sum.equals(s.substring(i))) {
          return true;
        }

        first = second;
        second = sum;
        i += sum.length();

      }

      return false;
    }

    public String add(String a, String b) {

      StringBuilder res = new StringBuilder("");
      int carry = 0;

      int i = a.length() - 1, j = b.length() - 1;

      while (i >= 0 || j >= 0 || carry > 0) {

        int num1 = i < 0 ? 0 : a.charAt(i) - '0';
        int num2 = j < 0 ? 0 : b.charAt(j) - '0';

        int sum = (num1 + num2 + carry) % 10;
        carry = (num1 + num2 + carry) / 10;

        res.insert(0, sum);
        i--;
        j--;
      }

      return res.toString();
    }

  }

  class Solution2 {

    public boolean isAdditiveSequence(String n) {
      char[] arr = n.toCharArray();
      for (int i = 1; i < 10 && i <= n.length() / 2; i++) {
        for (int j = 1; j < 10 && j <= n.length() / 2; j++) {
          int num1 = getnumber(arr, i, 0);
          int num2 = getnumber(arr, j, i);
          if (check(num1, num2, i + j, arr)) {
            return true;
          }
        }
      }
      return false;
    }

    boolean check(int num1, int num2, int index, char[] arr) {
      if (index >= arr.length) {
        return false;
      }
      while (index < arr.length) {
        int curr = num1 + num2;
        int curr_val = arr[index] - '0';
        index++;
        while (curr_val < curr && index < arr.length) {
          curr_val = 10 * curr_val + (arr[index] - '0');
          index++;
        }
        if (curr_val != curr) {
          return false;
        } else {
          num1 = num2;
          num2 = curr;
        }
      }
      return true;
    }

    int getnumber(char arr[], int len, int start) {
      int i = 0, ans = 0;
      while (i < len && i + start < arr.length) {
        ans = 10 * ans + (arr[start + i] - '0');
        i++;
      }
      return ans;
    }
  }
}
