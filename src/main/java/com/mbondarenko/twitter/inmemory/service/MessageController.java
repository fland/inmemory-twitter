package com.mbondarenko.twitter.inmemory.service;

import com.mbondarenko.twitter.inmemory.dao.MessageRepo;
import com.mbondarenko.twitter.inmemory.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageRepo messageRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> get(@RequestParam String user) {
        return messageRepo.findByUserOrderByPublishedDateDesc(user);
    }
}
