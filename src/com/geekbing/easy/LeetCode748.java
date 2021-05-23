package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int[] bucket = countBucket(licensePlate);
        for (String word : words) {
            int[] wordBucket = countBucket(word);
            if (canCover(bucket, wordBucket) && word.length() < minLen) {
                ans = word;
                minLen = word.length();
            }
        }
        return ans;
    }

    private int[] countBucket(String str) {
        int[] bucket = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if ('a' <= c && c <= 'z') {
                bucket[c - 'a']++;
            }
            if ('A' <= c && c <= 'Z') {
                bucket[c - 'A']++;
            }
        }
        return bucket;
    }

    private boolean canCover(int[] bucket, int[] wordBucket) {
        for (int i = 0; i < bucket.length; i++) {
            if (wordBucket[i] < bucket[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode748 leetCode748 = new LeetCode748();

        System.out.println(leetCode748.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(leetCode748.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
        System.out.println(leetCode748.shortestCompletingWord("Ah71752", new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"}));
        System.out.println(leetCode748.shortestCompletingWord("OgEu755", new String[]{"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"}));
        System.out.println(leetCode748.shortestCompletingWord("iMSlpe4", new String[]{"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"}));
    }
}
