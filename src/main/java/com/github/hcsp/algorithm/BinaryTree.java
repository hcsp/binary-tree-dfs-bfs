package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            result.add(temp.value);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return result;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.value);
        result.addAll(dfs(root.left));
        result.addAll(dfs((root.right)));
        return result;
    }

    // 请实现二叉树的深度优先遍历（中序）
//    public static List<Integer> dfs(TreeNode root) {
//        if (null == root) return Collections.emptyList();
//        List<Integer> result = new ArrayList<>(dfs(root.left));
//        result.add(root.value);
//        result.addAll(dfs((root.right)));
//        return result;
//    }

    // 请实现二叉树的深度优先遍历（后序）
//    public static List<Integer> dfs(TreeNode root) {
//        if (null == root) return Collections.emptyList();
//        List<Integer> result = new ArrayList<>();
//        result.addAll(dfs((root.left)));
//        result.addAll(dfs((root.right)));
//        result.add(root.value);
//        return result;
//    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
