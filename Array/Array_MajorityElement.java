public class Array_MajorityElement {
  static int majorityElement(int a[], int size) {
    int count = 1;
    int ansInd = 0;

    for (int i = 1; i < size; i++) {
      if (a[i] == a[ansInd])
        count++;
      else
        count--;

      if (count == 0) {
        count = 1;
        ansInd = i;
      }
    }

    if (count > 0) {
      int freq = 0;
      for (int i = 0; i < size; i++) {
        if (a[i] == a[ansInd])
          freq++;
      }
      if (freq > (size >> 1))
        return a[ansInd];
    }

    return -1;
  }
}