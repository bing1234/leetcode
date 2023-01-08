package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author bing
 */
public class LeetCode855 {
    public static class ExamRoom {
        private int people;
        private int[] seats;

        public ExamRoom(int n) {
            seats = new int[n];
            people = 0;
        }

        public int seat() {
            if (people == 0) {
                seats[0] = 1;
                people++;
                return 0;
            }
            if (people == 1) {
                seats[seats.length - 1] = 1;
                people++;
                return seats.length - 1;
            }
            int pre = -1;

            return 0;
        }

        public void leave(int p) {
            seats[p] = 0;
            people--;
        }
    }

    @Test
    public void testCase1() {
        ExamRoom room = new ExamRoom(10);
        assert room.seat() == 0;
        assert room.seat() == 9;
        assert room.seat() == 4;
        assert room.seat() == 2;
        room.leave(4);
        assert room.seat() == 5;
    }
}
