package com.github.hcsp.algorithm;

import java.util.*;

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
        ArrayDeque<TreeNode> treeNodeArrayDeque = new ArrayDeque<>();
        treeNodeArrayDeque.add(root);
        while (!treeNodeArrayDeque.isEmpty()) {
            TreeNode node = treeNodeArrayDeque.removeFirst();
            result.add(node.value);
            if(node.left != null) {
                treeNodeArrayDeque.add(node.left);
            }
            if(node.right != null) {
                treeNodeArrayDeque.add(node.right);
            }
        }
        return result;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack();
        treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            result.add(node.value);

            // 测试用例里是 前序遍历
            if(node.right != null) {
                treeNodeStack.push(node.right);
            }
            if(node.left != null) {
                treeNodeStack.push(node.left);
            }
        }

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
