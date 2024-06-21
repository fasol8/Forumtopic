package com.example.topic.domain.user;

import jakarta.persistence.*;

@Table(name = "profile")
@Entity(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private int idProfile;
    private String name;

    public Profile() {}

    public Profile(ProfileData profileData) {
        this.idProfile = profileData.getIdProfile();
        this.name = profileData.getName();
    }

    // Getters y setters
    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

