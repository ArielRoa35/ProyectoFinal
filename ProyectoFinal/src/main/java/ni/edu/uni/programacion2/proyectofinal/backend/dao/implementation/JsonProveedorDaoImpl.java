/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.ProveedoresDao;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;

/**
 *
 * @author LENOVO 17
 */
public class JsonProveedorDaoImpl extends RandomTemplate implements ProveedoresDao{
    private File file;
    private final String FILENAME = "ProveedoresJson.dat";
    private final int SIZE = 800;    
    private Gson gson;
    
    
    public JsonProveedorDaoImpl() throws FileNotFoundException {
        super(new File("ProveedoresJson.head"), new File("ProveedoresJson.dat"));        
        gson = new Gson();
        
    }    
    
    @Override
    public Proveedor findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Collection<Proveedor> findByStatus(String status) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(Proveedor p) throws IOException {
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
                
        long posD = k*SIZE;        
        getCustomRandom().getRafD().seek(posD);
        
        getCustomRandom().getRafD().writeInt(++k);
        getCustomRandom().getRafD().writeUTF(gson.toJson(p));
        
        long posH = 8 + (n*8);
        getCustomRandom().getRafH().seek(posH);
        
        getCustomRandom().getRafH().writeInt(k);
        getCustomRandom().getRafH().writeInt(p.getTelefono());
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
        
    }

    @Override
    public int update(Proveedor p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(Proveedor p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Collection<Proveedor> getAll() throws IOException {
        List<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();        
        
        for(int i = 0; i < n; i++){
            long posH = 8 + (i*8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0){
                continue;
            }
            
            long posD = (id - 1)*SIZE;
            getCustomRandom().getRafD().seek(posD);
            proveedor = gson.fromJson(getCustomRandom().getRafD().readUTF(), Proveedor.class);
            
            proveedores.add(proveedor);            
        }
        
        return proveedores;
    }
    
}
