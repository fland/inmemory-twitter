package com.mbondarenko.twitter.inmemory.model;

import javax.persistence.*;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "followedUser"})})
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String followedUser;

    protected Follower() {
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getFollowedUser() {
        return followedUser;
    }
}
