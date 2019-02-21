package org.atb.errai.demo.contactlist.client.shared;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("rest/contacts")
public interface ContactService {
  @GET
  @Produces("application/json")
  public List<Contact> listAllContacts();
  
  @POST
  @Consumes("application/json")
  @Produces("text/plain")
  public Response createContact(Contact contact);
}