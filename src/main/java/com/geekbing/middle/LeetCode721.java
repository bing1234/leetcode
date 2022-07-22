package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = i + 1; j < accounts.size(); j++) {
                // 如果邮箱有相同的，则可以直接合并
                if (hasSameEmail(accounts.get(i), accounts.get(j))) {
                    unionFind.union(i, j);
                }
            }
        }

        // 按照root进行分组
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int p = unionFind.find(i);
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(i);
            map.put(p, list);
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<Integer> indexes : map.values()) {
            ans.add(getAllSortedEmails(accounts, indexes));
        }
        return ans;
    }

    private List<String> getAllSortedEmails(List<List<String>> accounts, List<Integer> indexes) {
        Set<String> emails = new HashSet<>();
        for (Integer index : indexes) {
            List<String> line = accounts.get(index);
            emails.addAll(line.subList(1, line.size()));
        }
        // 所有邮箱排序
        List<String> account = emails.stream().sorted().collect(Collectors.toList());
        // 最前面添加账户名
        account.add(0, accounts.get(indexes.get(0)).get(0));
        return account;
    }

    private boolean hasSameEmail(List<String> list1, List<String> list2) {
        List<String> temp1 = list1.subList(1, list1.size());
        List<String> temp2 = list2.subList(1, list2.size());
        temp1.sort(String::compareTo);
        temp2.sort(String::compareTo);
        int idx1 = 0, idx2 = 0;
        while (idx1 < temp1.size() && idx2 < temp2.size()) {
            int flag = temp1.get(idx1).compareTo(temp2.get(idx2));
            if (flag < 0) {
                idx1++;
            } else if (flag > 0) {
                idx2++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(weight, 1);
        }

        private int find(int i) {
            return i == parent[i] ? i : find(parent[i]);
        }

        private void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (weight[rootI] < weight[rootJ]) {
                    parent[rootI] = rootJ;
                    weight[rootJ] += weight[rootI];
                } else {
                    parent[rootJ] = rootI;
                    weight[rootI] += rootJ;
                }
            }
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

        List<List<String>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com")));
        expect.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        expect.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));

        List<List<String>> ans = leetCode721.accountsMerge(accounts);
        ans.sort(Comparator.comparing(o -> o.get(0)));
        expect.sort(Comparator.comparing(o -> o.get(0)));
        assert expect.equals(ans);
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

        List<List<String>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(Arrays.asList("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co")));
        expect.add(new ArrayList<>(Arrays.asList("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co")));
        expect.add(new ArrayList<>(Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co")));
        expect.add(new ArrayList<>(Arrays.asList("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co")));
        expect.add(new ArrayList<>(Arrays.asList("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")));

        List<List<String>> ans = leetCode721.accountsMerge(accounts);
        ans.sort(Comparator.comparing(o -> o.get(0)));
        expect.sort(Comparator.comparing(o -> o.get(0)));
        assert expect.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode721 leetCode721 = new LeetCode721();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("David", "Avid0@m.co", "David0@m.co", "David1@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David", "Gvid3@m.co", "David3@m.co", "David4@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David", "David4@m.co", "David5@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David", "David2@m.co", "David3@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David", "David1@m.co", "David2@m.co")));

        List<List<String>> expect = new ArrayList<>();
        expect.add(new ArrayList<>(Arrays.asList("David", "Avid0@m.co", "David0@m.co", "David1@m.co", "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co", "Gvid3@m.co")));

        List<List<String>> ans = leetCode721.accountsMerge(accounts);
        ans.sort(Comparator.comparing(o -> o.get(0)));
        expect.sort(Comparator.comparing(o -> o.get(0)));
        assert expect.equals(ans);
    }
}
