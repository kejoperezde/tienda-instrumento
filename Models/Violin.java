package Models;

import Exception.ExcDescuento;

//herencia e implementos
public class Violin extends DatosInstrumento implements Instrumento {
     private String tipo;
    private String tamaño;

    // sobreecarga de constructores
    public Violin(double precio, int cantidad, String marca, boolean aditamentos,double desc, String tipo, String tamaño) {
        super(precio, cantidad, marca, aditamentos, desc);
        this.tipo = tipo;
        this.tamaño = tamaño;
    }

    public Violin(double precio, int cantidad, String marca,double desc, String tipo, String tamaño) {
        super(precio, cantidad, marca,desc);
        this.tipo = tipo;
        this.tamaño = tamaño;
    }

    @Override
    public double calcularPrecio() {
        double total;
        total = (getPrecio() * getCantidad());
        return total;
    }

    // sobrecarga de metodo, polimorfimsmo, herencia polimorfica
    @Override
    public double calcularPrecio(double desc) throws ExcDescuento {
        double total;
        if (desc > .6) {
            // usar excepciones propias
            ExcDescuento e = new ExcDescuento();
            e.errorDescuento();
            desc = .6;
        }
        total = (getPrecio() * getCantidad()) - (getPrecio() * getCantidad() * desc);
        return total;
    }

    // redefinicion de metodos
    @Override
    public double getPrecio() {
        double precio = super.getPrecio();
        if (super.getAditamentos() == true) {
            precio = precio + (precio * .3);
        }
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String getInstrumento() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getInstrumento());
        sb.append("Violin{");
        sb.append("tipo=").append(tipo);
        sb.append(", tama\u00f1o=").append(tamaño);
        sb.append('}');
        return sb.toString();
    }

}
