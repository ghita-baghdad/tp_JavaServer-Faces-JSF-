/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import services.AuthService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@SessionScoped
public class AuthBean {
    private String username;
    private String password;

    public AuthBean() {
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public String login() {
        AuthService authService = new AuthService();
        if (authService.authenticate(username, password)) {
            // Authentification réussie, rediriger vers la page sécurisée
            return "/secured/welcome.xhtml?faces-redirect=true";
        } else {
            // Authentification échouée, rester sur la page de connexion avec un message d'erreur
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Authentification échouée."));
            return null;
        }
    }
    
    public String logout() {
        // Terminer la session
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        session.invalidate();

        // Rediriger vers la page de connexion après la déconnexion
        return "/login.xhtml?faces-redirect=true";
    }
  
}