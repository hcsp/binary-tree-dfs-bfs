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

    // 请实现二叉树的广度优先遍历（层次遍历） 从上到下，从左到右
    public static List<Integer> bfs(TreeNode root) {
        // 队列是先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> integerList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 返回第一个元素并删除
            TreeNode node = queue.poll();
            integerList.add(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return integerList;
    }

    // 请实现二叉树的深度优先遍历（前序）即根遍历
    public static List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack(); // 栈
        List<Integer> integerList = new ArrayList<>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            integerList.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return integerList;
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
