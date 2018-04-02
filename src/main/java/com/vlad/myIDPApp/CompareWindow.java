package com.vlad.myIDPApp;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class CompareWindow extends Window {
	 public CompareWindow() {
	        super(" ");
	        center();

	        setClosable(true);
	        setModal(true);
	        setHeight(90, Unit.PERCENTAGE);
	        setWidth(80, Unit.PERCENTAGE);

	        setContent(createCompareSplitPanel());
	    }
	 public HorizontalSplitPanel createCompareSplitPanel() {
		 HorizontalSplitPanel hsp = new HorizontalSplitPanel();
		 hsp.setSizeFull();
		 hsp.setSplitPosition(50, Unit.PERCENTAGE);
		 hsp.setMinSplitPosition(45, Unit.PERCENTAGE);
		 hsp.setMaxSplitPosition(55, Unit.PERCENTAGE);
		 
		 TextField oldDoc = new TextField();
		 oldDoc.setSizeFull();
		 oldDoc.setPlaceholder("old text...");
		 oldDoc.setCaption("Old: ");
		 
		 TextField newDoc = new TextField();
		 newDoc.setSizeFull();
		 newDoc.setPlaceholder("new text...");
		 newDoc.setCaption("Old: ");
		 
		 hsp.setFirstComponent(oldDoc);
		 hsp.setSecondComponent(newDoc);
		 return hsp;
	 }
}