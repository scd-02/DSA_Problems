import java.util.ArrayList;
import java.util.List;

public class String_FindTheClosestPalindrome {
  public String nearestPalindromic(String n) {

    long num = Long.parseLong(n);
    int len = n.length();

    int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;

    long firstHalf = Long.parseLong(n.substring(0, mid + 1));

    List<Long> possibilities = new ArrayList<>();

    possibilities.add(toPalindrome(firstHalf, len % 2 == 0));
    possibilities.add(toPalindrome(firstHalf + 1, len % 2 == 0));
    possibilities.add(toPalindrome(firstHalf - 1, len % 2 == 0));
    possibilities.add((long) Math.pow(10, len - 1) - 1);
    possibilities.add((long) Math.pow(10, len) + 1);

    long diff = Long.MAX_VALUE, res = 0;
    for (long ele : possibilities) {
      if (ele == num)
        continue;
      if (Math.abs(ele - num) < diff) {
        diff = Math.abs(ele - num);
        res = ele;
      } else if (Math.abs(ele - num) == diff) {
        res = Math.min(ele, res);
      }
    }

    return String.valueOf(res);
  }

  private long toPalindrome(long left, boolean isEven) {
    long res = left;

    if (!isEven)
      left = left / 10;
    while (left > 0) {
      res = res * 10 + left % 10;
      left /= 10;
    }

    return res;
  }
}
