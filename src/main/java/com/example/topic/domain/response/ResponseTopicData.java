package com.example.topic.domain.response;

import com.example.topic.domain.user.UserData;

public class ResponseTopicData{

        private int idResponse;
        private String message;
        private String date;
        private Boolean solution;
        private UserData user;

        public int getIdResponse() {
                return idResponse;
        }

        public void setIdResponse(int idResponse) {
                this.idResponse = idResponse;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public Boolean getSolution() {
                return solution;
        }

        public void setSolution(Boolean solution) {
                this.solution = solution;
        }

        public UserData getUser() {
                return user;
        }

        public void setUser(UserData user) {
                this.user = user;
        }
}
