package TP2_1;

public class TreeNode {
  private Integer value;
  private TreeNode left, right;

  public TreeNode(Integer value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public boolean isLeaf() {
    return this.getLeft() == null && this.getRight() == null;
  }

  public boolean hasOneSon() {
    return (this.getLeft() == null && this.getRight() != null) ||
            (this.getLeft() != null && this.getRight() == null);
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}