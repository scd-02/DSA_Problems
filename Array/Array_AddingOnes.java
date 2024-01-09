public class Array_AddingOnes {
  public static void update(int a[], int n, int updates[], int k) {
    for (int i = 0; i < k; i++) {
      updates[i] -= 1;
    }

    for (int i = 0; i < k; i++) {
      int j = updates[i];
      if (j >= 0) {
        a[j] = a[j] + 1;
      }
    }

    for (int i = 1; i < n; i++) {
      a[i] = a[i - 1] + a[i];
    }
  }
}
