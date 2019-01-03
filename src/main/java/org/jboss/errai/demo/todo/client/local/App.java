package org.jboss.errai.demo.todo.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


@EntryPoint

public class App {

	@Inject LoginForm loginForm;
	@Inject SignUpPage signUpPage;
	
	@Inject
	private Navigation navigation;
	
  @PostConstruct
  public void onLoad() {
	  
//	    VerticalPanel vp = new VerticalPanel();
//
//	    vp.add(navigation.getContentPanel());
//
//	    vp.add(loginForm);
//	    vp.add(signUpPage);
//
//	    RootPanel.get().add(vp);

	    SplitLayoutPanel p = new SplitLayoutPanel();
	    p.addWest(new HTML("navigation"), 128);
	    p.addNorth(new HTML("list new"), 20);
	    p.addNorth(loginForm, 300);
//	    SimpleLayoutPanel vp = new SimpleLayoutPanel();
//	    vp.add(loginForm);
//	    p.add(vp);
//	    vp.onResize();
	    
	    RootPanel.get().add(p);
	  

   // Window.alert("Hello World!");
   //RootPanel.get().add(loginForm);
   //RootPanel.get().add(signUpPage);  
  }

}
