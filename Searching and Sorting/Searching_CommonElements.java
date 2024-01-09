import java.util.ArrayList;
import java.util.HashSet;

public class Searching_CommonElements {
  ArrayList<Integer> commonElementsWithSpace(int A[], int B[], int C[], int n1, int n2,
      int n3) {

    ArrayList<Integer> ans = new ArrayList<>();

    HashSet<Integer> a1 = new HashSet<>();
    HashSet<Integer> a2 = new HashSet<>();

    for (int i = 0; i < n1; i++) {

      a1.add(A[i]);

    }

    for (int i = 0; i < n2; i++) {

      if (a1.contains(B[i])) {
        a2.add(B[i]);
      }

    }

    for (int i = 0; i < n3; i++) {

      if (a2.contains(C[i])) {
        ans.add(C[i]);
        a2.remove(C[i]);
      }

    }

    return ans;
  }

  ArrayList<Integer> commonElementsWithoutSpace(int A[], int B[], int C[], int n1, int n2, int n3) {

    ArrayList<Integer> ans = new ArrayList<>();

    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2 && k < n3) {

      if (A[i] == B[j] && B[j] == C[k]) {

        if (ans.size() == 0) {
          ans.add(A[i]);
        } else if (ans.get(ans.size() - 1) != A[i]) {
          ans.add(A[i]);
        }

        i++;
        j++;
        k++;

      } else if (A[i] < B[j]) {
        i++;
      } else if (B[j] < C[k]) {
        j++;
      } else {
        k++;
      }

    }

    return ans;
  }
}
