
package com.curso.persistencia;

import java.util.List;


public interface GenericJPAInterface<E, K> {
    
    public E crear(E entidad);
    public void borrar(K clavePrimaria);
    public E modificar(E entidad);
    public E getByClave(K clavePrimaria);
    public List<E> getAll();
}
