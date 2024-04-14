package com.example.algorithm.algorithm.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaokun on 2022/1/18.
 * 二叉树前序遍历
 *
 * @author xiaokun
 * @date 2022/1/18
 */
class BinaryTreeOrder {

    public static void main(String[] args) {
        BinaryTreeOrder order = new BinaryTreeOrder();

        TreeNode rootNode = createTreeNode();
        System.out.println();

        // DFS 深度优先
        System.out.println("前序遍历:根 左 右");
        order.preOrder(rootNode);

        System.out.println();
        System.out.println("中序遍历:左 根 右");
        order.inOrder(rootNode);

        System.out.println();
        System.out.println("后序遍历:左 右 根");
        order.postOrder(rootNode);

        System.out.println();
        System.out.println("反向中序遍历: 右 根 左");
        order.reverseInOrder(rootNode);

        System.out.println();
        System.out.println("-------------------");

        //BFS 广度优先
        System.out.println("使用队列遍历:");
        order.bfsOrder(rootNode);
    }

    private void bfsOrder(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf("%d ", node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private void reverseInOrder(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        reverseInOrder(rootNode.right);
        System.out.printf("%d ", rootNode.val);
        reverseInOrder(rootNode.left);
    }

    //使用递归前序遍历
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 根 左 右
        System.out.printf("%d ", treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 左 根 右
        inOrder(treeNode.left);
        System.out.printf("%d ", treeNode.val);
        inOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // 左 右 根
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.printf("%d ", treeNode.val);
    }

    private static TreeNode createTreeNode() {
        // 这是一个二分搜索树，也是 BST
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

        print(rootNode, 0);

        return rootNode;
    }

    public static void print(TreeNode root, int level) {
        if (root == null)
            return;
        print(root.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("   ");
        System.out.println(root.val);
        print(root.left, level + 1);
    }

}
