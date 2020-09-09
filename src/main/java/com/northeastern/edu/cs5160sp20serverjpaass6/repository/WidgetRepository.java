package com.northeastern.edu.cs5160sp20serverjpaass6.repository;





import com.northeastern.edu.cs5160sp20serverjpaass6.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  //Query for finding all widgets of a given topic
//  @Query(value = "SELECT * FROM widgets WHERE topic_id =:tid ", nativeQuery = true)
  @Query("SELECT widget FROM Widget widget WHERE widget.topic.id =:tid")
  public List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);
}
