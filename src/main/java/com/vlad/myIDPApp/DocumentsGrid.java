package com.vlad.myIDPApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.ui.Grid;
import com.vaadin.ui.themes.ValoTheme;

public class DocumentsGrid extends Grid<Doc>{
	public List<Doc> documents = new ArrayList<>();
	public XmlReader xmlReader = new XmlReader();
	
	public DocumentsGrid() {
		documents = Arrays.asList(
				new Doc("1", "asa"),
				new Doc("2", "aba"),
				new Doc("3", "aasda"),
				new Doc("4", "asdaa"),
				new Doc("5", "asgda"),
				new Doc("6", "aghsda"),
				new Doc("7", "ashda"),
				new Doc("8", "asdwda"),
				new Doc("9", "atsda"),
				new Doc("10", "asdqsa"));

		setItems(documents);
		addColumn(Doc::getDocNo).setCaption("Doc_Number");
		addColumn(Doc::getDocName).setCaption("Doc_Name");
		setStyleName("mystyle");
		setWidth(100, Unit.PERCENTAGE);
	}
}
