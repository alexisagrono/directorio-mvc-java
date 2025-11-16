package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

public class ControladorInventario {
    private BaseDeDatos modelo;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Cargar algunos datos iniciales para la prueba
        modelo.agregarProducto(new Producto("Laptop", "LP001", 10, 1200.00));
        modelo.agregarProducto(new Producto("Mouse", "MS002", 50, 25.00));
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: // Agregar
                    agregarProducto();
                    break;
                case 2: // Buscar
                    buscarProducto();
                    break;
                case 3: // Listar
                    listarProductos();
                    break;
                case 4: // Eliminar
                    eliminarProducto();
                    break;
                case 5: // Salir
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    private void agregarProducto() {
        try {
            Producto nuevoProducto = vista.pedirDatosProducto();
            if (modelo.buscarProductoSku(nuevoProducto.getSku()) == null) {
                modelo.agregarProducto(nuevoProducto);
                vista.mostrarMensaje("Producto agregado exitosamente.");
            } else {
                vista.mostrarMensaje("Error: El SKU ya existe.");
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error en la entrada de datos. Por favor, revise.");
        }
    }

    private void buscarProducto() {
        String sku = vista.pedirSku();
        Producto producto = modelo.buscarProductoSku(sku);
        vista.mostrarProducto(producto);
    }

    private void listarProductos() {
        vista.mostrarProductos(modelo.buscarTodos());
    }

    private void eliminarProducto() {
        String sku = vista.pedirSku();
        if (modelo.eliminarProducto(sku)) {
            vista.mostrarMensaje("Producto eliminado exitosamente.");
        } else {
            vista.mostrarMensaje("Error: No se encontró el SKU para eliminar.");
        }
    }
}