package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeetCode535 {
    private final Map<String, String> map = new HashMap<>();
    private final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Random rand = new Random();

    private String getRandKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            key.append(alphabet.charAt(rand.nextInt(62)));
        }
        return key.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getRandKey();
        while (map.containsKey(key)) {
            key = getRandKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    public static void main(String[] args) {
        LeetCode535 leetCode535 = new LeetCode535();
        String key = leetCode535.encode("aaa");
        System.out.println(leetCode535.decode(key));
    }
}
