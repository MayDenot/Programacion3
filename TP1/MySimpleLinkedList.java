package TP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
	
	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null); //Instancio un nodo temporal con la info pasada por el usuario y apunta inicialmente a null
		tmp.setNext(this.first); // A ese nodo creado, le indico que el siguiente nodo será el primero
		this.first = tmp; // tmp se convierte en el primer nodo de la lista
		this.size++; // Aumento el tmñ de la lista
	}

	public void insertOrdered(T info) {
		Node<T> newNode = new Node<T>(info, null);

		if (this.first == null || info.compareTo(this.first.getInfo()) >= 0) {
			// Si la lista está vacía o el nuevo elemento es menor que el primero
			newNode.setNext(this.first);
			this.first = newNode;
		} else {
			Node<T> current = this.first;
			Node<T> tmp = null;

			while (current != null && current.getInfo().compareTo(info) < 0) {
				tmp = current;
				current = current.getNext();
			}

			newNode.setNext(current);
      if (tmp != null) {
        tmp.setNext(newNode);
      }
    }
		this.size++;
	}

	public T extractFront() {		
		Node<T> tmp = this.first; //Guardo referencia del primer modo
		if (!this.isEmpty()) {
			this.first = this.first.getNext(); //Actualizo first al siguiente nodo
			this.size--; //Actualizo el tamaño
			return tmp.getInfo(); //Devuelvo el valor del nodo que se ha extraido
		}
		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int indexOf(T info) {
		Node<T> aux = this.first;
		for (int i = 0; i < this.size(); i++) {
			if (aux.getInfo().equals(info)) {
				return i;
			}
			aux = aux.getNext();
		}
		return -1;
	}

	public T get(int index) {
		Node<T> actual = this.first;
		for (int i = 0; i < index; i++) {
			actual = actual.getNext();
		}
		return actual.getInfo();
	}

	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<T> current = this.first;

		while (current != null) {
			result.append(current.getInfo());
			if (current.getNext() != null) {
				result.append(" -> ");
			}
			current = current.getNext();
		}
		result.append("]");
		return result.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}
}