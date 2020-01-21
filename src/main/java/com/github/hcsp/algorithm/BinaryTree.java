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

        LinkedList<Integer> capacity = new LinkedList<>();
        if (root == null){
            return capacity;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        //深度优先遍历采用每行从左到右遍历
        while (!queue.isEmpty()) {
            TreeNode node=queue.poll();
            capacity.add(node.value);
            if (null!=node.left) {
                queue.add(node.left);
            }
            if (null!=node.right) {
                queue.add(node.right);
            }

        }
        return capacity;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {

        LinkedList<Integer> capacity = new LinkedList<>();
        if (root==null) {
            return capacity;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);

        //深度优先遍历采用先遍历左边，后遍历右边
        while (!stack.isEmpty()) {
            TreeNode node=stack.pop();
            capacity.add(node.value);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        return capacity;
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
