package com.demo.mapper;

import com.demo.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TopicMapper {
    List<Topic> findAll();

    Topic findById(int id);

    Map<String,Object> findByIdMap(int id);

    List<Topic> findByname(String name);


    List<Topic> findByTopicName(@Param("topicname") String topicname);

}
