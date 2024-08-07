public class Rec_IntegerToEnglishWords {
  class SolutionRecursion {

    private final String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety" };

    public String numberToWords(int num) {
      if (num == 0) {
        return "Zero";
      }
      return helper(num);
    }

    private String helper(int num) {
      StringBuilder result = new StringBuilder();
      if (num < 20) {
        result.append(belowTwenty[num]);
      } else if (num < 100) {
        result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
      } else if (num < 1000) {
        result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
      } else if (num < 1000000) {
        result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
      } else if (num < 1000000000) {
        result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
      } else {
        result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
      }
      return result.toString().trim();
    }
  }

  class SolutionIterative {
    public String numberToWords(int num) {

      if (num == 0)
        return "Zero";

      String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
          "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
      String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
      String[] thousands = { "", "Thousand", "Million", "Billion" };

      StringBuilder ans = new StringBuilder();
      int groupInd = 0;

      while (num > 0) {

        if (num % 1000 != 0) {

          StringBuilder group = new StringBuilder();

          int part = num % 1000;

          if (part >= 100) {
            group.append(ones[part / 100]).append(" Hundred ");
            part %= 100;
          }

          if (part >= 20) {
            group.append(tens[part / 10]).append(" ");
            part %= 10;
          }

          if (part > 0) {
            group.append(ones[part]).append(" ");
          }

          group.append(thousands[groupInd]).append(" ");
          ans.insert(0, group);
        }

        num /= 1000;
        groupInd++;
      }

      return ans.toString().trim();
    }
  }
}
