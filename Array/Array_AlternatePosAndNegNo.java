import java.util.ArrayList;

public class Array_AlternatePosAndNegNo {
  void rearrange(int arr[], int size) {
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      if (arr[i] < 0) {
        neg.add(arr[i]);
      } else {
        pos.add(arr[i]);
      }
    }

    int p = 0, n = 0, k = 0;
    while (p < pos.size() && n < neg.size()) {
      arr[k++] = pos.get(p);
      p++;
      arr[k++] = neg.get(n);
      n++;
    }

    while (p < pos.size()) {
      arr[k++] = pos.get(p);
      p++;
    }

    while (n < neg.size()) {
      arr[k++] = neg.get(n);
      n++;
    }
  }
}
