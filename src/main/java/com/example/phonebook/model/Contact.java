package com.example.phonebook.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "contact")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "pseudo", length = 30)
    private String pseudo;

    @Column(name = "mail", length = 30)
    private String mail;

    @Column(name = "codePostal", length = 10)
    private String codePostal;

    @Column(name = "dateinscription")
    private LocalDate dateInscription;

    @Column(name = "photo", length = 100)
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "Contact ("+id+") "+pseudo+" : "+mail+" ,"+codePostal;
    }
}