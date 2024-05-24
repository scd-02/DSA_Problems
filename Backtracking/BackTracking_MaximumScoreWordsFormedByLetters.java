import java.util.Arrays;

public class BackTracking_MaximumScoreWordsFormedByLetters {
  class SolutionIterativeRec {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

      int n = words.length;
      int freq[] = new int[26];

      for (char ch : letters) {
        freq[ch - 'a']++;
      }

      int subsetChar[] = new int[26];
      int maxScore = 0;

      for (int mask = 0; mask < (1 << n); mask++) {

        Arrays.fill(subsetChar, 0);
        for (int i = 0; i < n; i++) {
          if ((mask & (1 << i)) > 0) {

            for (int j = 0; j < words[i].length(); j++) {
              subsetChar[words[i].charAt(j) - 'a']++;
            }
          }
        }

        maxScore = Math.max(maxScore, subsetScore(subsetChar, freq, score));
      }

      return maxScore;
    }

    public int subsetScore(int subsetChar[], int freq[], int score[]) {

      int totalScore = 0;

      for (int i = 0; i < subsetChar.length; i++) {

        if (subsetChar[i] > freq[i])
          return 0;
        totalScore += subsetChar[i] * score[i];
      }

      return totalScore;
    }
  }

  class SolutionBacktracking {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
      int W = words.length;
      // Count how many times each letter occurs
      freq = new int[26];
      for (char c : letters) {
        freq[c - 'a']++;
      }
      maxScore = 0;
      check(W - 1, words, score, new int[26], 0);
      return maxScore;
    }

    // Check if adding this word exceeds the frequency of any letter
    private boolean isValidWord(int[] subsetLetters) {
      for (int c = 0; c < 26; c++) {
        if (freq[c] < subsetLetters[c]) {
          return false;
        }
      }
      return true;
    }

    private int maxScore;
    private int[] freq;

    private void check(int w, String[] words, int[] score, int[] subsetLetters, int totalScore) {
      if (w == -1) {
        // If all words have been iterated, check the score of this subset
        maxScore = Math.max(maxScore, totalScore);
        return;
      }
      // Not adding words[w] to the current subset
      check(w - 1, words, score, subsetLetters, totalScore);
      // Adding words[w] to the current subset
      int L = words[w].length();
      for (int i = 0; i < L; i++) {
        int c = words[w].charAt(i) - 'a';
        subsetLetters[c]++;
        totalScore += score[c];
      }

      if (isValidWord(subsetLetters)) {
        // Consider the next word if this subset is still valid
        check(w - 1, words, score, subsetLetters, totalScore);
      }
      // Rollback effects of this word
      for (int i = 0; i < L; i++) {
        int c = words[w].charAt(i) - 'a';
        subsetLetters[c]--;
        totalScore -= score[c];
      }
    }
  }
}
