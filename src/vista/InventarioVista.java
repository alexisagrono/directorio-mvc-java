package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    // Muestra el menú y pide una opción al usuario
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Inventario ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Buscar Producto por SKU");
        System.out.println("3. Listar todos los Productos");
        System.out.println("4. Eliminar Producto por SKU");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }
    
    // Pide al usuario los datos para crear un nuevo producto
    public Producto pedirDatosProducto() {
        System.out.println("\n--- Nuevo Producto ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("SKU (Identificador): ");
        String sku = scanner.nextLine();
        
        int cantidad;
        double precio;
        
        // Manejo de errores para Cantidad y Precio
        try {
            System.out.print("Cantidad: ");
            cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio: ");
            precio = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: Cantidad o Precio no son números válidos. Usando valores por defecto (0).");
            cantidad = 0;
            precio = 0.0;
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    // Pide al usuario el SKU para buscar o eliminar
    public String pedirSku() {
        System.out.print("Ingrese el SKU del producto: ");
        return scanner.nextLine();
    }

    // Muestra un producto específico o un mensaje de "no encontrado"
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("\nProducto encontrado: " + producto.toString());
        } else {
            mostrarMensaje("Producto no encontrado.");
        }
    }

    // Muestra la lista completa de productos
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            mostrarMensaje("El inventario está vacío.");
        } else {
            System.out.println("\n--- Inventario Completo ---");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    // Muestra mensajes de éxito o error
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n[INFO] " + mensaje);
    }
}