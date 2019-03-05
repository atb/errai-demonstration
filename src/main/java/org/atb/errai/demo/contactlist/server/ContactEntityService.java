package org.atb.errai.demo.contactlist.server;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.atb.errai.demo.contactlist.client.shared.Contact;

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Contact Contacts}.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ContactEntityService {

  @PersistenceContext(unitName = "forge-default")
  private EntityManager em;

  public List<Contact> getAllContacts() {
    return em.createNamedQuery(Contact.ALL_CONTACTS_QUERY, Contact.class).getResultList();

    //return em.createQuery("SELECT c FROM Contact c ORDER BY c.id", Contact.class).getResultList();
    
  }

  public void create(final Contact newContact) {
    em.persist(newContact);
  }

  public void update(final Contact contact) {
    em.merge(contact);
  }
  
  public Contact getById(final Long id) {
	  final   Contact contact = em.find(Contact.class, id);
	  return contact;
  }

  public void delete(final Long id) {
    final Contact contact = em.find(Contact.class, id);
    if (contact != null) {
      em.remove(contact);
    } else {
      throw new IllegalArgumentException(
              "The given id, " + id + ", was not a key for any " + Contact.class.getSimpleName());
    }
  }

}
