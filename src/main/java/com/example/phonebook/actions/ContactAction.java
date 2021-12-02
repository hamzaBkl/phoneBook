package com.example.phonebook.actions;

import com.example.phonebook.dao.ContactDao;
import com.example.phonebook.model.Contact;
import com.example.phonebook.service.ContactDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContactAction extends ActionSupport {

    private String pseudo;
    private String mail;
    private String codePostal;
    private LocalDate dateinscription;
    private String photo;
    ArrayList<Contact> contacts=new ArrayList<>();

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setDateinscription(LocalDate dateinscription) {
        this.dateinscription = dateinscription;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }


    public String getAll(){
        ContactDao dao=new ContactDaoImpl();
        contacts.addAll(dao.listContacts());

        return "success";
    }

    public String addContact(){
        ContactDao dao=new ContactDaoImpl();

        Contact contact=new Contact();
        contact.setPseudo(pseudo);
        contact.setCodePostal(codePostal);
        contact.setMail(mail);
        contact.setPhoto(photo);
        contact.setDateInscription(LocalDate.now());

        dao.addContact(contact);
        return "success";

    }

}
