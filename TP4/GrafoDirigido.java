package TP4;

import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

	private List<Integer> vertices;
	private List<Arco<T>> arcos;

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.contains(verticeId)) {
			this.vertices.add(verticeId);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		boolean existe = existeArco(verticeId1, verticeId2);
		if (!existe) {
			arcos.add(new Arco<>(verticeId1, verticeId2, etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco : arcos) {
			if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				arcos.remove(arco);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		return this.arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
