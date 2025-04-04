package TP1;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();

    System.out.println();

    list.insertFront(3);
    list.insertFront(1);
    list.insertFront(8);
    list.insertFront(60);
    list.insertFront(5);

    System.out.println("Está vacía? : " + list.isEmpty());

    System.out.println("Tmñ de la lista: " + list.size());
    System.out.println("Que hay en la posicion 2: " + list.get(2));

    System.out.println("Eliminé el primero: " + list.extractFront());

    System.out.println("Tmñ de la lista: " + list.size());
    System.out.println("Donde está el 3: " + list.indexOf(3));

    System.out.println(list);

    MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<>();

    list2.insertFront(3);
    list2.insertFront(90);
    list2.insertFront(2);
    list2.insertFront(8);
    list2.insertFront(1);

    System.out.println(list2);
    MySimpleLinkedList<Integer> listComposed = buildNewList(list, list2);

    System.out.println(listComposed);
    System.out.println("Tmñ " + listComposed.size());

    MySimpleLinkedList<Integer> listComposed2 = buildNewList1ButNotlList2(list, list2);
    System.out.println(listComposed2);
  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> buildNewList(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
    MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

    for (T info : l1) {
      if (l2.indexOf(info) != -1) {
        result.insertOrdered(info);
      }
    }
    return result;
  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> buildNewList1ButNotlList2(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
    MySimpleLinkedList<T> result = new MySimpleLinkedList<>();

    for (T info : l1) {
      if (l2.indexOf(info) == -1) {
        result.insertFront(info);
      }
    }
    return result;
  }
}
