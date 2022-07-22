package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> threeSum = findThreeSum(nums, i + 1, target - nums[i]);
            if (threeSum.isEmpty()) {
                continue;
            }
            for (List<Integer> item : threeSum) {
                List<Integer> list = new ArrayList<>(item);
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }

    private List<List<Integer>> findThreeSum(int[] nums, int begin, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = begin; i < nums.length - 1; i++) {
            if (i != begin && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum == target) {
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
        LeetCode18 leetCode18 = new LeetCode18();
        System.out.println(leetCode18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(leetCode18.fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(leetCode18.fourSum(new int[]{0, 0, 0, 0, 0, 0}, 0));
        System.out.println(leetCode18.fourSum(new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5}, 0));
    }
}
