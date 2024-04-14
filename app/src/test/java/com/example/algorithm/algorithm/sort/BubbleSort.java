package com.example.algorithm.algorithm.sort;

public class BubbleSort {


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            // 如果没有交换过元素，则已经排序完成
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
