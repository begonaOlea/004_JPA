
package com.curso.persistencia;

import com.curso.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author begonaolea
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UsuarioService implements GenericJPAInterface<Usuario, Integer>{

    @PersistenceContext(unitName = "CursoPU")
    private EntityManager em;
    
    @Override
    public Usuario crear(Usuario entidad) {
         // tx.begin()
          em.persist(entidad);
          // tx.commit()
          return entidad;
          
    }//fin metodo

    @Override
    public void borrar(Integer clavePrimaria) {
        Usuario uborrar =  em.find(Usuario.class, clavePrimaria);
        if(uborrar != null){
            em.remove(uborrar);
        }else{
            throw new RuntimeException("No se pudo borrar. No existe");
        }
        
    }

    @Override
    public Usuario modificar(Usuario entidad) {
       // MODO 1  -  find  y settters
//        Usuario uModificar =  em.find(Usuario.class, entidad.getId());
//        uModificar.setNombre(entidad.getNombre());
//        uModificar.setCargo(entidad.getCargo());
//        
        //MODO 2  - em.merge
        Usuario uBD = em.merge(entidad);
        //entidad sigue no attached
        //uBD si esta attached

        
        return uBD;
       //commit
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario getByClave(Integer clavePrimaria) {
        
        Usuario usuario = em.find(Usuario.class, clavePrimaria);
        return usuario;
        
    }

    @Override
    public List<Usuario> getAll() {
         
        //SELECT * FORM Usuarios;  /SQL STANDART
        
        Query query = em.createQuery("SELECT u FROM Usuario u"); //JPAQUERY
        
        return query.getResultList();
    
    }

    

    
}
