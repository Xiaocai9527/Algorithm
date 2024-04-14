package com.example.algorithm.algorithm.array;

import static com.example.algorithm.algorithm.sort.BubbleSort.bubbleSort;

public class BinarySearch {

    // return value index in array
    private int binarySearch(int[] array, int value) {
        System.out.println("value:" + value);
        if (array == null || array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("low:" + low + ";high:" + high + ";mid:" + mid);
            if (value > array[mid]) {
                low = mid + 1;
            } else if (value < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        BinarySearch search = new BinarySearch();
        int index = search.binarySearch(nums, 22);
        System.out.println("index:" + index);
    }

}
