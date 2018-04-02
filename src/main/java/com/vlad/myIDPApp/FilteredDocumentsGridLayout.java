package com.vlad.myIDPApp;

import java.util.Optional;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

final class FilteredDocumentsGridLayout extends VerticalLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DocumentsGrid docsGrid;
    private final TextField docNoFilter;
    private final TextField docNameFilter;
    public VerticalLayout rightSideLayout = new VerticalLayout();

    public FilteredDocumentsGridLayout() {
    	HorizontalSplitPanel hsp = new HorizontalSplitPanel();
    	hsp.setSizeFull();
    	hsp.setSplitPosition(50, Unit.PERCENTAGE);
    	hsp.setLocked(true);
    	FormLayout fl = new FormLayout();
    	fl.setWidth(100, Unit.PERCENTAGE);
    	
        docNoFilter = new TextField();
        docNoFilter.setStyleName(ValoTheme.LABEL_H2);
        docNoFilter.setPlaceholder("Doc No...");
        docNoFilter.setWidth(100, Unit.PERCENTAGE);
        docNoFilter.addValueChangeListener(this::onDocNoFilterTextChange);
        
        docNameFilter = new TextField();
        docNameFilter.setWidth(100, Unit.PERCENTAGE);
        docNameFilter.setPlaceholder("Doc Name...");
        docNameFilter.addValueChangeListener(this::onDocNameFilterTextChange);
        
        fl.addComponent(docNoFilter);
        fl.addComponent(docNameFilter);
       
        //hl.setExpandRatio(statusFilter, 1.0f);

        docsGrid = new DocumentsGrid();
        
        HorizontalLayout buttonHl = new HorizontalLayout();
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button inviteButton = new Button("Give access");
        inviteButton.addClickListener(event -> {
            InviteWindow inviteWindow = new InviteWindow();
            UI.getCurrent().addWindow(inviteWindow);
        });
        buttonHl.addComponent(editButton);
        buttonHl.addComponent(deleteButton);
        buttonHl.addComponent(inviteButton);
        
        fl.addComponent(docsGrid);
        
        hsp.setFirstComponent(fl);
        rightSideLayout.setSizeFull();
        rightSideLayout.addComponent(buttonHl);
    	TextArea docTextArea = new TextArea();
    	docTextArea.setSizeFull();
    	docTextArea.setCaption("Old: ");
    	docTextArea.setStyleName(ValoTheme.TEXTAREA_LARGE);
    	rightSideLayout.addComponent(docTextArea);
    	rightSideLayout.setExpandRatio(docTextArea, 1.0f);
    	hsp.setSecondComponent(rightSideLayout);
    	
    	TextArea newDocTextArea = new TextArea();
    	newDocTextArea.setSizeFull();
    	newDocTextArea.setCaption("New: ");
    	newDocTextArea.setStyleName(ValoTheme.TEXTAREA_LARGE);
    	rightSideLayout.addComponent(newDocTextArea);
    	rightSideLayout.setExpandRatio(newDocTextArea, 1.0f);
    	
    	Button compareButton = new Button("Open in compare window");
    	compareButton.addClickListener(event -> {
            CompareWindow compareWindow = new CompareWindow();
            UI.getCurrent().addWindow(compareWindow);
        });
    	rightSideLayout.addComponent(compareButton);
    	hsp.setSecondComponent(rightSideLayout);
    	
        docsGrid.addSelectionListener(event -> {
        	Optional<Doc> selected = docsGrid.getSelectionModel().getFirstSelectedItem();
        	
        	docTextArea.setPlaceholder("sadasdasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        			+ "dasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
        			+ "sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        			+ "saddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        			+ "sadddddddddddddddddddddddddddddddddddd"
        			+ "dassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
        			+ "saddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        			+ "sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        			+ "dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        			+ "dasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
        			+ "sadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        			+ "dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        	
        });
        
        addComponent(hsp);
        //addComponentsAndExpand(docsGrid);
    }

    private void onDocNoFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<Doc> dataProvider = (ListDataProvider<Doc>) docsGrid
        		.getDataProvider();
        dataProvider.setFilter(Doc::getDocNo, s -> caseInsensitiveContains(s, event.getValue()));
    }
    
    private void onDocNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<Doc> dataProvider = (ListDataProvider<Doc>) docsGrid
        		.getDataProvider();
        dataProvider.setFilter(Doc::getDocName, s -> caseInsensitiveContains(s, event.getValue()));
    }

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }
    

}
