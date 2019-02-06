package org.atb.errai.demo.contactlist.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Templated
public class NavBar extends Composite {

  @Inject @DataField Button info;

  @Inject TransitionTo<ContactListPage> homeTab;

  @EventHandler("info")
  public void onHomeButtonClick(ClickEvent e) {
    homeTab.go();
  }
}
