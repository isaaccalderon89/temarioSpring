package modelo.daos;

import java.util.List;

import modelo.beans.Familia;

public interface IntFamilia {
	/*
	 * En los interfaces todos los metodos que hay son publicos y abstractos
	 * es decir, la clase que implementa el interfaces está oblidado a redefinir
	 * los métodos. 
	 */
	Familia finById(int idFamilia);
	List<Familia> findAll();
	int insertarFamilia(Familia familia);
	int modificarFamilia(Familia familia);
	int eliminarFamilia(Familia familia);
	int eliminarFamilia(int  idFamilia);
	 

}
