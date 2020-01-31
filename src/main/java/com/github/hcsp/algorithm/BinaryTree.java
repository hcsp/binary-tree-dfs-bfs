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
        //用栈的方式，先进先出
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.poll();
            values.add(node.value);
            if (node.right!=null){
                nodeStack.add(node.right);
            }
            if (node.left!=null){
                nodeStack.add(node.left);
            }
        }
        return values;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        // 用队列的方式，先进后出
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            values.add(node.value);
            if (node.right!=null){
                nodeStack.push(node.right);
            }
            if (node.left!=null){
                nodeStack.push(node.left);
            }
        }
        return values;
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
