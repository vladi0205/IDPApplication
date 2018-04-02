package com.vlad.myIDPApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

public class MainView extends AbsoluteLayout implements View {
	private static final long serialVersionUID = 1L;
	private Label secure;
	private Label currentUser;
	private Button otherSecure;
	private Button logout;
	public static final String NAME = "Secure";
	public XmlReader xmlReader = new XmlReader();
	public List<User> users = new ArrayList<>();
	public User user;
	
	public void createContent() {
		setSizeFull();
		Panel mainPanel = new Panel("MyIdpApp/Main Screen");
		mainPanel.setCaption("MyIdpApp");
    	mainPanel.setSizeFull();
    	mainPanel.setStyleName("mystyle");
    	addComponent(mainPanel);
    	Label userLabel = new Label("Logged in as " + VaadinSession.getCurrent().getAttribute("user").toString());
    	userLabel.addStyleName(ValoTheme.LABEL_BOLD);
    	userLabel.setHeight(20, Unit.PIXELS);
    	addComponent(userLabel, "right: 140 px; top: 1px;");
    	
    	Button logoutButton = new Button("Logout");
    	System.out.println(user);
    	
    	logoutButton.setWidth(120, Unit.PIXELS);
		logoutButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(MainView.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
			}
		});
		
		addComponent(logoutButton, "right: 10px, top: 1px;");
		TabSheet tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		tabSheet.addTab(new FilteredUserGridLayout(), "Manage my team");
		tabSheet.addTab(new FilteredDocumentsGridLayout(), "Manage my files");
		
		mainPanel.setContent(tabSheet);
    	
	}
	

	public MainView() {
		createContent();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		currentUser.setCaption("Current user : " + VaadinSession.getCurrent().getAttribute("user").toString()); 

	}

}
