package Models;

import java.io.Serializable;

//abstraccion
public abstract class DatosInstrumento implements Serializable {
    //encapsulamiento
    private double precio;
    private int cantidad;
    private String marca;
    private boolean aditamentos;
    private double desc;

    public DatosInstrumento(double precio, int cantidad, String marca, boolean aditamentos,double desc) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.marca = marca;
        this.aditamentos = aditamentos;
        this.desc = desc;
    }

    public DatosInstrumento(double precio, int cantidad, String marca, double desc) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.marca = marca;
        this.aditamentos=false;
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean getAditamentos() {
        return aditamentos;
    }

    public void setAditamentos(boolean aditamentos) {
        this.aditamentos = aditamentos;
    }

    public double getDesc() {
        return this.desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }
    
    
    public String getInstrumento() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instrumento{");
        sb.append("Precio=").append(getPrecio());
        sb.append(", Cantidad=").append(getCantidad());
        sb.append(", Marca=").append(getMarca());
        sb.append(", Aditamentos=").append(getAditamentos());
        sb.append('}');
        return sb.toString();
    }
}
