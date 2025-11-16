package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDeDatos {
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Producto buscarProductoSku(String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(this.productos);
    }

    public boolean eliminarProducto(String sku) {
        Iterator<Producto> iterator = this.productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getSku().equalsIgnoreCase(sku)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
