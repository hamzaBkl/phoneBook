package com.example.phonebook.service;

import com.example.phonebook.dao.ContactDao;
import com.example.phonebook.model.Contact;

import java.time.LocalDate;
import java.util.List;

public class testService {

	public static void main(String[] args) {
			ContactDao dao = new ContactDaoImpl();
			List<Contact> contactsList;


			for(int i=0;i<10;i++) {
				Contact  contact=new Contact();
				contact.setPseudo("contact"+i);
				contact.setCodePostal(i+"234");
				contact.setMail("contact"+i+"@email.com");
				contact.setPhoto("contact"+i+".png");
				contact.setDateInscription( LocalDate.now());

				dao.addContact(contact);
			}
			contactsList= dao.listContacts();
			System.out.println("List of all Contacts (_"+contactsList.size()+"_)");
			contactsList.forEach(System.out::println);

		}
	}


