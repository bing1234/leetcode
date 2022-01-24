package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com")));
        ans.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        ans.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        return ans;
    }

    private static class UnionFind {

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

    @Test
    public void testCase1() {
        LeetCode721 leetCode721 = new LeetCode721();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));

        List<List<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com")));
        ans.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        ans.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));

        assert leetCode721.accountsMerge(accounts).equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode721 leetCode721 = new LeetCode721();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")));

        List<List<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co")));
        ans.add(new ArrayList<>(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co")));
        ans.add(new ArrayList<>(Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co")));
        ans.add(new ArrayList<>(Arrays.asList("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co")));
        ans.add(new ArrayList<>(Arrays.asList("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")));

        assert leetCode721.accountsMerge(accounts).equals(ans);
    }
}
