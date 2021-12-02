package com.example.phonebook.service;

import com.example.phonebook.dao.ContactDao;
import com.example.phonebook.model.Contact;
import com.example.phonebook.util.HibernateUtil;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContactDaoImpl implements ContactDao {
	
	private static final Logger logger = Logger.getLogger(ContactDaoImpl.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	} 
	
	@Override
	public void addContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
		logger.info("Contact saved successfully, Contact Details="+contact);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContacts() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Contact> CategoriesList = session.createQuery("from Contact").list();
		session.getTransaction().commit();
		return CategoriesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> selectContactByKeyword(String keyword) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Contact> CategoriesList = session.createQuery("from Contact c WHERE c.nameCat LIKE '%"+keyword+"%'").list();
		session.getTransaction().commit();
		
		return CategoriesList;
	}
	@Override
	public Contact getContactById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		session.beginTransaction();
		Contact contact = session.load(Contact.class, id);
		session.getTransaction().commit();
		//logger.info("Contact loaded successfully, Contact details="+contact);
		return contact;
	}

	@Override
	public void removeContact(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Contact contact = session.load(Contact.class, id);
		
		if(null != contact){
			session.delete(contact);
		}
		session.getTransaction().commit();
		logger.info("Contact deleted successfully, Contact details="+contact);
	}

	@Override
	public void updateContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(contact);
		session.getTransaction().commit();
		logger.info("Contact updated successfully, Contact Details="+contact);
		
	}


}
