package com.vlad.myIDPApp;

import javax.servlet.annotation.WebServlet;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class LoginView extends Panel implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private XmlReader xmlReader = new XmlReader();
	private String username;
	private User user;
	public MainView mainView;
	
	public LoginView() {
		createContent();
	}

    protected void createContent() {
    	setCaption("MyIdpApp");
    	setSizeFull();
    	VerticalLayout vl = new VerticalLayout();
    	vl.setSizeFull();
    	vl.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    	HorizontalLayout hl = new HorizontalLayout();
    	hl.setHeight(70, Unit.PERCENTAGE);
    	vl.addComponent(hl);
    	Panel loginPanel = createLoginPanel();
    	vl.addComponent(loginPanel);
    	vl.setExpandRatio(loginPanel, 1.0f);
    	setContent(vl);

    }
	
	private Panel createLoginPanel() {
		Panel loginPanel = new Panel("Login");
		loginPanel.addStyleName("dsada");
		loginPanel.setWidth(40, Unit.PERCENTAGE);
		VerticalLayout vl = new VerticalLayout();
		vl.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		TextField usernameTextField = new TextField();
		usernameTextField.setPlaceholder("Username");
		usernameTextField.setSizeFull();
		usernameTextField.addStyleName(ValoTheme.TEXTFIELD_LARGE);
		TextField passwordTextField = new PasswordField();
		passwordTextField.setPlaceholder("Password");
		passwordTextField.setSizeFull();
		passwordTextField.addStyleName(ValoTheme.TEXTFIELD_LARGE);
		Label header = new Label("Sign in to continue to myIdpApp");
		header.addStyleName(ValoTheme.LABEL_H2);
		vl.addComponent(header);
		vl.addComponent(usernameTextField);
		vl.addComponent(passwordTextField);
		Button loginButton = new Button("Sign-in");
		loginButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				username = usernameTextField.getValue();
				xmlReader.readXML();
				
				NavigatorUI.AUTH = new Authentication(username, xmlReader.getPassword(username));
				
				if(NavigatorUI.AUTH.authenticate(username, passwordTextField.getValue())){
					VaadinSession.getCurrent().setAttribute("user", username);
					getUI().getNavigator().addView(MainView.NAME, MainView.class);
		
					//getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
					Page.getCurrent().setUriFragment("!"+MainView.NAME);
				}else{
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}
			
		});
		loginButton.setSizeFull();
		vl.addComponent(loginButton);
		Label label = new Label("Don't have an account?");
		
		Button signUpButton = new Button("Sign-up now");
		signUpButton.setHeight(100, Unit.PERCENTAGE);
		signUpButton.addClickListener(event -> {
            SignUpWindow signUpWindow = new SignUpWindow();
            UI.getCurrent().addWindow(signUpWindow);
        });
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponent(label);
		hl.addComponent(signUpButton);
		vl.addComponent(hl);
		
		loginPanel.setContent(vl);
		return loginPanel;
	}
	
}
