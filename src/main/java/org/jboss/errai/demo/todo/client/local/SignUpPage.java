package org.jboss.errai.demo.todo.client.local;

import java.util.List;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;
import org.jboss.errai.enterprise.client.jaxrs.MarshallingWrapper;
import org.jboss.errai.ui.nav.client.local.Page;
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

import com.google.gwt.http.client.Response;

@Page
@Templated("SignUpPage.html#form-signup")
public class SignUpPage extends Composite {

	@Inject
	@Model
	@AutoBound
	private Contact contact;
	
	@Inject
	@DataField
	@Bound
	private TextBox firstname;
	
	@Inject
	@DataField
	private Button create;

	@Inject
	@DataField
	private Button cancel;
	
	@Inject
	TransitionTo<LoginForm> goToLoginForm;
	
	@Inject
	private Caller<ContactService> contactService;
	
	@EventHandler("create")
	public void createContact(ClickEvent e) {
	
		contactService.call((Response response) -> {
					Window.alert("Lambda: Contact created: " + MarshallingWrapper.fromJSON(response.getText(), Long.class));
					goToLoginForm.go();
		}).createContact(contact);
	}

	@EventHandler("cancel")
	public void cancel(ClickEvent e) {
		goToLoginForm.go();
		
	}

}
