package com.vlad.myIDPApp;

import java.util.Arrays;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

public class InviteWindow extends Window {
	 public InviteWindow() {
	        super("Invite users to collaborate with: ");
	        center();

	        setClosable(true);
	        setModal(true);
	        setHeight(30, Unit.PERCENTAGE);
	        setWidth(50, Unit.PERCENTAGE);

	        setContent(createContent());
	    }
	 
	 public Component createContent() {
		 FormLayout fl = new FormLayout();
		 fl.setSizeFull();
		 
		 ComboBox<String> usersComboBox = new ComboBox<String>();
		 usersComboBox.setCaption("Choose user to invite: ");
		 usersComboBox.setWidth(90, Unit.PERCENTAGE);
		 
		 ComboBox<String> rightsComboBox = new ComboBox<String>();
		 rightsComboBox.setCaption("Choose access level for this user: ");
		 rightsComboBox.setItems(Arrays.asList("Edit", "Read-only"));
		 rightsComboBox.setWidth(90, Unit.PERCENTAGE);
		 
		 fl.addComponent(usersComboBox);
		 fl.addComponent(rightsComboBox);
		 
		 Button inviteButton = new Button("Send invite");
		 fl.addComponent(inviteButton);
		 
		 return fl;
	 }
}
