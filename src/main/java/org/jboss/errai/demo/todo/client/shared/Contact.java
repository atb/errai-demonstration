package org.jboss.errai.demo.todo.client.shared;

import java.io.Serializable;
import java.util.Date;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

/**
 * Simple customer entity
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
@Bindable
@Portable
public class Contact implements Serializable, Comparable<Contact> {
  private static final long serialVersionUID = 1L;

  private long id;
  private String firstname;

  public Contact() {}

  public Contact(String firstname) {
    this.firstname = firstname;
  }

  public Contact(long id, String firstname) {
    this(firstname);
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  @Override
  public String toString() {
    return "Contact [id=" + id + ", firstname=" + firstname + "]";
  }

  @Override
  public int compareTo(Contact contact) {
    return (int) (id - contact.id);
  }
}
