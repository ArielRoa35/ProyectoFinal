package ni.edu.uni.programacion2.proyectofinal.backend.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int codigo;
    private Date fecha;
    private ArrayList<Productos> productos;
    private float total;
    private float pago;
    private float vuelto;

    public Factura() {
    }

    public Factura(int codigo, Date fecha, ArrayList<Productos> productos, float total, float pago, float vuelto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
        this.pago = pago;
        this.vuelto = vuelto;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public float getVuelto() {
        return vuelto;
    }

    public void setVuelto(float vuelto) {
        this.vuelto = vuelto;
    }
    
    
}
