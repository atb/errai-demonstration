package org.jboss.errai.demo.todo.client.local;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Model;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

import com.google.gwt.http.client.Response;

@Page
@Templated("NewContactPage.html#form-newcontact")
public class NewContactPage extends Composite {

	@Inject
	@Model
	@AutoBound
	private Contact contact;
	
	@Inject
	@DataField
	@Bound
	private TextBox name;

	@Inject
	@DataField
	@Bound
	private TextBox email;
	
	@Inject
	@DataField
	private Button create;

	
	@Inject
	TransitionTo<ContactListPage> goToContactListPage;
	
	@Inject
	private Caller<ContactService> contactService;
	
	@EventHandler("create")
	public void createContact(ClickEvent e) {
	
		contactService.call((Response response) -> {
					goToContactListPage.go();
		}).createContact(contact);
	}
}
