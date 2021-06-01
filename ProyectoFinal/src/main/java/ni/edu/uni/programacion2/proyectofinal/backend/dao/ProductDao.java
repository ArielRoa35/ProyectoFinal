/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.backend.dao;

import java.io.IOException;
import java.util.Collection;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;

/**
 *
 * @author LENOVO 17
 */
public interface ProductDao extends Dao<Productos>{
    Productos findById(int id) throws IOException;
    Collection<Productos> findByStatus(String status) throws IOException;
    
}
