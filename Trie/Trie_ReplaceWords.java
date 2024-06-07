import java.util.List;

public class Trie_ReplaceWords {
  class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
      children = new TrieNode[26];
      isEnd = false;
    }

  }

  class Trie {

    TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode curr = root;

      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }

        curr = curr.children[c - 'a'];
      }

      curr.isEnd = true;
    }

    public String shortestRoot(String word) {
      TrieNode curr = root;

      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (curr.children[c - 'a'] == null) {
          return word;
        }

        curr = curr.children[c - 'a'];

        if (curr.isEnd) {
          return word.substring(0, i + 1);
        }
      }

      return word;
    }
  }

  class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

      String[] wordArr = sentence.split(" ");
      Trie dict = new Trie();

      for (String root : dictionary) {
        dict.insert(root);
      }

      for (int i = 0; i < wordArr.length; i++) {
        wordArr[i] = dict.shortestRoot(wordArr[i]);
      }

      return String.join(" ", wordArr);
    }

  }
}
