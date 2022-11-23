package com.ite.productos.modelo.repository;

import java.util.List;

import com.ite.productos.modelo.beans.Producto;





public interface IntProductos {
	
	List<Producto>  findAll();
	List<Producto>  novedades();
	int altaProducto(Producto producto);
	int borrarProducto(Producto producto);
	int borrarProducto(int idProducto);
	int modificarProducto(Producto producto);
	Producto findById(int idProducto);

}
