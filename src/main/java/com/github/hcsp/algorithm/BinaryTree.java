package com.github.hcsp.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        System.out.println(bfs(node1));
        System.out.println(dfs(node1));
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    static List<Integer> binaryTreeBfs = new ArrayList<>();
    public static List<Integer> bfs(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        if (root != null) {
            deque.add(root);
        }
        TreeNode temp;
        while (!deque.isEmpty()) {
            temp = deque.remove();
            binaryTreeBfs.add(temp.value);
            if (temp.left != null) {
                deque.add(temp.left);
            }
            if (temp.right != null) {
                deque.add(temp.right);
            }
        }
        return binaryTreeBfs;
    }

    // 请实现二叉树的深度优先遍历（前序）
    static List<Integer> binaryTreePreOrder = new ArrayList<>();
    public static List<Integer> dfs(TreeNode root) {
        if (root != null) {
            binaryTreePreOrder.add(root.value);
            dfs(root.left);
            dfs(root.right);
        }
        return binaryTreePreOrder;
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
