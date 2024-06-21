package com.example.topic.domain.user;

public class UserData {
        private int idUser;
        private String name;
        private String mail;
        private String password;
        private ProfileData profile;

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

        public ProfileData getProfile() {
                return profile;
        }

        public void setProfile(ProfileData profile) {
                this.profile = profile;
        }
}
