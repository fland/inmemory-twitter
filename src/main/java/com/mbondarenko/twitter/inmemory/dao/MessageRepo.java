package com.mbondarenko.twitter.inmemory.dao;

import com.mbondarenko.twitter.inmemory.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByUserOrderByPublishedDateDesc(String user);

    List<Message> findByUserInOrderByPublishedDateDesc(List<String> user);
}
