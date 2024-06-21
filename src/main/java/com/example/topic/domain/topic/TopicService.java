package com.example.topic.domain.topic;

import com.example.topic.domain.response.ResponseTopic;
import com.example.topic.domain.user.User;
import com.example.topic.infra.errors.DuplicateTopicException;
import com.example.topic.infra.errors.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public void saveTopic(TopicData newTopicData) {
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(newTopicData.getTitle(), newTopicData.getMessage());
        if (existingTopic.isPresent()) {
            throw new DuplicateTopicException("A topic with the same title and message already exists.");
        }

        Topic topic = new Topic(newTopicData);
        topicRepository.save(topic);
    }

    public Page<Topic> findAll(Pageable pagination) {
        return topicRepository.findAll(pagination);
    }

    @Transactional
    public Topic updateTopic(int id, TopicData updatedTopicData) {
        Topic existingTopic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));

        // Update fields with new data
        existingTopic.setTitle(updatedTopicData.getTitle());
        existingTopic.setMessage(updatedTopicData.getMessage());
        existingTopic.setDate(LocalDate.now().toString());
        existingTopic.setTag(updatedTopicData.getTag());

        // Update related entities
        existingTopic.setUser(new User(updatedTopicData.getUser()));
        existingTopic.setCourse(new Course(updatedTopicData.getCourse()));
        existingTopic.setResponseTopic(new ResponseTopic(updatedTopicData.getResponseTopic()));

        // Save updated topic
        return topicRepository.save(existingTopic);
    }

    @Transactional
    public void deleteTopic(int id) {
        Topic existingTopic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        topicRepository.delete(existingTopic);
    }


    public Topic findByIdTopic(Integer id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id " + id));
    }
}
