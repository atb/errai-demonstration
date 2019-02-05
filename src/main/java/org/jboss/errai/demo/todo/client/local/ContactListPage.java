package org.jboss.errai.demo.todo.client.local;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.components.ListComponent;
import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

@Page(role = DefaultPage.class)
@Templated(value = "LoginForm.html#contact-list")
public class ContactListPage {

	@Inject
	@AutoBound
	private DataBinder<List<Contact>> binder;

	@Inject
	@Bound
	@DataField
	private ListComponent<Contact, ContactDisplay> list;
	
	@Inject
	@DataField
	private Button gohome;

	@Inject
	@DataField
	private Button newcontact;
	
	@Inject
	TransitionTo<LoginForm> goToLogin;
	
	@Inject
	TransitionTo<SignUpPage> goToSignup;	
	
	// (ATB) How to fill a list of contacts...
	@Inject
	private Caller<ContactService> contactService;

	/**
	 * Register handlers and populate the list of {@link Contact Contacts}.
	 */
	@PostConstruct
	private void setup() {
		
		/*
		 * Triggers an HTTP request to the ContactStorageService. The call back will be
		 * invoked asynchronously to display all retrieved contacts.
		 */
		contactService.call((final List<Contact> contacts) -> binder.getModel().addAll(contacts)).listAllContacts();

		// Remove placeholder table row from template.
		DOMUtil.removeAllElementChildren(list.getElement());

		/*
		 * Configure actions for when a ContactDisplay in the list is selected or
		 * deselected.
		 */
		//list.setSelector(display -> display.setSelected(true));
		//list.setDeselector(display -> display.setSelected(false));
	}

	@EventHandler("gohome")
	public void signUp(ClickEvent e) {
		goToLogin.go();
	}


	@EventHandler("newcontact")
	public void newContact(ClickEvent e) {
		goToSignup.go();
	}
}
