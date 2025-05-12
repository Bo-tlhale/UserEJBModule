/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.za.tut.bl;

import ac.za.tut.entities.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class TaskFacade extends AbstractFacade<Task> implements TaskFacadeLocal {

    @PersistenceContext(unitName = "UserEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TaskFacade() {
        super(Task.class);
    }
    
     @Override
    public Task getTask(String title) {
       String query="SELECT t FROM Tak t WHERE t.title = ?1";
         Query qr=em.createQuery(query);
         qr.setParameter(1, title.toLowerCase());
         Task tk=(Task)qr.getSingleResult();
         
         return tk;
    }

    @Override
    public List<Task> getTasks() {
        String query="SELECT t FROM Task t ";
         Query qr=em.createQuery(query);
         
         List<Task> ls=qr.getResultList();
         
         return ls; 
    }
    
    
}
