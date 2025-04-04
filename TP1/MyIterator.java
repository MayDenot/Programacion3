package TP1;

import java.util.Iterator;

public class MyIterator<T extends Comparable<T>> implements Iterator<T> {
  private Node<T> cursor;

  public MyIterator(Node<T> cursor) {
    this.cursor = cursor;
  }

  @Override
  public boolean hasNext() {
    return cursor != null;
  }

  @Override
  public T next() {
    T info = this.cursor.getInfo();
    this.cursor = cursor.getNext();
    return info;
  }
}
