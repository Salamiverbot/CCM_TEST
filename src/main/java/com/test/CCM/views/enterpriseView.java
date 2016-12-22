package com.test.CCM.views;

import com.test.CCM.backend.CCM_Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class enterpriseView extends VerticalLayout implements View  {
	private static final long serialVersionUID = 1L;
	private Table tblExample;
	
	public enterpriseView(){
		this.setCaption(CCM_Constants.VIEW_NAME_ENTERPRISE);
		this.setSizeFull();
		this.tblExample = new Table();
		this.tblExample.setWidth("100%");
		this.tblExample.setSelectable(true);
		this.tblExample.setMultiSelect(true);
		this.tblExample.addContainerProperty("ID", Integer.class, 0);
		this.tblExample.addContainerProperty("Description", String.class, null);
		this.tblExample.addContainerProperty("Value_0", Integer.class, 0);
		this.tblExample.addContainerProperty("Value_1", String.class, null);
		this.tblExample.addContainerProperty("Value_2", String.class, null);
		this.addComponent(this.tblExample);
		this.setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.tblExample.clear();
		for(int i = 0; i<26;i++){
			this.tblExample.addItem(new Object[]{0, "Enterprise", i, "V1", "V2"}, i);
		}
		
	}

}
