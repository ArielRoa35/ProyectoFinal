/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.backend.pojo;

/**
 *
 * @author LENOVO 17
 */
public class Productos {
    private String codigo;
    private String nombre;
    private String departamento;
    private String categoria;
    private int disponible;
    private float precio;

    public Productos() {
    }
    
    

    public Productos(String codigo, String nombre, String departamento, String categoria, int disponible, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
        this.categoria = categoria;
        this.disponible = disponible;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public Object[] asArray(){
        Object[] obj = new Object[6];
        
        obj[0] = codigo;
        obj[1] = nombre;
        obj[2] = departamento;
        obj[3] = categoria;
        obj[4] = disponible;
        obj[5] = precio;
        
        return obj;
    }
    
}
