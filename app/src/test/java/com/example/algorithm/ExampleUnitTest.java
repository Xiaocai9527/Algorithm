package com.example.algorithm;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testNums() {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum1(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < nums.length; i++) {
            first = i;
            for (int j = i + 1; j < nums.length; j++) {
                second = j;
                if (target == (nums[first] + nums[second])) {
                    return new int[]{first, second};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testPlus() {
        ListNode third1 = new ListNode(9);
        ListNode sec1 = new ListNode(9, third1);
        ListNode sec2 = new ListNode(9, sec1);
        ListNode sec3 = new ListNode(9, sec2);
        ListNode sec4 = new ListNode(9, sec3);
        ListNode sec5 = new ListNode(9, sec4);
        ListNode sec6 = new ListNode(9, sec5);
        ListNode sec7 = new ListNode(9, sec6);
        ListNode sec8 = new ListNode(9, sec7);
        ListNode first1 = new ListNode(1, sec8);


        ListNode listNode = addTwoNumbers(new ListNode(9), first1);
        System.out.println("listNode:" + listNode);
        List<Integer> integers = convertNodeToList(listNode);
        System.out.println("last result:" + integers.toString());
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger listNodeNums = getListNodeNums(l1);
        BigInteger listNodeNums1 = getListNodeNums(l2);

        System.out.println("listNodeNums:" + listNodeNums);
        System.out.println("listNodeNums1:" + listNodeNums1);

        BigInteger sum = listNodeNums.add(listNodeNums1);

        System.out.println("sum:" + sum);

        List<BigInteger> integers = convertNumToList(sum);

        Collections.reverse(integers);

        System.out.println("integers:" + integers.toString());

        ListNode listNode = convertListToListNode(integers);
        System.out.println(listNode);
        return listNode;
    }

    private ListNode convertListToListNode(List<BigInteger> integers) {
        //708
        ListNode listNode = null;
        for (BigInteger integer : integers) {
            if (listNode == null) {
                listNode = new ListNode(integer.intValue());
            } else {
                listNode = new ListNode(integer.intValue(), listNode);
            }
        }
        return listNode;
    }

    private List<BigInteger> convertNumToList(BigInteger num) {
        List<BigInteger> integers = new ArrayList<>();
        if (num.equals(BigInteger.valueOf(0))) {
            integers.add(BigInteger.valueOf(0));
        } else {
            while (num.compareTo(BigInteger.valueOf(0)) > 0) {
                integers.add(num.mod(BigInteger.valueOf(10)));
                num = num.divide(BigInteger.valueOf(10));
            }
        }
        return integers;
    }


    private BigInteger getListNodeNums(ListNode listNode) {

        List<Integer> integers = convertNodeToList(listNode);
        System.out.println(Arrays.toString(integers.toArray()));

        BigInteger num = convertListToNum(integers);
        System.out.println("num:" + num);

        return num;
    }

    private List<Integer> convertNodeToList(ListNode listNode) {
        List<Integer> integers = new ArrayList<>();
        do {
            integers.add(listNode.val);
        } while ((listNode = listNode.next) != null);
        return integers;
    }

    private BigInteger convertListToNum(List<Integer> integers) {
        BigInteger num = BigInteger.valueOf(0);
        for (int i = integers.size() - 1; i >= 0; i--) {
            BigInteger num1 = getNum(integers.get(i), i);
            System.out.println("num1:" + num1);
            num = num.add(num1);
        }
        return num;
    }

    private BigInteger getNum(long num, long pos) {
        BigInteger result = BigInteger.valueOf(num);
        for (long i = pos; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(10));
        }
        return result;
    }

    //[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
    //[5,6,4]

    public static void main(String[] args) {
//        Integer[] integers = new Integer[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
//        BigInteger num = BigInteger.valueOf(0);
//        for (int i = integers.length - 1; i >= 0; i--) {
//            Integer integer = integers[i];
//            System.out.println("integer:" + integer);
//            System.out.println("i:" + i);
//            BigInteger num1 = getNum(integer, i);
//            System.out.println("num1:" + num1);
//            num = num.add(num1);
//        }

    }

}