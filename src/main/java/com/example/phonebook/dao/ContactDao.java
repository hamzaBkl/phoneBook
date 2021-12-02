package com.example.phonebook.dao;

import com.example.phonebook.model.Contact;

import java.util.List;

public interface ContactDao {
    void addContact(Contact contact);
    void updateContact(Contact contact);
    List<Contact> listContacts();
    List<Contact> selectContactByKeyword(String keyword);
    Contact getContactById(int id);
    void removeContact(long id);

}
