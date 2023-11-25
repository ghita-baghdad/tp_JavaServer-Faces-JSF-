/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static antlr.build.ANTLR.root;
import entities.Employe;
import entities.Service;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.tree.TreeNode;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
import services.EmployeService;
import services.ServiceService;

/**
 *
 * @author Lenovo
 */
@ManagedBean(name = "EmployeBean")
public class EmployeBean {

    private Employe employe;
    private EmployeService employeService;
    private List<Employe> employes;
    private Service service;
    private List<Service> services ;
    private ServiceService serviceService;
    private List<Employe> chefs;
    private Employe selectedChef;
    private static ChartModel barModel;
    private TreeNode root;

    /**
     * Creates a new instance of EmployeBean
     */
    public EmployeBean() {
        employe = new Employe();
        employe.setServices(new Service());
        employeService = new EmployeService();
        serviceService = new ServiceService();
        selectedChef = new Employe();
     
       
    }

 

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }

    public List<Service> getServices() {
        if (services == null) {
            services = (List<Service>) employe.getServices();
        }
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

  

    public String onCreateAction() {
//   EmployeService employeService = new EmployeService();
        employe.setChef(selectedChef);
        employeService.create(employe);
        employe = new Employe();
        selectedChef = null;

        return null;
    }
    
       public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.getAll();
        }
        return employes;
    }

    public void onDeleteAction() {
   employeService.delete(employeService.getById(employe.getId()));
    }

    public List<Employe> serviceLoad() {
        for (Employe e : employeService.getAll()) {
            if (e.getServices().equals(service)) {
                employes.add(e);
            }
        }
        return employes;
    }

    public void load() {
        System.out.println(employe.getNom());
        employe = employeService.getById(employe.getId());
        getEmployes();
    }

//    public void onEdit(RowEditEvent event) {
//        employe = (Employe) event.getObject();
//        employe.setServices(null);
//        employeService.update(employe);
//    }
   
  
      public void onEdit(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service service = serviceService.getById(this.employe.getServices().getId());
        employe.setServices(service);
        employe.getServices().setLibelle(service.getLibelle());
        employeService.update(employe);
    }

    public void onCancel(RowEditEvent event) {
    }
    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries Employes = new ChartSeries();
        Employes.setLabel("Employes");
        model.setAnimate(true);

        for (Object[] e : EmployeService.nbEmployeByChef()) {
            Employes.set((String) e[1], Integer.parseInt(e[0].toString()));
        }

        model.addSeries(Employes);

        return model;
    }

  

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    

    public List<Employe> getChefs() {
        if (chefs == null) {
            chefs = employeService.getAll();
        }
        return chefs;
    }

    public Employe getSelectedChef() {
        return selectedChef;
    }

    public void setSelectedChef(Employe selectedChef) {
        this.selectedChef = selectedChef;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

     @PostConstruct
    public void init() {
        employeService = new EmployeService();
        serviceService = new ServiceService();
        services = serviceService.getAll();
    }
 
//     public void loadTree() {
//    root.getChildren().clear(); // Clear old nodes
//    List<Service> services = serviceService.getAll();
//
//    for (Service service : services) {
//        TreeNode serviceNode = new DefaultTreeNode(service, root);
//
//        // Employees nodes
//        for (Employe employe : employeService.employessByService(service)) {
//            TreeNode employeNode = new DefaultTreeNode(employe, serviceNode);
//
//            // Chief node
//            Employe chief = employe.getChef();
//            if (chief != null) {
//                TreeNode chiefNode = new DefaultTreeNode(chief, employeNode);
//            }
//        }
//    }
//}


    
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

 


}


   


