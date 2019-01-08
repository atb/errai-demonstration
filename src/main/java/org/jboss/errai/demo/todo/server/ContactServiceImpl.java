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

package org.jboss.errai.demo.todo.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.ws.rs.core.Response;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.demo.todo.client.shared.Contact;
import org.jboss.errai.demo.todo.client.shared.ContactService;

/**
 * Simple mock based service implementation.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
@ApplicationScoped
public class ContactServiceImpl implements ContactService {

  private static AtomicInteger id = new AtomicInteger(3);

  private static Map<Long, Contact> contacts = new ConcurrentHashMap<Long, Contact>() {
    {
      put(1l, new Contact(1, "Christian"));
      put(2l, new Contact(2, "Mike"));
      put(3l, new Contact(3, "Jonathan"));
    }
  };


  @Override
  public List<Contact> listAllContacts() {
    List<Contact> contacts = new ArrayList<Contact>(ContactServiceImpl.contacts.values());
    Collections.sort(contacts);
    return contacts;
  }
}
