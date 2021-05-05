package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0], maxIdx = 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > max) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                maxIdx = i;
            } else if (releaseTimes[i] - releaseTimes[i - 1] == max) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                maxIdx = keysPressed.charAt(i) > keysPressed.charAt(maxIdx) ? i : maxIdx;
            }
        }
        return keysPressed.charAt(maxIdx);
    }

    public static void main(String[] args) {
        LeetCode1629 leetCode1629 = new LeetCode1629();
        System.out.println(leetCode1629.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(leetCode1629.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }
}
