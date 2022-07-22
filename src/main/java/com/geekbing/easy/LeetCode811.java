package com.geekbing.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String cpDomain : cpdomains) {
            String[] items = cpDomain.split(" ");

            Integer count = Integer.parseInt(items[0]);
            String[] subItems = items[1].split("\\.");
            if (subItems.length == 1) {
                countMap.merge(items[1], count, Integer::sum);
            } else if (subItems.length == 2) {
                countMap.merge(subItems[1], count, Integer::sum);
                countMap.merge(subItems[0] + "." + subItems[1], count, Integer::sum);
            } else {
                countMap.merge(subItems[2], count, Integer::sum);
                countMap.merge(subItems[1] + "." + subItems[2], count, Integer::sum);
                countMap.merge(items[1], count, Integer::sum);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String key : countMap.keySet()) {
            ans.add(countMap.get(key) + " " + key);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode811 leetCode811 = new LeetCode811();
        System.out.println(leetCode811.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(leetCode811.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
