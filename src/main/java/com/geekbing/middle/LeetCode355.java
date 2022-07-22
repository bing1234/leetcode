package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode355 {
    private static class Twitter {
        /**
         * 用户ID-用户ID自己发的Twitter
         */
        private Map<Integer, List<Integer>> userTweet;

        /**
         * 用户ID-用户ID所有关注的人
         */
        private Map<Integer, Set<Integer>> userFollow;

        /**
         * 用户ID-用户ID所有被关注的人
         */
        private Map<Integer, Set<Integer>> userBeFollow;

        public Twitter() {
            userTweet = new HashMap<>();
            userFollow = new HashMap<>();
            userBeFollow = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            // 用户自己的
            userTweet.computeIfAbsent(userId, f -> new ArrayList<>()).add(tweetId);

            Set<Integer> userBeFollowedIds = userBeFollow.getOrDefault(userId, new HashSet<>());
            for (Integer userBeFollowedId : userBeFollowedIds) {

            }
        }

        public List<Integer> getNewsFeed(int userId) {
            return new ArrayList<>();
        }

        public void follow(int followerId, int followeeId) {
            userFollow.computeIfAbsent(followerId, f -> new HashSet<>()).add(followeeId);
            userBeFollow.computeIfAbsent(followeeId, f -> new HashSet<>()).add(followerId);
        }

        public void unfollow(int followerId, int followeeId) {
            userFollow.computeIfAbsent(followerId, f -> new HashSet<>()).remove(followeeId);
            userBeFollow.computeIfAbsent(followeeId, f -> new HashSet<>()).remove(followerId);
        }
    }

    @Test
    public void testCase1() {
        Twitter twitter = new Twitter();

        // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        twitter.postTweet(1, 5);

        // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        assert twitter.getNewsFeed(1).equals(new ArrayList<>(Collections.singletonList(5)));

        // 用户 1 关注了用户 2
        twitter.follow(1, 2);

        // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.postTweet(2, 6);

        // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        assert twitter.getNewsFeed(1).equals(new ArrayList<>(Arrays.asList(6, 5)));

        // 用户 1 取消关注了用户 2
        twitter.unfollow(1, 2);

        // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
        assert twitter.getNewsFeed(1).equals(new ArrayList<>(Collections.singletonList(5)));
    }
}
