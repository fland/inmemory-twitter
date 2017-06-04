package com.mbondarenko.twitter.inmemory.dao;

import com.mbondarenko.twitter.inmemory.model.Follower;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
public interface FollowerRepo extends CrudRepository<Follower, Long> {

    @Query("select f.followedUser from Follower f where f.user like ?1")
    List<String> findFollowedUsers(String user);
}
