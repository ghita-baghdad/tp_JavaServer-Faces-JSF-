/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Employe;
import entities.Service;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import services.EmployeService;
import services.ServiceService;



@ManagedBean(name = "serviceBean")

public class ServiceBean {
    
    private Service service;
    private ServiceService serviceService ;
    private List<Service> services;
    private Employe employe ;
    private EmployeService employeService ;
    private List<Employe>  employes ;
      private static ChartModel barModel;

    /**
     * Creates a new instance of ServiceBean
     */
    public ServiceBean() {
        service = new Service();
        serviceService = new ServiceService() ;
        employe = new Employe() ;
        employeService = new EmployeService() ;
        
    }
    
      public String onCreateAction() {
        serviceService.create(service);
        service = new Service();
        return null;
    }

       public List<Service> getServices() {
        if (services == null) {
            services = serviceService.getAll();
        }
        return services;
    }
     
    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }


      
      public void onDeleteAction() {
    if (service != null) {
        serviceService.delete(service); 
    }
    
}

    public List<Employe> getEmployes() {
        
         if (employes == null) {
            employes = service.getEmploye();
        }
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
    
public void onEdit(RowEditEvent event) {
        service = (Service) event.getObject();
        service.setEmploye(null);
        serviceService.update(service);
    }

    
   

    public void load() {
        System.out.println(service.getLibelle());
        service = serviceService.getById(service.getId());
        getServices();
    }
      
    
       public void onEditm(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service service = serviceService.getById(this.employe.getServices().getId());
        employe.setServices(service);
        employe.getServices().setLibelle(service.getLibelle());
       employeService.update(employe);
    }

   
    
    
     public List<Employe> serviceLoad() {
        for (Employe m : employeService.getAll()) {
            if (m.getServices().equals(service)) {
                employes.add(m);
            }
        }
        return employes;

    }
      



    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }
       
    

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    public void setServices(List<Service> services) {
        this.services = services;
    }

    
     public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries services = new ChartSeries();
        services.setLabel("Services");
        model.setAnimate(true);
        for (Service s : serviceService.getAll()) {
            services.set(s.getLibelle(), s.getEmploye().size());
        }
        model.addSeries(services);

        return model;
    }
    

   
}
