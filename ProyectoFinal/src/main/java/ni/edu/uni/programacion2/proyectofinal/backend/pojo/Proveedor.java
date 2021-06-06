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
public class Proveedor {
    private String ruc,proveedor,direc;
    private int servicio;

    public Proveedor() {
    }

    public Proveedor(int servicio, String proveedor, String direc, String ruc) {
        this.ruc = ruc;
        this.proveedor = proveedor;
        this.direc = direc;
        this.servicio = servicio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
    
    public Object[] asArray(){
        Object[] obj = new Object[6];
        
        obj[0] = proveedor;
        obj[1] = direc;
        obj[2] = ruc;
        obj[3] = servicio;
        return obj;
    }
}
