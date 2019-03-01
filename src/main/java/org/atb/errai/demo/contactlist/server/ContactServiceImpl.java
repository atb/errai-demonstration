/*
 * Copyright (C) 2011 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.atb.errai.demo.contactlist.server;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.atb.errai.demo.contactlist.client.shared.Contact;
import org.atb.errai.demo.contactlist.client.shared.ContactService;
import org.atb.errai.demo.contactlist.server.ContactEntityService;
import org.slf4j.Logger;

import javax.ws.rs.core.UriBuilder;
import javax.inject.Inject;

@ApplicationScoped
public class ContactServiceImpl implements ContactService {

	@Inject
	private ContactEntityService entityService;
	
	// For logging
	@Inject Logger logger;

	@Override
	public List<Contact> listAllContacts() {
		logger.info("listAllContacts in Server!");
		//return new ArrayList<Contact>();
		
		Contact c = entityService.getById(1L);
		
		List<Contact> temp=entityService.getAllContacts();
		return temp;
	}

	@Override
	public Response createContact(Contact contact) {
		logger.info("createContact in Server! name="+contact.getName());
		entityService.create(contact);
	    return Response.created(UriBuilder.fromResource(ContactService.class)
	            .path(String.valueOf(contact.getId())).build()).status(Status.OK).build();
		
	}
}
