package org.jboss.errai.demo.todo.client.local;

import java.util.List;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
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
	
	@Inject
	private Caller<ContactService> contactService;
	
	@EventHandler("signup1")
	public void clickSignup(ClickEvent e) {
		
		// Lets try to call a service in the server:
		RemoteCallback<List<Contact>> callback = new RemoteCallback<List<Contact>>() {

			  public void callback(List<Contact> contacts) {
			    Window.alert("Contacts received: " + contacts.size());
			  }
			};
		contactService.call(callback).listAllContacts();

		goToLoginForm.go();
		
	}
}
