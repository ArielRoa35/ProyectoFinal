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
import ni.edu.uni.programacion2.proyectofinal.backend.dao.ProductDao;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;

/**
 *
 * @author LENOVO 17
 */
public class JsonProdDaoImpl extends RandomTemplate implements ProductDao{        
    private final int SIZE = 800;    
    private Gson gson;    
    
    public JsonProdDaoImpl() throws FileNotFoundException {
        super(new File("ProductosJson.head"), new File("ProductosJson.dat"));        
        gson = new Gson();
        
    }    
    
    @Override
    public Productos findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Productos> findByStatus(String status) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Productos p) throws IOException {
        
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
        getCustomRandom().getRafH().writeInt(p.getCodigo());
        
        getCustomRandom().getRafH().seek(0);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
        
    }

    @Override
    public int update(Productos p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Productos p) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Productos> getAll() throws IOException {
        List<Productos> prod = new ArrayList<>();
        Productos p = null;
        
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();        
        
        for(int i = 0; i < n; i++){
            long posH = 8 + (i*8);
            getCustomRandom().getRafH().seek(posH);
            
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0){
                continue;
            }
            
            long posD = 4 + (id - 1)*SIZE;
            getCustomRandom().getRafD().seek(posD);
            p = gson.fromJson(getCustomRandom().getRafD().readUTF(), Productos.class);
            
            prod.add(p);            
        }
        
        return prod;
    }
    
}
