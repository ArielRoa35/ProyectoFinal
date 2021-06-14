package ni.edu.uni.programacion2.proyectofinal.backend.pojo;

import java.util.ArrayList;

public class Proveedor {
 
    private int codigo;
    private String nombre;
    private int telefono;
    private String direccion;
    private ArrayList<Productos> catalogo;

    public Proveedor() {
    }

    public Proveedor(int telefono, int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Proveedor(int codigo, String nombre, int telefono, String direccion, ArrayList<Productos> catalogo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.catalogo = catalogo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Productos> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Productos> catalogo) {
        this.catalogo = catalogo;
    }
    
    public Object[] asArray(){
        Object[] obj = new Object[4];
        
        obj[0] = telefono;
        obj[1] = codigo;
        obj[2] = nombre;
        obj[3] = direccion;
        
        
        return obj;
    }
}
