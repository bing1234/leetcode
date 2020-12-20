package com.geekbing.easy;

public class LeetCode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int path = 0, sum = 0;
        int i = start;
        while (i != destination) {
            if (i == distance.length) {
                i = 0;
            } else {
                path += distance[i];
                sum += distance[i];
                i++;
            }
        }
        while (i != start) {
            if (i == distance.length) {
                i = 0;
            } else {
                sum += distance[i];
                i++;
            }
        }
        return Math.min(path, sum - path);
    }

    public static void main(String[] args) {
        LeetCode1184 leetCode1184 = new LeetCode1184();
        System.out.println(leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
    }
}
