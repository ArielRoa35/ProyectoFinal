package ni.edu.uni.programacion2.proyectofinal.backend.pojo;

import java.util.ArrayList;

public class Proveedor {
 
    private int codigo;
    private String nombre;
    private String telefono;
    private String direccion;
    private ArrayList<Productos> catalogo;

    public Proveedor() {
    }

    public Proveedor(int codigo, String nombre, String telefono, String direccion, ArrayList<Productos> catalogo) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
}
