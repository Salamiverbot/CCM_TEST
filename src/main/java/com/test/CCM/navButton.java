package com.test.CCM;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class navButton extends Button{
	private static final long serialVersionUID = 1L;
	
	public navButton(String viewName, Navigator nav){
		this.setCaptionAsHtml(true);
		this.setCaption("<font color=#35adcc><left>"+viewName+"</left></font>");
		this.setWidth("100%");
		this.setStyleName(ValoTheme.BUTTON_BORDERLESS);
		this.addClickListener(listener -> {
			nav.navigateTo(viewName);
		});
	}

}
