/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Employe;
import entities.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Lenovo
 */
public class EmployeService extends AbstractFacade<Employe> {
    
  
     @Override
    protected Class<Employe> getEntityClass() {
        return Employe.class ; //To change body of generated methods, choose Tools | Templates.
    }
    
  

    public static Iterable<Object[]> nbEmployeByChef() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Object[]> nbemploye(){
        List<Object[]> employes = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employes  = session.createQuery("select count(m.marque), m.marque from Employe m group by m.marque").list();
        session.getTransaction().commit();
        return employes;
    }
    
     public List<Employe> employessByService(Service service) {
        ServiceService ss = new ServiceService();
         int serviceId = ss.getById(service.getId()).getId();
        String hql = "FROM Employe e WHERE e.service.id = :serviceId";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employe> employeesOfService = session.createQuery(hql)
                .setParameter("serviceId", serviceId)
                .list();
        
        return employeesOfService;
    }


    
    
}
