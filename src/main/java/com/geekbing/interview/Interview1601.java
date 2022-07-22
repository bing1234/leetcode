package com.geekbing.interview;

import java.util.Arrays;

public class Interview1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        Interview1601 interview1601 = new Interview1601();
        System.out.println(Arrays.toString(interview1601.swapNumbers(new int[]{1, 2})));
    }
}
