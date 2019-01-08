package org.jboss.errai.demo.todo.client.shared;

import java.io.Serializable;
import java.util.Date;

import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Simple customer entity
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
@Portable
public class Contact implements Serializable, Comparable<Contact> {
  private static final long serialVersionUID = 1L;

  private long id;
  private String firstName;

  public Contact() {}

  public Contact(String firstName) {
    this.firstName = firstName;
  }

  public Contact(long id, String firstName) {
    this(firstName);
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  @Override
  public String toString() {
    return "Contact [id=" + id + ", firstName=" + firstName + "]";
  }

  @Override
  public int compareTo(Contact contact) {
    return (int) (id - contact.id);
  }
}
