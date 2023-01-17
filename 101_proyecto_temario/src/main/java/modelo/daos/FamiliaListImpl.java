package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Familia;

public class FamiliaListImpl implements IntFamilia{
	/*
	 * En los interfaces todos los metodos que hay son publicos y abstractos
	 * es decir, la clase que implementa el interfaces está oblidado a redefinir
	 * los métodos.
	 * 
	 *  Esta clase va a implementar todos los metodos del interface IntFamilia
	 *  
	 */
	
	private List<Familia> lista;
	
	public FamiliaListImpl() {
		/*
		 * Aqui creamos una lista que lo que haces es llamar al método privado.
		 */
		lista = new ArrayList<Familia>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		/*
		 * Tenemos un metodo privado que lo que hace es añadir 5 familias
		 */
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
		
		return lista;
	}

	@Override
	public int insertarFamilia(Familia familia) {
		/*
		 * Este método quiere decir:
		 * Si la lista contiene esta familia, entonces retorna 0;
		 * Y si no hacemos esto, añades a la familia y retornas un 1 y si hay 
		 * algun problema retornas un 0.
		 */
		if (lista.contains(familia))
			return 0;
		else
			return lista.add(familia)?1:0;
	}

	@Override
	public int modificarFamilia(Familia familia) {
		/*
		 * Usamos el mismo método que en eliminar para localizar la posicion 
		 * de la familia
		 */
		int pos = lista.indexOf(familia);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, familia) != null)?1:0;
	}
	

	@Override
	public int eliminarFamilia(Familia familia) {
		/*
		 * Este método quiere decir:
		 * Que si encuentra la familia la elimine 
		 * retorna un 1 si ha encontrado y eliminado 
		 * retorna un 0 si no lo ha encontrado. 
		 * 
		 */
		return lista.remove(familia)?1:0;
	}

	@Override
	public int eliminarFamilia(int idFamilia) {
		/*
		 * En este caso el metodo pide un numero para eliminar
		 * una familia.
		 * Creamos una familia llamada 'aux' Familia aux = new Familia();
		 * PAra que el array busque por el idFamilia aux.setIdFamilia(idFamilia);
		 * Creamos una variable que nos indique la posicion con el metodos indexOf()
		 * que nos indica en que posición se encuentra. 
		 * Si la posicion es identica a -1 quiere decir que no lo ha encontrado 
		 * por lo tanto retorna 0.
		 * y si el objeto encontrado y eliminado es distinto de null retorna 1 para indicar
		 * que la operacion está realizada, en caso contrario encuentra un 0. 
		 */
		Familia aux = new Familia();
		aux.setIdFamilia(idFamilia);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos) !=null)?1:0;
	}
	
	

}
