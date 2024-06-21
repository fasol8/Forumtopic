package com.example.topic.domain.topic;

import com.example.topic.domain.response.ResponseTopic;
import com.example.topic.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "topic")
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topic")
    private int idTopic;
    private String title;
    private String message;
    private String date;
    private String tag;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "id_response")
    private ResponseTopic responseTopic;

    public Topic() {
    }

    public Topic(TopicData newTopicData) {
        this.title = newTopicData.getTitle();
        this.message = newTopicData.getMessage();
        this.date = LocalDate.now().toString();
        this.tag = newTopicData.getTag();
        this.user = new User(newTopicData.getUser());
        this.course = new Course(newTopicData.getCourse());
        this.responseTopic = new ResponseTopic(newTopicData.getResponseTopic());
    }

    // Getters y setters
    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ResponseTopic getResponseTopic() {
        return responseTopic;
    }

    public void setResponseTopic(ResponseTopic responseTopic) {
        this.responseTopic = responseTopic;
    }


}

