package com.github.hcsp.algorithm;

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

    public static void bfsTraverse(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            result.add(root.left.value);
        }
        if (root.right != null) {
            result.add(root.right.value);
        }
        bfsTraverse(result, root.left);
        bfsTraverse(result, root.right);
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.value);
            bfsTraverse(result, root);
        }
        return result;
    }

    public static void dfsTraverse(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        dfsTraverse(result, root.left);
        dfsTraverse(result, root.right);
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfsTraverse(result, root);
        return result;
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
