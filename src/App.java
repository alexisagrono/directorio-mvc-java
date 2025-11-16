import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

public class App {
    public static void main(String[] args) {
        // 1. Instanciar el Modelo (Datos)
        BaseDeDatos modelo = new BaseDeDatos();

        // 2. Instanciar la Vista (UI/Consola)
        InventarioVista vista = new InventarioVista();

        // 3. Instanciar el Controlador (Lógica de Negocio, conecta M y V)
        ControladorInventario controlador = new ControladorInventario(modelo, vista);

        // Iniciar la aplicación
        controlador.iniciar();
    }
}