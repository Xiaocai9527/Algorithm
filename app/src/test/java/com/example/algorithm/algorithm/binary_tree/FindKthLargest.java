package com.example.algorithm.algorithm.binary_tree;

/**
 * 寻找二叉搜索树中第K个最大元素
 */
public class FindKthLargest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        FindKthLargest findKthLargest = new FindKthLargest();
        int k = 3; // 假设我们要找到第 3 个最大的元素
        int result = findKthLargest.findKthLargest(root, k);
        if (result != -1) {
            System.out.println("The " + k + "th largest element is: " + result);
        } else {
            System.out.println("The " + k + "th largest element does not exist.");
        }
    }

    private int count = 0;
    private int result = Integer.MIN_VALUE;

    public int findKthLargest(TreeNode root, int k) {
        this.count = k;
        reverseInorderTraversal(root);
        return result;
    }

    private void reverseInorderTraversal(TreeNode node) {
        if (node == null || count <= 0) {
            return;
        }

        reverseInorderTraversal(node.right); // First visit the right subtree

        if (--count == 0) {
            result = node.val; // Found the kth largest
            return;
        }

        reverseInorderTraversal(node.left); // Then visit the left subtree
    }

}
