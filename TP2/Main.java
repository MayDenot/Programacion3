package TP2;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Main test = new Main();

    System.out.println("Dado [0,2,1,3,4] está ordenado?");
    int[] arrayIsOrder = {0,2,1,3,4};
    System.out.println(test.isOrder(arrayIsOrder));

    System.out.println("Dado [1,2,3,4,5,6,7,8,9,10] quiero encontrar el nro 3: ");
    int[] arrayOrdered = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(test.searchElemInArrayOrdered(arrayOrdered, 3));

    System.out.println("Conversion decimal a binaria: ");
    System.out.println(test.convertionBinary(26));

    System.out.println("6 terminos de la secuencia Fibonacci: ");
    System.out.println(test.firstNTermsFibonacci(6));

    System.out.println("Dado [-3,1,0,2,4,6,10] el numero que coincide con su posicion (si es que lo hay) es: ");
    int[] array = {-3,1,0,2,4,6,10};
    System.out.println(test.getElemEqualToPosition(array));
  }

  public boolean isOrder(int[] array) {
    return isOrder(array, 0); // O(n)
  }

  private boolean isOrder(int[] array, int i) {
    if (i >= array.length-1) {
      return true;
    }

    if (array[i] > array[i+1]) {
      return false;
    }

    return isOrder(array, i+1);
  }

  public boolean searchElemInArrayOrdered(int[] array, int value) {
    return searchElemInArrayOrdered(value, 0, array);
  }

  private boolean searchElemInArrayOrdered(int value, int i, int[] array) {

    if (i >= array.length || array[i] > value) {
      return false;
    } else {
      return array[i] == value || searchElemInArrayOrdered(value, i+1, array);
    }
  }

  public List<Integer> convertionBinary(int value) {
    return new ArrayList<>(convertionBinary(value, new ArrayList<>()));
  }

  private List<Integer> convertionBinary(int value, ArrayList<Integer> result) {
    int cociente = value / 2;
    int resto = value % 2;

    if (cociente > 0) {
      result.addFirst(resto);
      convertionBinary(cociente, result);
    }
    if (cociente == 1) {
      result.addFirst(cociente);
    }
    return result;
  }

  public List<Integer> firstNTermsFibonacci(int N) {
    return firstNTermsFibonacci(0, 1, 1, 0, N, new ArrayList<>());
  }

  private List<Integer> firstNTermsFibonacci(int beforeTerm, int currentTerm, int sum,  int counter, int N, List<Integer> result) {
    if (counter < N) {
      result.add(beforeTerm);
      beforeTerm = currentTerm;
      currentTerm = sum;
      sum = beforeTerm + currentTerm;
      firstNTermsFibonacci(beforeTerm, currentTerm, sum, counter + 1, N, result);
    }
    return result;
  }

  public Integer getElemEqualToPosition(int[] array) {
    return getElemEqualToPosition(0, array.length, array, 0);
  }

  private Integer getElemEqualToPosition(int i, int n, int[] array, Integer elem) {
    if (n == 0) {
      return null;
    }
    if (array[i] != i) {
      elem = getElemEqualToPosition(i+1, n, array, array[i+1]);
    }
    return elem;
  }
}
