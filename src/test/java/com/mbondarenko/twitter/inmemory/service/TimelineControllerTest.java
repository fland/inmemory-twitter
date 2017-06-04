package com.mbondarenko.twitter.inmemory.service;

import com.google.common.collect.ImmutableList;
import com.mbondarenko.twitter.inmemory.dao.FollowerRepo;
import com.mbondarenko.twitter.inmemory.dao.MessageRepo;
import com.mbondarenko.twitter.inmemory.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;

/**
 * @author Maxim Bondarenko
 * @version 1.0 04.06.17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimelineControllerTest {

    @MockBean
    private MessageRepo messageRepoMock;

    @MockBean
    private FollowerRepo followerRepoMock;

    @Autowired
    private TimelineController timelineController;

    @Test
    public void testGetEmptyFollowers() {
        String testUser = "max";
        given(followerRepoMock.findFollowedUsers(eq(testUser))).willReturn(ImmutableList.of());
        List<Message> actualResult = timelineController.get(testUser);
        assertThat(actualResult).isEmpty();
    }

    @Test
    public void testGetFollowersNoPosts() {
        String testUser = "max";
        List<String> followedUsers = ImmutableList.of("peter", "james");
        given(followerRepoMock.findFollowedUsers(eq(testUser))).willReturn(followedUsers);
        given(messageRepoMock.findByUserInOrderByPublishedDateDesc(eq(followedUsers))).willReturn(ImmutableList.of());
        List<Message> actualResult = timelineController.get(testUser);
        assertThat(actualResult).isEmpty();
    }

    @Test
    public void testGetFollowersWithPosts() {
        String testUser = "max";
        List<String> followedUsers = ImmutableList.of("peter", "james");
        List<Message> posts = ImmutableList.of(new Message("peter", "peters message"),
                new Message("james", "james message"));
        given(followerRepoMock.findFollowedUsers(eq(testUser))).willReturn(followedUsers);
        given(messageRepoMock.findByUserInOrderByPublishedDateDesc(eq(followedUsers))).willReturn(posts);
        List<Message> actualResult = timelineController.get(testUser);
        assertThat(actualResult).containsAllIn(posts);
    }

}