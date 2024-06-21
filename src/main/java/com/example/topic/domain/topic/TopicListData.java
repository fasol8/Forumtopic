package com.example.topic.domain.topic;

public record TopicListData(int idTopic, String title, String message, String date, String tag, Course course) {

    public TopicListData(Topic topic) {
        this(topic.getIdTopic(), topic.getTitle(), topic.getMessage(), topic.getDate(), topic.getTag(), topic.getCourse());
    }
}
