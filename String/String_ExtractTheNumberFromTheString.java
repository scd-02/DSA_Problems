import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_ExtractTheNumberFromTheString {
  long ExtractNumber(String sentence) {

    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher = pattern.matcher(sentence);

    long max = -1;
    while (matcher.find()) {

      String num = matcher.group();

      if (!num.contains("9")) {
        max = Math.max(max, Long.parseLong(num));
      }
    }

    return max;
  }
}
