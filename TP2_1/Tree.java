package TP2_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    TreeNode<Integer> root;

    public Tree() {
      this.root = null;
    }

    public Integer getRoot() {
      return this.root.getValue(); // O(1)
    }

    public boolean hasElem(Integer value) {
      return hasElem(root, value); // O(n)
    }

    private boolean hasElem(TreeNode<Integer> node, Integer value) {
      if (node == null) {
        return false;
      }
      if (node.getValue().equals(value)) {
        return true;
      } else if (node.getValue() > value) {
        return hasElem(node.getLeft(), value);
      } else {
        return hasElem(node.getRight(), value);
      }
    }

    public boolean isEmpty() {
      return this.root == null; // O(1)
    }

    public void insert(Integer value) { // O((log2 n) . n)
      if (this.isEmpty()) {
        this.root = new TreeNode<Integer>(value);
      } else {
        this.insert(this.root, value);
      }
    }

    private void insert(TreeNode<Integer> current, Integer value) {
      if (current.getValue() > value) {
        if (current.getLeft() == null) {
          TreeNode<Integer> tmp = new TreeNode<Integer>(value);
          current.setLeft(tmp);
        } else {
          insert(current.getLeft(), value);
        }
      } else if (current.getValue() < value) {
        if (current.getRight() == null) {
          TreeNode<Integer> tmp = new TreeNode<Integer>(value);
          current.setRight(tmp);
        } else {
          insert(current.getRight(), value);
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

    private TreeNode<Integer> deleteNode(TreeNode<Integer> node, Integer value) {
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
          TreeNode<Integer> successor = findMin(node.getRight());
          node.setValue(successor.getValue());
          node.setRight(deleteNode(node.getRight(), successor.getValue()));
        }
      }
      return node;
    }

    private TreeNode<Integer> findMin(TreeNode<Integer> node) {
      while (node.getLeft() != null) {
        node = node.getLeft();
      }
      return node;
    }

    public int getHeight() {
      return getHeightRecursive(this.root); // O(n)
    }

    private int getHeightRecursive(TreeNode<Integer> node) {
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

    private void posOrder(TreeNode<Integer> node) {
      if (node == null) {
        return;
      }
      posOrder(node.getLeft());
      posOrder(node.getRight());
      System.out.print(node.getValue() + ", ");
    }

    public void printPreOrder() {
      preOrder(this.root); // O(n)
    }

    private void preOrder(TreeNode<Integer> node) {
      if (node == null) {
        return;
      }
      System.out.print(node.getValue() + ", ");
      preOrder(node.getLeft());
      preOrder(node.getRight());
    }

    public void printInOrder() {
      inOrder(this.root); // O(n)
    }

    private void inOrder(TreeNode<Integer> node) {
      if (node == null) {
        return;
      }
      inOrder(node.getLeft());
      System.out.print(node.getValue() + ", ");
      inOrder(node.getRight());
    }

    public List<Integer> getLongestBranch() {
      return getLongestBranch(this.root); // O(n)
    }

    private List<Integer> getLongestBranch(TreeNode<Integer> node) {
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

    private List<Integer> getFrontera(TreeNode<Integer> node, ArrayList<Integer> result) {
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

    private Integer getMaxElem(TreeNode<Integer> node) {
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

    private List<Integer> getElemAtLevel(TreeNode<Integer> node, int level, int currentLevel) {
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

    private int getSumNodesInt(TreeNode<Integer> node) {
      if (node == null || node.isLeaf()) {
        return 0;
      }

      return getSumNodesInt(node.getLeft()) + getSumNodesInt(node.getRight()) + node.getValue();
    }

    public List<Integer> getLeafsGreaterThan(int K) {
      return new ArrayList<>(getLeafsGreaterThan(this.root, K));
    }

    private List<Integer> getLeafsGreaterThan(TreeNode<Integer> node, int K) {
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

    private int calculateInternalNodes(TreeNode<Integer> node) {
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

    @Override
    public String toString() {
      if (root == null)
        return "Árbol vacío";
      return buildTree(root, "", false);
    }

    private String buildTree(TreeNode<Integer> node, String prefix, boolean isTail) {
      if (node == null) {
        return "";
      }

      StringBuilder builder = new StringBuilder();

      if (node.getRight() != null) {
        builder.append(buildTree(node.getRight(), prefix + (isTail ? "│   " : "    "), false));
      }

      builder.append(prefix).append(isTail ? "└── " : "┌── ").append(node.getValue()).append("\n");

      if (node.getLeft() != null) {
        builder.append(buildTree(node.getLeft(), prefix + (isTail ? "    " : "│   "), true));
      }

      return builder.toString();
    }
}