package Models;

import Exception.ExcDescuento;

//clase interface
public interface Instrumento {
    // metodo polimorfico interface
    public double calcularPrecio();
    public double calcularPrecio(double desc) throws ExcDescuento;
    public String getInstrumento();
    public int getCantidad();
    public double getDesc();
}
