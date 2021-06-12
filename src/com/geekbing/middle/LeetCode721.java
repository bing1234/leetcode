package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return new ArrayList<>();
    }

    private static class DisjointSetUnion {

    }

    private static class Account {
        private String name;
        private List<String> mail;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getMail() {
            return mail;
        }

        public void setMail(List<String> mail) {
            this.mail = mail;
        }
    }

    public static void main(String[] args) {
        LeetCode721 leetCode721 = new LeetCode721();

        List<List<String>> case1 = new ArrayList<>();
        case1.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        case1.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        case1.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        System.out.println(leetCode721.accountsMerge(case1));
    }
}
