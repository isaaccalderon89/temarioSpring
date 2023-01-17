package modelo.daos;

import java.util.List;

import modelo.beans.Producto;



public interface IntProductos {
	
	List<Producto>  findAll();
	List<Producto>  novedades();
	int altaProducto(Producto producto);
	int borrarProducto(Producto producto);
	int modificarProducto(Producto producto);
	Producto findById(int idProducto);

}
