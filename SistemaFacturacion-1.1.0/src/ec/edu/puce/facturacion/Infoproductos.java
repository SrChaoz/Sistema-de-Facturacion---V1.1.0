package ec.edu.puce.facturacion;

import java.util.ArrayList;
import java.util.List;

public class Infoproductos {
    private List<Producto> listaProductos;

    // Constructor
    public Infoproductos() {
        this.listaProductos = new ArrayList<>();
    }

    // Método para obtener la lista de productos
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    // Método para agregar un producto a la lista
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    // Método para buscar un producto por código
    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    // Método para eliminar un producto por código
    public boolean eliminarProductoPorCodigo(String codigo) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            listaProductos.remove(producto);
            return true;
        }
        return false;
    }

    // Método para actualizar la información de un producto
    public boolean actualizarProducto(Producto productoActualizado) {
        Producto productoExistente = buscarProductoPorCodigo(productoActualizado.getCodigo());
        if (productoExistente != null) {
            int index = listaProductos.indexOf(productoExistente);
            listaProductos.set(index, productoActualizado);
            return true;
        }
        return false;
    }
}