package com.example.topic.domain.topic;

import com.example.topic.domain.response.ResponseTopicData;
import com.example.topic.domain.user.UserData;

public class TopicData {
        private String title;
        private String message;
        private String tag;
        private UserData user;
        private CourseData course;
        private ResponseTopicData responseTopic;

        // Getters and setters

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

        public String getTag() {
                return tag;
        }

        public void setTag(String tag) {
                this.tag = tag;
        }

        public UserData getUser() {
                return user;
        }

        public void setUser(UserData user) {
                this.user = user;
        }

        public CourseData getCourse() {
                return course;
        }

        public void setCourse(CourseData course) {
                this.course = course;
        }

        public ResponseTopicData getResponseTopic() {
                return responseTopic;
        }

        public void setResponseTopic(ResponseTopicData responseTopic) {
                this.responseTopic = responseTopic;
        }
}

