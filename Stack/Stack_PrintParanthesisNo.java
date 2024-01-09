import java.util.Stack;

public class Stack_PrintParanthesisNo {
  public static void printParNo(String s, int size) {
    Stack<Integer> stk = new Stack<>();
    int count = 1;
    String result = "";
    ;

    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stk.push(count);
        result += count;
        count++;
      } else if (ch == ')') {
        result += stk.pop();
      }
    }
    System.out.println(result);
  }

  public static void main(String[] args) {
    String s = "(((a+(b))+(c+d)))";
    printParNo(s, s.length());
  }
}
