package com.example.topic.controller;

import com.example.topic.domain.topic.*;
import com.example.topic.infra.errors.DuplicateTopicException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicRepository topicRepository;

    @Operation(summary = "Create a new topic")
    @PostMapping
    public ResponseEntity<String> newTopic(@RequestBody @Valid TopicData newTopicData) {
        try {
            topicService.saveTopic(newTopicData);
            return ResponseEntity.status(HttpStatus.CREATED).body("Topic created successfully.");
        } catch (DuplicateTopicException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @Operation(summary = "Get a list of topics")
    @GetMapping
    public Page<TopicListData> topicList(@PageableDefault(size = 10) Pageable pagination) {
        return topicRepository.findAll(pagination).map(TopicListData::new);
    }

    @Operation(summary = "Update a topic")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topic> updateTopic(@PathVariable int id, @RequestBody @Valid TopicData updatedTopicData) {
        Topic updatedTopic = topicService.updateTopic(id, updatedTopicData);
        return ResponseEntity.ok(updatedTopic);
    }

    @Operation(summary = "Delete a topic")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Topic> deleteTopic(@PathVariable Integer id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Find a topic by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Topic> findByIdTopic(@PathVariable Integer id) {
        Topic topic = topicService.findByIdTopic(id);
        return ResponseEntity.ok(topic);
    }
}
