package Exception;

//define excepciones propias
public class ExcDescuento extends Exception {
    public void errorDescuento() {
        System.out.println("El descuento no puede ser mayor al 60% por politicas de la empresa");
    }
}