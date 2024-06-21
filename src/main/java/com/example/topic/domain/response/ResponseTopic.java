package com.example.topic.domain.response;

import com.example.topic.domain.user.User;
import jakarta.persistence.*;

@Table(name = "response")
@Entity
public class ResponseTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_response")
    private int idResponse;
    private String message;
    private String date;
    private boolean solution;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public ResponseTopic() {}

    public ResponseTopic(ResponseTopicData responseTopicData) {
        this.idResponse=responseTopicData.getIdResponse();
        this.message = responseTopicData.getMessage();
        this.date = responseTopicData.getDate();
        if (responseTopicData.getSolution() != null) {
            this.solution = responseTopicData.getSolution();
        } else {
            this.solution = false;
        }
        this.user = new User(responseTopicData.getUser());
    }

    // Getters y setters
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

    public boolean isSolution() {
        return solution;
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
