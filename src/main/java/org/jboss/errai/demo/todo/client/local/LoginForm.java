package org.jboss.errai.demo.todo.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

@Page(role = DefaultPage.class)
@Templated("LoginForm.html#form-login")
public class LoginForm extends Composite {
	@Inject
	@DataField
	private TextBox username;

	@Inject
	@DataField
	private PasswordTextBox password;

	@Inject
	@DataField
	private Button cancel;

	@EventHandler("cancel")
	public void clearForm(ClickEvent e) {
		username.setText("");
		password.setText("");
	}

	@Inject
	@DataField
	private Button signup;
	
	@Inject
	TransitionTo<SignUpPage> goToSignup;
	
	@EventHandler("signup")
	public void signUp(ClickEvent e) {
		Window.alert("Clicked Signup. User="+username.getText());
		//goToSignup.go();
	}	
}
