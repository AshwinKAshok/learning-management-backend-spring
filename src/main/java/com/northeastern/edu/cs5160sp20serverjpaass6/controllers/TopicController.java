package com.northeastern.edu.cs5160sp20serverjpaass6.controllers;


import com.northeastern.edu.cs5160sp20serverjpaass6.models.Topic;
import com.northeastern.edu.cs5160sp20serverjpaass6.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

  @Autowired
  TopicService topicService;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/topics/{tid}")
  public Topic findTopicById(@PathVariable("tid") Integer topicId) {
    return topicService.findTopicById(topicId);
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(
          @PathVariable("lessonId") String lessonId
  ) {
    return topicService.findTopicsForLesson(lessonId);
  }

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopic(@PathVariable("lid") String lessonId, @RequestBody Topic topic) {
    return topicService.createTopic(lessonId, topic);
  }

  @DeleteMapping("/api/topics/{tid}")
  public int deleteTopic(@PathVariable("tid") Integer topicId) {
    return topicService.deleteTopic(topicId);
  }

  @PutMapping("/api/topics/{tid}")
  public int updateTopic(@PathVariable("tid") Integer topicId, @RequestBody Topic topic) {
    return topicService.updateTopic(topicId, topic);
  }

}
