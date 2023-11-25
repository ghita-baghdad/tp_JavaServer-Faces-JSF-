/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import entities.Service;


/**
 *
 * @author Lenovo
 */
public class ServiceService extends AbstractFacade<Service>{

    @Override
    protected Class<Service> getEntityClass() {
       return Service.class ; //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
