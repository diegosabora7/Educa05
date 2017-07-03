/*
@(#)CapacitacionFacade.java     1.0 02/07/2017
*
*Copyright 2017 Grupo_05 All rights reserved.
*Grupo_05 Propietary. Use is subject to license terms
*/
/**
 *Clase CapacitacionFacade generada a partir de la clase de entidad Capacitacion
 */
package ec.edu.espe.educat.dao;

import ec.edu.espe.edu.educat.model.Capacitacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @version 1.0
 * @author Jefferson Tambaco
 */
@Stateless
public class CapacitacionFacade extends AbstractFacade<Capacitacion> implements CapacitacionFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_EducaT05-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacitacionFacade() {
        super(Capacitacion.class);
    }
    
}
