/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Lenovo
 * @param <T>
 */
public abstract class AbstractFacade<T>{
    
    
    protected abstract Class<T> getEntityClass() ;
    
    private String getEntityClassName() {
    
    return getEntityClass().getSimpleName() ;
    
    }
    
  
    public boolean create(T o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

 
    public boolean update(T o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

 
    public boolean delete(T o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

   
    public T getById(int id) {
        T service  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        service  = (T) session.get(getEntityClass(), id);
        session.getTransaction().commit();
        return service;
    }

  
    public List<T> getAll() {
        List <T> entities = null; 
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        entities  = session.createQuery("from " +getEntityClassName()).list();
        session.getTransaction().commit();
        return entities;
    }
    
    
    
    
    
    
    
    
  
    
    
}
