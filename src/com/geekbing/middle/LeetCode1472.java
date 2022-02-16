package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1472 {
    private static class BrowserHistory {
        private final List<String> urls;
        private int idx, capacity;

        public BrowserHistory(String homepage) {
            urls = new ArrayList<>(Collections.singletonList(homepage));
            idx = 0;
            capacity = 1;
        }

        public void visit(String url) {
            if (idx == urls.size() - 1) {
                urls.add(url);
                idx++;
                capacity++;
            } else {
                idx++;
                urls.set(idx, url);
                capacity = idx + 1;
            }
        }

        public String back(int steps) {
            idx -= steps;
            if (idx < 0) {
                idx = 0;
            }
            return urls.get(idx);
        }

        public String forward(int steps) {
            idx += steps;
            if (idx >= capacity) {
                idx = capacity - 1;
            }
            return urls.get(idx);
        }
    }

    @Test
    public void testCase1() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        assert browserHistory.back(1).equals("facebook.com");                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        assert browserHistory.back(1).equals("google.com");                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        assert browserHistory.forward(1).equals("facebook.com");                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        assert browserHistory.forward(2).equals("linkedin.com");                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        assert browserHistory.back(2).equals("google.com");                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        assert browserHistory.back(7).equals("leetcode.com");                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}
