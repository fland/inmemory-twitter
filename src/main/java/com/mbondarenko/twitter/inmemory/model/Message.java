package com.mbondarenko.twitter.inmemory.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    @CreationTimestamp
    private Date publishedDate;

    @Column(length = 140)
    private String messageText;

    public Message(String user, String messageText) {
        this.user = user;
        this.messageText = messageText;
    }

    protected Message() {
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public String getMessageText() {
        return messageText;
    }
}
