package com.example.algorithm.algorithm.binary_tree;

/**
 * Created by xiaokun on 2022/1/18.
 * 二叉树前序遍历
 *
 * @author xiaokun
 * @date 2022/1/18
 */
class BinaryTreePreOrder {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreePreOrder order = new BinaryTreePreOrder();

        System.out.println("使用递归遍历:");
        TreeNode rootNode = createTreeNode();
        order.preOrder(rootNode);

        System.out.println();
        System.out.println("-------------------");
        System.out.println("使用迭代遍历:");

    }

    //使用递归前序遍历
    public void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.printf("%d ", treeNode.data);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }



    private static TreeNode createTreeNode() {
        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        return rootNode;
    }


}
