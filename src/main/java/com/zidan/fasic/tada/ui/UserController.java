package com.zidan.fasic.tada.ui;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/index.jsf")
public class UserController {

    private String userName;
    private String userPassword;
    private boolean loggedIn = false;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void login(ActionEvent event) {
        FacesMessage message = null;
        loggedIn = true;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userName);

        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().addCallbackParam("loggedIn", loggedIn);
    }

    public void logout(ActionEvent event){
        FacesMessage message = null;
        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logged out ", userName);

        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
