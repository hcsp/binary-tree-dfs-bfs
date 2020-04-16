package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
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
    public static List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.value);
        bfsRecursive(list, root);
        return list;
    }

    private static void bfsRecursive(List<Integer> list, TreeNode root) {
        if (root.left != null && list.add(root.left.value)) {
        }
        if (root.right != null && list.add(root.right.value)) {
            if (root.left != null) {
                bfsRecursive(list, root.left);
            }
            bfsRecursive(list, root.right);
        }
    }


    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.value);
        dfsRecursive(list, root);
        return list;
    }

    private static void dfsRecursive(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            list.add(root.left.value);
            dfsRecursive(list, root.left);
        }
        if (root.right != null) {
            list.add(root.right.value);
            dfsRecursive(list, root.right);
        }
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
