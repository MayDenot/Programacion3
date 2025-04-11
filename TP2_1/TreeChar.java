package TP2_1;

import java.util.ArrayList;
import java.util.List;

public class TreeChar extends TreeModel<Character> {

  public List<String> getWords(int N) {
    ArrayList<String> result = new ArrayList<>();
    getWords(this.root, N, "", result);
    return result;
  }

  private void getWords(TreeNode<Character> node, int N, String currentWord, ArrayList<String> result) {
    if (node == null) {
      return;
    }

    currentWord += node.getValue();

    int isVowel = 0;
    if (this.isVowel(node.getValue())) {
      isVowel = 1;
    }
    N -= isVowel;

    if (node.isLeaf()) {
      if (N == 0) {
        result.add(currentWord);
      }
    }
    getWords(node.getLeft(), N, currentWord, result);
    getWords(node.getRight(), N, currentWord, result);
  }

  private boolean isVowel(Character ch) {
    return ch.equals('A') || ch.equals('E') || ch.equals('I') || ch.equals('O') || ch.equals('U');
  }
}
