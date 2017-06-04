package com.mbondarenko.twitter.inmemory.service;

import com.mbondarenko.twitter.inmemory.dao.FollowerRepo;
import com.mbondarenko.twitter.inmemory.dao.MessageRepo;
import com.mbondarenko.twitter.inmemory.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@RestController
public class TimelineController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private FollowerRepo followerRepo;

    @RequestMapping(value = "/timeline")
    public List<Message> get(@RequestParam String user) {
        List<String> followedUsers = followerRepo.findFollowedUsers(user);
        if (followedUsers.isEmpty()) {
            return Collections.emptyList();
        }

        return messageRepo.findByUserInOrderByPublishedDateDesc(followedUsers);
    }
}
