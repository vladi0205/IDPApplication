package com.vlad.myIDPApp;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;

public class UserGrid extends Grid<User>{
	public List<User> users = new ArrayList<>();
	public XmlReader xmlReader = new XmlReader();
	
	public UserGrid() {
		xmlReader.readXML();
		users = xmlReader.users;

		setItems(users);
		addColumn(User::getUsername).setCaption("Username");
		addColumn(User::getStatus).setCaption("Status");
		setStyleName("mystyle");
		setWidth(80, Unit.PERCENTAGE);
	}
}
