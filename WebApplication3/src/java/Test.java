
import entities.Service;
import services.ServiceService;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Test {
    
    
    
      public static void main(String[] args) {
          
          
         HibernateUtil.getSessionFactory().openSession() ;
        ServiceService ss = new ServiceService();
        
        ss.create(new Service("I", "Inf"));
        ss.create(new Service("A", "Ar"));
    
}
}