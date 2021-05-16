package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode401 {
    private static final List<Integer> UPPER = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
    private static final List<Integer> DOWN = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 16, 32));

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        // 上面的LED从0个到turnedOn个亮起
        for (int i = 0; i <= UPPER.size(); i++) {
            for (int j = 0; j <= DOWN.size(); j++) {
                if (i + j == turnedOn) {
                    List<String> ups = getUpOrDown(true, i);
                    if (ups.size() > 0) {
                        List<String> downs = getUpOrDown(false, j);
                        if (downs.size() > 0) {
                            for (String up : ups) {
                                for (String down : downs) {
                                    ans.add(up + ":" + down);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private List<String> getUpOrDown(boolean up, int turnedOn) {
        List<String> ans = new ArrayList<>();
        if (turnedOn == 0) {
            ans.add(up ? "0" : "00");
            return ans;
        }
        List<List<Integer>> combines = combine(up ? UPPER : DOWN, turnedOn);
        for (List<Integer> combine : combines) {
            int sum = 0;
            for (Integer item : combine) {
                sum += item;
            }
            if (up) {
                if (sum <= 11) {
                    ans.add(String.valueOf(sum));
                }
            } else {
                if (sum <= 59) {
                    ans.add(sum < 10 ? "0" + sum : String.valueOf(sum));
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> combine(List<Integer> nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 0 || nums.size() < k) {
            return ans;
        }
        if (k == 1) {
            for (int num : nums) {
                List<Integer> item = new ArrayList<>(Collections.singletonList(num));
                ans.add(item);
            }
            return ans;
        }
        // 要么在前 nums.size-1 个元素中选择k-1个元素, 然后所有结果后面加上nums[nums.size - 1]
        List<List<Integer>> subs = combine(nums.subList(0, nums.size() - 1), k - 1);
        if (subs.size() > 0) {
            for (List<Integer> sub : subs) {
                sub.add(nums.get(nums.size() - 1));
                ans.add(sub);
            }
        }
        // 要么在前n-1个元素中选择k个
        List<List<Integer>> subs2 = combine(nums.subList(0, nums.size() - 1), k);
        if (subs2.size() > 0) {
            ans.addAll(subs2);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode401 leetCode401 = new LeetCode401();

//        System.out.println(leetCode401.combine(UPPER, 2));
        System.out.println(leetCode401.readBinaryWatch(1));
        System.out.println(leetCode401.readBinaryWatch(9));
    }
}
