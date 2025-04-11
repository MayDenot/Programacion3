package TP2_1;

public class TreeNode<T> {
  private T value;
  private TreeNode<T> left, right;

  public TreeNode(T value) {
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

  public TreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  public TreeNode<T> getRight() {
    return right;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}