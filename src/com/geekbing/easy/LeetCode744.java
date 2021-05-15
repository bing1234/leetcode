package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int left = 0, right = letters.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        }
        mid = left + (right - left) / 2;
        if (letters[mid] > target) {
            return letters[mid];
        }
        if (letters[right] > target) {
            return letters[right];
        }
        return letters[0];
    }

    public static void main(String[] args) {
        LeetCode744 leetCode744 = new LeetCode744();
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println((char) leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
