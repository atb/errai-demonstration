package org.atb.errai.demo.contactlist.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

@Templated("#body")
@EntryPoint
public class App extends Composite {

  @Inject
  private Navigation navigation;

  @Inject
  @DataField
  private NavBar navbar;

  @Inject
  @DataField
  private SimplePanel content;

  @PostConstruct
  public void clientMain() {
	  
	// To use jackson json and not errai json
	RestClient.setJacksonMarshallingActive(true);
	  
    content.clear();
    content.add(navigation.getContentPanel());
    RootPanel.get().add(this);
  }
}
