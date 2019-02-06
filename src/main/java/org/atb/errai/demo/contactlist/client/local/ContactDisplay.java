package org.atb.errai.demo.contactlist.client.local;

import javax.inject.Inject;

import org.atb.errai.demo.contactlist.client.shared.Contact;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.TakesValue;

import elemental2.dom.HTMLDivElement;

@Templated(value = "ContactListPage.html#contact")
public class ContactDisplay implements TakesValue<Contact>, IsElement {

	@Inject
	@AutoBound
	protected DataBinder<Contact> binder;

	@Override
	public Contact getValue() {
		return binder.getModel();
	}

	@Override
	public void setValue(final Contact model) {
		binder.setModel(model);
	}

	@Inject
	@Bound
	@DataField
	private HTMLDivElement name;
	
	@Inject
	@Bound
	@DataField
	private HTMLDivElement email;
}
