package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1656 {
    private static class OrderedStream {
        private int ptr = 1;
        private final String[] streamContent;

        public OrderedStream(int n) {
            streamContent = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            streamContent[idKey] = value;
            if (streamContent[ptr] == null) {
                return new ArrayList<>();
            } else {
                List<String> ans = new ArrayList<>();
                while (ptr < streamContent.length) {
                    if (streamContent[ptr] == null) {
                        break;
                    }
                    ans.add(streamContent[ptr]);
                    ptr++;
                }
                return ans;
            }
        }
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // 插入 (3, "ccccc")，返回 []
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}
