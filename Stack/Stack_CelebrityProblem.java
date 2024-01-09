import java.util.Stack;

public class Stack_CelebrityProblem {
  int celebrity(int M[][], int n) {

    for (int person = 0; person < n; person++) {

      boolean knowSomeone = false;
      boolean everyoneKnows = true;

      for (int col = 0; col < n; col++) {
        if (M[person][col] == 1 && person != col) {
          knowSomeone = true;
        }
      }

      for (int row = 0; row < n; row++) {
        if (M[row][person] == 0 && person != row) {
          everyoneKnows = false;
        }
      }

      if (((!knowSomeone) && everyoneKnows))
        return person;

    }

    return -1;
  }

  int celebrityUsingStack(int M[][], int n) {

    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < n; i++) {
      stk.push(i);
    }

    while (stk.size() != 1) {

      int first = stk.pop();
      int second = stk.pop();

      if (M[first][second] == 1) {
        stk.push(second);
      } else {
        stk.push(first);
      }

    }

    int person = stk.pop();

    for (int i = 0; i < n; i++) {

      if (person != i && (M[person][i] == 1 || M[i][person] == 0)) {
        return -1;
      }
    }

    return person;
  }
}
