package Exception;

public class ExcCantidad extends Exception {
    public void errorCantidad() {
        System.out.println("Error en la cantidad seleccionada, no puede ser negativo o cero");
    }
}
