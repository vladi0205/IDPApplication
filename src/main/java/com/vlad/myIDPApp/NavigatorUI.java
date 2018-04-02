package com.vlad.myIDPApp;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import org.jsoup.nodes.Element;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ClientMethodInvocation;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Extension;
import com.vaadin.server.Resource;
import com.vaadin.server.ServerRpcManager;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.ClientConnector.AttachListener;
import com.vaadin.server.ClientConnector.DetachListener;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.Registration;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component.Listener;
import com.vaadin.ui.HasComponents.ComponentAttachListener;
import com.vaadin.ui.HasComponents.ComponentDetachListener;
import com.vaadin.ui.declarative.DesignContext;

import elemental.json.JsonObject;

@Theme("mytheme")
public class NavigatorUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Navigator navigator;
    protected static final String LOGINVIEW = "Login View";
    
    public static Authentication AUTH;
    private XmlReader xmlReader = new XmlReader();
    
    protected void init(VaadinRequest request) {
    	getPage().setTitle("Navigation Example");
    	LoginView loginView = new LoginView();

        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        // Create and register the views
        navigator.addView(LOGINVIEW, loginView);
        
        attach();
        setSizeFull();

        setContent(loginView);
        this.navigator.setErrorView(loginView);
    }
    
    @WebServlet(urlPatterns = "/*", name = "NavigatorUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
    public static class NavigatorUIServlet extends VaadinServlet {
    }
}
