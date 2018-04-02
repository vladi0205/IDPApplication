package com.vlad.myIDPApp;

import java.util.Arrays;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class SignUpWindow extends Window {
	 public SignUpWindow() {
	        super("Please sign-up before you can use MyIDPApp: ");
	        center();

	        setClosable(true);
	        setModal(true);
	        setHeight(40, Unit.PERCENTAGE);
	        setWidth(40, Unit.PERCENTAGE);

	        setContent(createContent());
	    }
	public Component createContent() {
		 	FormLayout fl = new FormLayout();
		 	fl.setSizeFull();
			 
		 	TextField usernameTextField = new TextField();
		 	usernameTextField.setCaption("Enter username: ");
			usernameTextField.setWidth(90, Unit.PERCENTAGE);
			 
			TextField passwordTextField = new TextField();
		 	passwordTextField.setCaption("Enter password: ");
			passwordTextField.setWidth(90, Unit.PERCENTAGE);
			
			TextField reEnterPasswordTextField = new TextField();
		 	reEnterPasswordTextField.setCaption("Re-enter password: ");
			reEnterPasswordTextField.setWidth(90, Unit.PERCENTAGE);
			
			fl.addComponent(usernameTextField);
			fl.addComponent(passwordTextField);
			fl.addComponent(reEnterPasswordTextField);
			
			Button registerButton = new Button("Register");
			fl.addComponent(registerButton);
			
			return fl;
		 }
}