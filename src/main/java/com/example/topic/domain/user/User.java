package com.example.topic.domain.user;

import jakarta.persistence.*;

@Table(name = "user")
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    private String name;
    private String mail;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    public User() {
    }

    public User(UserData userData) {
        this.idUser = userData.getIdUser();
        this.name = userData.getName();
        this.mail = userData.getMail();
        this.password = userData.getPassword();
        if (userData.getProfile() != null) {
            this.profile = new Profile(userData.getProfile());
        } else {
            this.profile = null; // or handle the default profile initialization
        }
    }

    // Getters y setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
