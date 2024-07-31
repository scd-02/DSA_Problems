
public class Dp_FillingBookcaseShelves {

  public int minHeightShelves(int[][] books, int shelfWidth) {
    // int dp[][] = new int[books.length][shelfWidth + 1];
    // return mem(books, shelfWidth, 0, shelfWidth, dp, 0);
    return tab(books, shelfWidth);
  }

  public int tab(int[][] books, int shelfWidth) {
    int n = books.length;

    int dp[] = new int[n + 1];

    dp[0] = 0;
    dp[1] = books[0][1];

    for (int i = 2; i <= n; i++) {

      int currBook[] = books[i - 1];
      int remainingWidth = shelfWidth - currBook[0];
      int maxHeight = currBook[1];

      // keeping book in new Shelf
      dp[i] = dp[i - 1] + currBook[1];

      // keeping book in the previous shelf if its compatible
      int j = i - 1;

      while (j > 0 && remainingWidth - books[j - 1][0] >= 0) {
        remainingWidth -= books[j - 1][0];
        maxHeight = Math.max(maxHeight, books[j - 1][1]);
        dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
      }
    }

    return dp[n];
  }

  public int mem(int[][] books, int shelfWidth, int i, int currentWidth, int[][] dp, int maxHeight) {

    if (i == books.length - 1) {

      if (currentWidth >= books[i][0])
        return Math.max(maxHeight, books[i][1]);

      return maxHeight + books[i][1];

    }

    if (dp[i][currentWidth] != 0)
      return dp[i][currentWidth];

    // new shelf
    int newShelf = maxHeight + mem(books, shelfWidth, i + 1, shelfWidth - books[i][0], dp, books[i][1]);
    dp[i][currentWidth] = newShelf;

    // current shelf
    if (currentWidth >= books[i][0]) {
      int currShelf = mem(books, shelfWidth, i + 1, currentWidth - books[i][0], dp, Math.max(maxHeight, books[i][1]));
      dp[i][currentWidth] = Math.min(newShelf, currShelf);
    }

    return dp[i][currentWidth];
  }
}