package com.curso.web;

import com.curso.entidades.Usuario;
import com.curso.servicios.GestionUsuariosRegitroServiceLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "usuariosManagedBean")
@RequestScoped
public class UsuariosManagedBean {

    //servicios
    @EJB
    private GestionUsuariosRegitroServiceLocal servicio;
    
    //atributos
    private Usuario usuario;  // alta formulario
    private List<Usuario> listaUsuarios;
   
    
    public UsuariosManagedBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        this.listaUsuarios  = servicio.getUsuarios();
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    public String btnGrabarUsuario(){
        servicio.crearUsuario(usuario);
        System.out.println("... grabó ok");
        return null;
    }
    
    
}
