package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode468 {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() == 0 || queryIP.startsWith(".") || queryIP.endsWith(".") || queryIP.startsWith(":") || queryIP.endsWith(":")) {
            return "Neither";
        }
        if (queryIP.contains(".")) {
            return isIpV4(queryIP) ? "IPv4" : "Neither";
        }
        return isIpV6(queryIP) ? "IPv6" : "Neither";
    }

    private boolean isIpV4(String ip) {
        String[] items = ip.split("\\.");
        if (items.length != 4) {
            return false;
        }
        for (String item : items) {
            if (item.length() < 1 || item.length() > 3 || (item.length() > 1 && item.charAt(0) == '0')) {
                return false;
            }
            try {
                int num = Integer.parseInt(item);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }


    private boolean isIpV6(String ip) {
        String[] items = ip.split(":");
        if (items.length != 8) {
            return false;
        }
        for (String item : items) {
            if (item.length() < 1 || item.length() > 4) {
                return false;
            }
            for (char c : item.toCharArray()) {
                if (!(Character.isDigit(c) || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("172.16.254.1").equals("IPv4");
    }

    @Test
    public void testCase2() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334").equals("IPv6");
    }

    @Test
    public void testCase3() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("256.256.256.256").equals("Neither");
    }

    @Test
    public void testCase4() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:").equals("Neither");
    }

    @Test
    public void testCase5() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("12..33.4").equals("Neither");
    }

    @Test
    public void testCase6() {
        LeetCode468 leetCode468 = new LeetCode468();
        assert leetCode468.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334").equals("Neither");
    }
}
