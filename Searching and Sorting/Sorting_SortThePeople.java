public class Sorting_SortThePeople {
  public String[] sortPeople(String[] names, int[] heights) {
    quickSort(names, heights, 0, names.length - 1);
    return names;
  }

  void quickSort(String[] names, int[] heights, int start, int end) {

    if (start < end) {
      int partitionInd = partition(names, heights, start, end);

      quickSort(names, heights, start, partitionInd - 1);
      quickSort(names, heights, partitionInd + 1, end);
    }
  }

  int partition(String[] names, int[] heights, int start, int end) {

    int pivot = heights[end];

    int ind = start - 1;

    for (int i = start; i < end; i++) {
      if (heights[i] >= pivot) {
        ind++;
        swap(names, heights, ind, i);
      }
    }

    swap(names, heights, ind + 1, end);
    return ind + 1;
  }

  void swap(String names[], int heights[], int i, int j) {
    String tempName = names[i];
    names[i] = names[j];
    names[j] = tempName;

    int tempHeight = heights[i];
    heights[i] = heights[j];
    heights[j] = tempHeight;
  }
}
