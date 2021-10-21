/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.curso.servicios;

import com.curso.entidades.Usuario;
import com.curso.persistencia.GenericJPAInterface;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author begonaolea
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionUsuariosRegitroService implements GestionUsuariosRegitroServiceLocal {
    
    @EJB
    private GenericJPAInterface<Usuario,Integer> usuarioDAO;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void asignarCargo(Set<Usuario> usuarios, String nuevoCargo) {
        //TX.BEGIN
        
        for(Usuario u: usuarios){
            u.setCargo(nuevoCargo);
            usuarioDAO.modificar(u);
 
        }
    
        //TX.COMMIT
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioDAO.crear(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
       return usuarioDAO.getAll();
    
    }

    
    
   
}
