package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }

        ans.add(new ArrayList<>(Collections.singletonList(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);

            List<Integer> last = ans.get(ans.size() - 1);
            for (int j = 0; j < last.size() - 1; j++) {
                cur.add(last.get(j) + last.get(j + 1));
            }

            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode118 leetCode118 = new LeetCode118();
        System.out.println(leetCode118.generate(5));
    }
}
