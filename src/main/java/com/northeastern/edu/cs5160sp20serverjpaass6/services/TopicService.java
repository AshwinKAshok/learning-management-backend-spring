package com.northeastern.edu.cs5160sp20serverjpaass6.services;




import com.northeastern.edu.cs5160sp20serverjpaass6.models.Topic;
import com.northeastern.edu.cs5160sp20serverjpaass6.repository.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;

  public List<Topic> findTopicsForLesson(String lid) {
    return topicRepository.findTopicsForLesson(lid);
  }

  public Topic findTopicById(Integer topicId) {
     Optional<Topic> topic = topicRepository.findById(topicId);

     if(topic.isPresent()) {
       return topic.get();
     }

     return null;
  }

  public List<Topic> findAllTopics() {
    return (List<Topic>)topicRepository.findAll();
  }

  public Topic createTopic(String lessonId, Topic topic) {
    topic.setLessonId(lessonId);
    return topicRepository.save(topic);
  }

  public int deleteTopic(Integer topicId) {
    topicRepository.deleteById(topicId);
    return 1;
  }

  public int updateTopic(Integer topicId, Topic topic) {
    Optional<Topic> topicToUpdateFromDB = topicRepository.findById(topicId);


    if(topicToUpdateFromDB.isPresent()) {
      Topic topicToUpdate = topicToUpdateFromDB.get();
//      topicToUpdate.setLessonId(topic.getLessonId());
      topicToUpdate.setDescription(topic.getDescription());
      topicToUpdate.setTitle(topic.getTitle());
      topicRepository.save(topicToUpdate);
      return 1;
    }
    return 0;
  }
}
