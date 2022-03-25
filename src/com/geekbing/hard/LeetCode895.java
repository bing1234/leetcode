package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode895 {
    private static class FreqStack {
        private final Map<Integer, Integer> freq;
        private final Map<Integer, Stack<Integer>> group;
        private int maxFreq;

        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int f = freq.getOrDefault(val, 0) + 1;
            freq.put(val, f);
            if (f > maxFreq) {
                maxFreq = f;
            }
            Stack<Integer> stack = group.getOrDefault(f, new Stack<>());
            stack.push(val);
            group.put(f, stack);
        }

        public int pop() {
            int ans = group.get(maxFreq).pop();
            freq.put(ans, freq.get(ans) - 1);
            if (group.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            return ans;
        }
    }

    @Test
    public void testCase1() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);//堆栈为 [5]
        freqStack.push(7);//堆栈是 [5,7]
        freqStack.push(5);//堆栈是 [5,7,5]
        freqStack.push(7);//堆栈是 [5,7,5,7]
        freqStack.push(4);//堆栈是 [5,7,5,7,4]
        freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
        int ans = freqStack.pop();
        assert ans == 5;//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        ans = freqStack.pop();
        assert ans == 7;//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        ans = freqStack.pop();
        assert ans == 5;//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        ans = freqStack.pop();
        assert ans == 4;//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
    }
}
