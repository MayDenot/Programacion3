package TP2_1;

public class Main {
  public static void main(String[] args) {
    Tree arbol1 = new Tree();

    arbol1.insert(42);
    arbol1.insert(28);
    arbol1.insert(62);
    arbol1.insert(59);
    arbol1.insert(71);
    arbol1.insert(57);
    arbol1.insert(31);
    arbol1.insert(30);
    arbol1.insert(21);
    arbol1.insert(55);

    System.out.println("Pre orden:");
    arbol1.printPreOrder();
    System.out.println();
    System.out.println("En orden:");
    arbol1.printInOrder();
    System.out.println();
    System.out.println("Pos orden:");
    arbol1.printPosOrder();
    System.out.println();
    System.out.println("Tiene el elemento 1: " + arbol1.hasElem(1));
    System.out.println("Altura: " + arbol1.getHeight());
    System.out.println("Rama mas larga: " + arbol1.getLongestBranch());
    System.out.println("Raiz: "+ arbol1.getRoot());
    System.out.println("Elemento mas grande: " + arbol1.getMaxElem());
    System.out.println("Nodos en el nivel 1: " + arbol1.getElemAtLevel(1));
    System.out.println("Frontera: " + arbol1.getFrontera());
    System.out.println(arbol1);

    TreeChar arbol2 = new TreeChar();

    arbol2.setValue('M')
    .goLeft()
    .setValue('A')
    .goLeft()
    .setValue('L')
    .goPrev()
    .goRight()
    .setValue('N')
    .goLeft()
    .setValue('A')
    .goPrev()
    .goRight()
    .setValue('O')
    .goRoot()
    .goRight()
    .setValue('I')
    .goRight()
    .setValue('O')
    .goPrev()
    .goLeft()
    .setValue('S')
    .goRight()
    .setValue('A');

    System.out.println(arbol2);
    System.out.println(arbol2.getWords(2));
  }
}
