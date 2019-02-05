package org.jboss.errai.demo.todo.client.local;

import java.util.List;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionAnchor;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Model;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

@Page
@Templated("LoginForm.html#form-login")
public class LoginForm extends Composite {

	@Inject
	@Model
	@AutoBound
	private User user;

	@Inject
	@DataField
	@Bound(onKeyUp = true)
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

	@Inject
	TransitionTo<ContactListPage> goToContactList;

	@EventHandler("signup")
	public void signUp(ClickEvent e) {
		// User model=userBinder.getModel();
		Window.alert("Clicked Signup. User=" + user.getUsername());
		// Example of navigating to another page
		// goToSignup.go();
		goToContactList.go();
	}

	// (ATB) How to fill a list of contacts...
	@Inject
	private Caller<ContactService> contactService;

	@AfterInitialization
	public void doStuffAfterInit() {
		// ... do some work ...

// (ATB) Old Code		
// Lets try to call a service in the server:
//		RemoteCallback<List<Contact>> callback = new RemoteCallback<List<Contact>>() {
//
//			  public void callback(List<Contact> contacts) {
//			    Window.alert("Contacts received: " + contacts.size());
//			  }
//			};
//		contactService.call(callback).listAllContacts();

		/*
// (ATB) New code		
		Window.alert("AfterInitialization");

		contactService.call((List<Contact> contacts) -> Window.alert("Lambda: Contacts received: " + contacts.size()))
				.listAllContacts()
*/
	}
}
