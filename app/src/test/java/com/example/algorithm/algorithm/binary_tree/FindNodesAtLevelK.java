package com.example.algorithm.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树输出第 k 层节点元素
 * 思路：递归
 */
public class FindNodesAtLevelK {


    // 用于存储第 k 层节点的值
    List<Integer> nodesAtLevelK = new ArrayList<>();


    public static void main(String[] args) {
        // 示例二叉树构建
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 输出第 k 层的节点元素
        FindNodesAtLevelK binaryTree = new FindNodesAtLevelK();
        binaryTree.printNodesAtLevelK(root, 3); // 假设我们要输出第 3 层的节点
    }

    private void printNodesAtLevelK(TreeNode root, int k) {
        findNodesAtLevelK(root, k, 1);

        // 打印第 k 层的节点元素
        for (int val : nodesAtLevelK) {
            System.out.print(val + " ");
        }
    }

    private void findNodesAtLevelK(TreeNode node, int k, int currentLevel) {
        if (node == null) {
            return;
        }

        if (currentLevel == k) {
            // 当前节点位于第 k 层
            nodesAtLevelK.add(node.val);
        } else {
            // 否则继续递归遍历左右子树
            findNodesAtLevelK(node.left, k, currentLevel + 1);
            findNodesAtLevelK(node.right, k, currentLevel + 1);
        }
    }
}
