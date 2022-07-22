package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum == 0) {
                    if (ans.size() != 0) {
                        List<Integer> last = ans.get(ans.size() - 1);
                        if (last.get(1) == nums[left] && last.get(2) == nums[right]) {
                            left++;
                            right--;
                            continue;
                        }
                    }
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        System.out.println(leetCode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(leetCode15.threeSum(new int[]{0, 0, 0, 0, 0, 0}));
    }
}
