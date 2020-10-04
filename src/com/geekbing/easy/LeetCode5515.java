package com.geekbing.easy;

public class LeetCode5515 {
    private int big, bigLeft;
    private int medium, mediumLeft;
    private int small, smallLeft;

    public LeetCode5515(int big, int medium, int small) {
        this.big = big;
        this.bigLeft = big;
        this.medium = medium;
        this.mediumLeft = medium;
        this.small = small;
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

    public static void main(String[] args) {
        LeetCode5515 parkingSystem = new LeetCode5515(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // 返回 true ，因为有 1 个空的大车位
        System.out.println(parkingSystem.addCar(2)); // 返回 true ，因为有 1 个空的中车位
        System.out.println(parkingSystem.addCar(3)); // 返回 false ，因为没有空的小车位
        System.out.println(parkingSystem.addCar(1)); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
    }
}
