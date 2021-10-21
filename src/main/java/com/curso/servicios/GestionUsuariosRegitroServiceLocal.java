/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.curso.servicios;

import com.curso.entidades.Usuario;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author begonaolea
 */
@Local
public interface GestionUsuariosRegitroServiceLocal {
    
    public void asignarCargo(Set<Usuario> usuarios, String nuevoCargo);
    
    public void crearUsuario(Usuario usuario);
    
    public List<Usuario> getUsuarios();
    
}
