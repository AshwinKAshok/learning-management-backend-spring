package com.northeastern.edu.cs5160sp20serverjpaass6.controllers;

import com.northeastern.edu.cs5160sp20serverjpaass6.models.Widget;
import com.northeastern.edu.cs5160sp20serverjpaass6.services.WidgetService;

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
public class WidgetController {

  @Autowired
  WidgetService widgetService;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetTest(@RequestBody Widget widget, @PathVariable("tid") Integer topicId) {
    return widgetService.createWidget( topicId , widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer topicId) {
    return widgetService.findWidgetsForTopic(topicId);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget widget) {
    return widgetService.updateWidget(widgetId, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(@PathVariable("wid") Integer widgetId) {
    return widgetService.deleteWidget(widgetId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return widgetService.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Integer widgetId) {
    return widgetService.findWidgetById(widgetId);
  }

}