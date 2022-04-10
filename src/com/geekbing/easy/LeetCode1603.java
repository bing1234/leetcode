package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1603 {
    private static class ParkingSystem {
        private int bigLeft, mediumLeft, smallLeft;

        public ParkingSystem(int big, int medium, int small) {
            this.bigLeft = big;
            this.mediumLeft = medium;
            this.smallLeft = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (bigLeft == 0) {
                        return false;
                    }
                    bigLeft--;
                    return true;
                case 2:
                    if (mediumLeft == 0) {
                        return false;
                    }
                    mediumLeft--;
                    return true;
                default:
                    if (smallLeft == 0) {
                        return false;
                    }
                    smallLeft--;
                    return true;
            }
        }
    }

    @Test
    public void testCase1() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        boolean ans = parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
        assert ans;
        ans = parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
        assert ans;
        ans = parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
        assert !ans;
        ans = parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
        assert !ans;
    }
}
