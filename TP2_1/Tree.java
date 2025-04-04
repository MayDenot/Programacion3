package TP2_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    TreeNode root;

    public Tree() {
      this.root = null;
    }

    public Integer getRoot() {
      return this.root.getValue(); // O(1)
    }

    public boolean hasElem(Integer value) {
      return hasElem(root, value); // O(n)
    }

    private boolean hasElem(TreeNode node, Integer value) {
      if (node == null) {
        return false;
      }
      if (node.getValue().equals(value)) {
        return true;
      }

      return hasElem(node.getLeft(), value) || hasElem(node.getRight(), value);
    }

    public boolean isEmpty() {
      return this.root == null; // O(1)
    }

    public void insert(Integer value) { // O((log2 n) . n)
      if (this.isEmpty()) {
        this.root = new TreeNode(value);
      } else {
        this.add(this.root, value);
      }
    }

    private void add(TreeNode current, Integer value) {
      if (current.getValue() > value) {
        if (current.getLeft() == null) {
          TreeNode tmp = new TreeNode(value);
          current.setLeft(tmp);
        } else {
          add(current.getLeft(), value);
        }
      } else if (current.getValue() < value) {
        if (current.getRight() == null) {
          TreeNode tmp = new TreeNode(value);
          current.setRight(tmp);
        } else {
          add(current.getRight(), value);
        }
      }
    }

    public boolean delete(Integer value) {
      if (this.isEmpty() || !hasElem(value)) { //
        return false;
      }

      this.root = deleteNode(this.root, value);
      return true;
    }

    private TreeNode deleteNode(TreeNode node, Integer value) {
      if (node == null) {
        return null;
      }

      if (value < node.getValue()) {
        node.setLeft(deleteNode(node.getLeft(), value));
      } else if (value > node.getValue()) {
        node.setRight(deleteNode(node.getRight(), value));
      } else {
        if (node.isLeaf()) {
          return null;
        } else if (node.hasOneSon()) {
          return node.getLeft() != null ? node.getLeft() : node.getRight();
        } else {
          TreeNode successor = findMin(node.getRight());
          node.setValue(successor.getValue());
          node.setRight(deleteNode(node.getRight(), successor.getValue()));
        }
      }
      return node;
    }

    private TreeNode findMin(TreeNode node) {
      while (node.getLeft() != null) {
        node = node.getLeft();
      }
      return node;
    }

    public int getHeight() {
      return getHeightRecursive(this.root); // O(n)
    }

    private int getHeightRecursive(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int highLeft = getHeightRecursive(node.getLeft());
      int highRight = getHeightRecursive(node.getRight());

      return Math.max(highLeft, highRight) + 1;
    }

    public void printPosOrder() {
      posOrder(this.root); // O(n)
    }

    private void posOrder(TreeNode node) {
      if (node == null) {
        return;
      }
      posOrder(node.getLeft());
      posOrder(node.getRight());
      System.out.println(node.getValue() + " ");
    }

    public void printPreOrder() {
      preOrder(this.root); // O(n)
    }

    private void preOrder(TreeNode node) {
      if (node == null) {
        return;
      }
      System.out.println(node.getValue() + " ");
      preOrder(node.getLeft());
      preOrder(node.getRight());
    }

    public void printInOrder() {
      inOrder(this.root); // O(n)
    }

    private void inOrder(TreeNode node) {
      if (node == null) {
        return;
      }
      inOrder(node.getLeft());
      System.out.println(node.getValue() + " ");
      inOrder(node.getRight());
    }

    public List<Integer> getLongestBranch() {
      return getLongestBranch(this.root); // O(n)
    }

    private List<Integer> getLongestBranch(TreeNode node) {
      if (node == null) {
        return new ArrayList<Integer>();
      }

      List<Integer> leftSide = getLongestBranch(node.getLeft());
      List<Integer> rightSide = getLongestBranch(node.getRight());

      if (leftSide.size() > rightSide.size()) {
        leftSide.addFirst(node.getValue());
        return leftSide;
      } else {
        rightSide.addFirst(node.getValue());
        return rightSide;
      }
    }

    public List<Integer> getFrontera() {
      return getFrontera(this.root, new ArrayList<Integer>());
    }

    private List<Integer> getFrontera(TreeNode node, ArrayList<Integer> result) {
      if (node == null) {
        return result;
      }

      if (node.isLeaf()) {
        result.add(node.getValue());
      } else {
        getFrontera(node.getLeft(), result);
        getFrontera(node.getRight(), result);
      }
      return result;
    }

    public Integer getMaxElem() {
      return getMaxElem(this.root); // O(n)
    }

    private Integer getMaxElem(TreeNode node) {
      if (node == null) {
        return null;
      }

      Integer max = node.getValue();
      Integer leftMax = getMaxElem(node.getLeft());
      Integer rightMax = getMaxElem(node.getRight());

      if (leftMax != null) {
        max = Math.max(max, leftMax);
      }
      if (rightMax != null) {
        max = Math.max(max, rightMax);
      }
      return max;
    }

    public List<Integer> getElemAtLevel(int level) {
      return new ArrayList<>(getElemAtLevel(this.root, level, 0)); // O(n)
    }

    private List<Integer> getElemAtLevel(TreeNode node, int level, int currentLevel) {
      List<Integer> result = new ArrayList<>();

      if (level > this.getHeight() || node == null) {
        return result;
      }

      if (level == currentLevel) {
        result.add(node.getValue());
      } else {
        result.addAll(getElemAtLevel(node.getLeft(), level, currentLevel + 1));
        result.addAll(getElemAtLevel(node.getRight(), level, currentLevel + 1));
      }
      return result;
    }

    public int getSumNodesInt() {
      return getSumNodesInt(this.root);
    }

    private int getSumNodesInt(TreeNode node) {
      if (node == null || node.isLeaf()) {
        return 0;
      }

      return getSumNodesInt(node.getLeft()) + getSumNodesInt(node.getRight()) + node.getValue();
    }

    public List<Integer> getLeafsGreaterThan(int K) {
      return new ArrayList<>(getLeafsGreaterThan(this.root, K));
    }

    private List<Integer> getLeafsGreaterThan(TreeNode node, int K) {
      List<Integer> result = new ArrayList<Integer>();

      if (node == null) {
        return result;
      }

      if (node.isLeaf() && node.getValue() > K) {
        result.add(node.getValue());
        return result;
      }

      result.addAll(getLeafsGreaterThan(node.getLeft(), K));
      result.addAll(getLeafsGreaterThan(node.getRight(), K));

      return result;
    }

    public void calculateInternalNodes() {
      calculateInternalNodes(this.root);
    }

    private int calculateInternalNodes(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int rightValue = calculateInternalNodes(node.getRight());
      int leftValue = calculateInternalNodes(node.getLeft());

      if (node.isLeaf()) {
        return node.getValue();
      }
      int nodeValue = rightValue - leftValue;
      node.setValue(nodeValue);
      return nodeValue;
    }

    public List<String> searchWordsWithNVowels(int N) {
      ArrayList<String> result = new ArrayList<>();
      searchWordsWithNVowels(this.root, N, 0, " ", result);
      return result;
    }

    private List<String> searchWordsWithNVowels(TreeNode node, int N, int counter, String currentWord, ArrayList<String> result) {
      if (node == null) {
        return null;
      }

      // Guardo la raiz
      // Busco las ramas
      // Una vez que llegue a una hoja,
      // Armo la palabra
      // Cuento cuantas vocales tiene
      // Si la cant de vocales q tiene es igual a N
        // La guardo en result
      return null;
    }
}