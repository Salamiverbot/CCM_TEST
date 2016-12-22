package com.test.CCM;

import javax.servlet.annotation.WebServlet;

import com.test.CCM.backend.CCM_Constants;
import com.test.CCM.views.enterpriseView;
import com.test.CCM.views.meetingView;
import com.test.CCM.views.startView;
import com.test.CCM.views.userView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@Theme("mytheme")
public class CCM_UI extends UI {
	private static final long serialVersionUID = 1L;
	
	private HorizontalLayout hlContent;
	private CssLayout clNavigation;
	private final Panel pnlViews = new Panel();
	private Navigator navigator;
	
    @WebServlet(urlPatterns = "/*", name = "CCM", asyncSupported = true)
    @VaadinServletConfiguration(ui = CCM_UI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }

	@Override
    protected void init(VaadinRequest vaadinRequest) {
		this.setSizeFull();
		this.initViewNavigator();
		this.initContentLayout();
		this.initNavigationLayout();
		this.initViewPanel();
		this.setContent(this.hlContent);
    }
	
	private void initContentLayout(){
		this.hlContent = new HorizontalLayout();
		this.hlContent.setSizeFull();
	}
	
	private void initNavigationLayout(){
		this.clNavigation = new CssLayout();
		this.clNavigation.setSizeFull();
		this.clNavigation.addComponent(new navButton(CCM_Constants.VIEW_NAME_START, this.navigator));
		this.clNavigation.addComponent(new navButton(CCM_Constants.VIEW_NAME_USER, this.navigator));
		this.clNavigation.addComponent(new navButton(CCM_Constants.VIEW_NAME_ENTERPRISE, this.navigator));
		this.clNavigation.addComponent(new navButton(CCM_Constants.VIEW_NAME_MEETING, this.navigator));	
		this.hlContent.addComponent(this.clNavigation);
		this.hlContent.setExpandRatio(this.clNavigation, 1);
	}
	
	private void initViewPanel(){	
		this.hlContent.addComponent(this.pnlViews);
		this.hlContent.setExpandRatio(this.pnlViews, 7);
		this.pnlViews.setSizeFull();	
	}
	
	private void initViewNavigator(){
		this.navigator = new Navigator(this, this.pnlViews);
		this.navigator.addView(CCM_Constants.VIEW_NAME_START, new startView());
		this.navigator.addView(CCM_Constants.VIEW_NAME_USER, new userView());
		this.navigator.addView(CCM_Constants.VIEW_NAME_ENTERPRISE, new enterpriseView());
		this.navigator.addView(CCM_Constants.VIEW_NAME_MEETING, new meetingView());
		this.navigator.navigateTo(CCM_Constants.VIEW_NAME_START);
	}
	
}
