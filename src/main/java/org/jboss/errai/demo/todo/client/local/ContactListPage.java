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
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.Window;

@Page
@Templated(value = "LoginForm.html#contact-list")
public class ContactListPage {

	@Inject
	@AutoBound
	private DataBinder<List<Contact>> binder;

	@Inject
	@Bound
	@DataField
	private ListComponent<Contact, ContactDisplay> list;
	
	// (ATB) How to fill a list of contacts...
	@Inject
	private Caller<ContactService> contactService;

	/**
	 * Register handlers and populate the list of {@link Contact Contacts}.
	 */
	@PostConstruct
	private void setup() {
		
		Window.alert("ContactListPage!");
		
		/*
		 * Triggers an HTTP request to the ContactStorageService. The call back will be
		 * invoked asynchronously to display all retrieved contacts.
		 */
		contactService.call((final List<Contact> contacts) -> { binder.getModel().addAll(contacts);
				Window.alert("Lambda from ContactsListPage: Contacts received: " + contacts.size());
			}).listAllContacts();

		// Remove placeholder table row from template.
		//DOMUtil.removeAllElementChildren(list.getElement());

		/*
		 * Configure actions for when a ContactDisplay in the list is selected or
		 * deselected.
		 */
		//list.setSelector(display -> display.setSelected(true));
		//list.setDeselector(display -> display.setSelected(false));
	}
}
