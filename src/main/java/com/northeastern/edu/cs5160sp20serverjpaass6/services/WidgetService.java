package com.northeastern.edu.cs5160sp20serverjpaass6.services;

import com.northeastern.edu.cs5160sp20serverjpaass6.models.Topic;
import com.northeastern.edu.cs5160sp20serverjpaass6.models.Widget;
import com.northeastern.edu.cs5160sp20serverjpaass6.repository.TopicRepository;
import com.northeastern.edu.cs5160sp20serverjpaass6.repository.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  @Autowired
  TopicRepository topicRepository;

  public Widget createWidget(Integer topicId, Widget widget) {
    Topic topic = topicRepository.findById(topicId).get();
    widget.setTopic(topic);
    return widgetRepository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(Integer topicId) {
    return widgetRepository.findWidgetsForTopic(topicId);
  }

  public int updateWidget(Integer widgetId, Widget widget) {
    Optional<Widget> widgetToUpdateFromDB = widgetRepository.findById(widgetId);

    if(widgetToUpdateFromDB.isPresent()) {
      Widget widgetToUpdate = widgetToUpdateFromDB.get();
      widgetToUpdate.setName(widget.getName());
      widgetToUpdate.setType(widget.getType());
      widgetToUpdate.setOrder_value(widget.getOrder_value());
      widgetToUpdate.setText(widget.getText());
      widgetToUpdate.setUrl(widget.getUrl());
      widgetToUpdate.setSize(widget.getSize());
      widgetToUpdate.setHeight(widget.getHeight());
      widgetToUpdate.setWidth(widget.getWidth());
      widgetToUpdate.setCssClass(widget.getCssClass());
      widgetToUpdate.setValue(widget.getValue());
      widgetToUpdate.setListType(widget.getListType());
      widgetRepository.save(widgetToUpdate);
      return 1;
    }

    return 0;
  }

  public int deleteWidget(Integer widgetId) {
    widgetRepository.deleteById(widgetId);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetId) {
    Optional<Widget> widget = widgetRepository.findById(widgetId);

    if(widget.isPresent()) {
      return widget.get();
    }

    return null;
  }

}
