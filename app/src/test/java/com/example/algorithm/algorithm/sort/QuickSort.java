package com.example.algorithm.algorithm.sort;

/**
 * 快速排序：分治法 ，时间复杂度O(nlog n) ，空间复杂度 log n
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {64, 34, 25, 90, 12, 22, 11};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            System.out.println("pivotIndex:" + pivotIndex);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准值
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        System.out.println("i+1:" + (i + 1));
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
