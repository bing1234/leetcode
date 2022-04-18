package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode157 {
    public static class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int idx = 0;
            while (idx < n) {
                int len = read4(buf4);
                for (int i = 0; i < len; i++) {
                    buf[idx++] = buf4[i];
                    if (idx == n) {
                        return idx;
                    }
                }
                if (len < 4){
                    return idx;
                }
            }
            return n;
        }
    }

    public static class Reader4 {
        public int read4(char[] buf4) {
            return 0;
        }
    }
}
