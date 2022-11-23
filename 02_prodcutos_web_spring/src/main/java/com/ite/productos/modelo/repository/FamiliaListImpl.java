package com.ite.productos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import com.ite.productos.modelo.beans.Familia;



public class FamiliaListImpl implements IntFamilia{
	
	private List<Familia> lista;
	
	public FamiliaListImpl() {
		lista = new ArrayList<Familia>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		lista.add(new Familia(1, "Camisa"));
		lista.add(new Familia(2, "Pantalon"));
		lista.add(new Familia(3, "Jersey"));
		lista.add(new Familia(4, "Polo"));
		lista.add(new Familia(5, "Camiseta"));
		
	}

	@Override
	public Familia finById(int idFamilia) {
		Familia aux = new Familia();
		aux.setIdFamilia(idFamilia);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public List<Familia> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public int insertarFamilia(Familia familia) {
		if (lista.contains(familia))
			return 0;
		else
			return lista.add(familia)?1:0;
	}

	@Override
	public int modificarFamilia(Familia familia) {
		int pos = lista.indexOf(familia);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, familia) != null)?1:0;
	}
	

	@Override
	public int eliminarFamilia(Familia familia) {
		// TODO Auto-generated method stub
		return lista.remove(familia)?1:0;
	}

	@Override
	public int eliminarFamilia(int idFamilia) {
		Familia aux = new Familia();
		aux.setIdFamilia(idFamilia);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos) !=null)?1:0;
	}
	
	

}
