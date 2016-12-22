package com.test.CCM.views;

import com.test.CCM.backend.CCM_Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class userView extends VerticalLayout implements View  {
	private static final long serialVersionUID = 1L;
	
	public userView(){
		this.setCaption(CCM_Constants.VIEW_NAME_USER);
		this.setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
