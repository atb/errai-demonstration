package org.jboss.errai.demo.todo.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Page
@Templated("SignUpPage.html#form-signup")
public class SignUpPage extends Composite {

	@Inject
	@DataField
	private Button signup1;

	@Inject
	TransitionTo<LoginForm> goToLoginForm;
	
	@EventHandler("signup1")
	public void clickSignup(ClickEvent e) {
		goToLoginForm.go();
	}
}
