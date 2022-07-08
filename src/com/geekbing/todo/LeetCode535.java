package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author bing
 */
public class LeetCode535 {
    private static class Codec {
        private static final String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        private static final String prefix = "http://tinyurl.com/";
        /**
         * 短-长
         */
        private final Map<String, String> map = new HashMap<>();

        private final Random random = new Random();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = geneRandomStr();
            while (map.containsKey(shortUrl)) {
                shortUrl = geneRandomStr();
            }
            map.put(shortUrl, longUrl);
            return prefix + shortUrl;
        }

        private String geneRandomStr() {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                str.append(base.charAt(random.nextInt(base.length())));
            }
            return str.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl.substring(prefix.length()));
        }
    }

    @Test
    public void testCase1() {
        Codec codec = new Codec();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = codec.encode(longUrl);
        assert codec.decode(shortUrl).equals(longUrl);
    }
}
