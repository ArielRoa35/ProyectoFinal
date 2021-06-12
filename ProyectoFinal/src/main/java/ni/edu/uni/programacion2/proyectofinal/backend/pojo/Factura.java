package ni.edu.uni.programacion2.proyectofinal.backend.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int codigo;
    private Date fecha;
    private ArrayList<Productos> productos;
    private float subTotal;
    private float total;

    public Factura() {
    }

    public Factura(int codigo, Date fecha, ArrayList<Productos> productos, float subTotal, float total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.productos = productos;
        this.subTotal = subTotal;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
