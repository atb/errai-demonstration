package org.atb.errai.demo.contactlist.client.shared;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
@Portable
@Entity
@NamedQueries({ @NamedQuery(name = Contact.ALL_CONTACTS_QUERY, query = "SELECT c FROM Contact c ORDER BY c.id") })
public class Contact implements Serializable, Comparable<Contact> {
	private static final long serialVersionUID = 1L;

	public static final String ALL_CONTACTS_QUERY = "allContacts";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	private String email;

	public Contact() {
	}

	public Contact(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Contact(long id, String name, String email) {
		this(name, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Contact contact) {
		return (int) (id - contact.id);
	}

	@Override
	public boolean equals(final Object obj) {
		return (obj instanceof Contact) && ((Contact) obj).getId() != 0 && ((Contact) obj).getId() == getId();
	}

	@Override
	public int hashCode() {
		return (int) getId();
	}
}
