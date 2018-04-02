package com.vlad.myIDPApp;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

final class FilteredUserGridLayout extends VerticalLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserGrid userGrid;
    private final TextField userFilter;
    private final TextField statusFilter;

    public FilteredUserGridLayout() {
    	HorizontalLayout hl = new HorizontalLayout();
    	hl.setWidth(80, Unit.PERCENTAGE);
        userFilter = new TextField();
        userFilter.setStyleName(ValoTheme.LABEL_H2);
        userFilter.setPlaceholder("username...");
        userFilter.setWidth(100, Unit.PERCENTAGE);
        userFilter.addValueChangeListener(this::onUserameFilterTextChange);
        
        statusFilter = new TextField();
        statusFilter.setWidth(100, Unit.PERCENTAGE);
        statusFilter.setPlaceholder("status...");
        statusFilter.addValueChangeListener(this::onStatusFilterTextChange);
        
        hl.addComponent(userFilter);
        hl.addComponent(statusFilter);
        //hl.setExpandRatio(statusFilter, 1.0f);

        userGrid = new UserGrid();
        
        addComponent(hl);
        addComponentsAndExpand(userGrid);
    }

    private void onUserameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<User> dataProvider = (ListDataProvider<User>) userGrid
        		.getDataProvider();
        dataProvider.setFilter(User::getUsername, s -> caseInsensitiveContains(s, event.getValue()));
    }
    
    private void onStatusFilterTextChange(HasValue.ValueChangeEvent<String> event) {
        ListDataProvider<User> dataProvider = (ListDataProvider<User>) userGrid
        		.getDataProvider();
        dataProvider.setFilter(User::getStatus, s -> caseInsensitiveContains(s, event.getValue()));
    }

    private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }

}
