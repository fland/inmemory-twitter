package com.mbondarenko.twitter.inmemory.service;

import com.mbondarenko.twitter.inmemory.dao.FollowerRepo;
import com.mbondarenko.twitter.inmemory.model.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@RestController
public class FollowerController {

    @Autowired
    FollowerRepo followerRepo;

    @RequestMapping(value = "/follower", method = RequestMethod.POST)
    public Follower follow(@RequestBody Follower follower) {
        return followerRepo.save(follower);
    }

    @RequestMapping(value = "/follower", method = RequestMethod.GET)
    public List<String> getFollowed(@RequestParam String user) {
        return followerRepo.findFollowedUsers(user);
    }
}
