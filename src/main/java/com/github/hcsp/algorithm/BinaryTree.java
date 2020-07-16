package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        List<Integer> resultList = new ArrayList<>();
        // 将二叉树放入到可以检查的treeQueue中
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        // 设置循环条件，在treeQueue遍历完毕后结束循环
        while (!treeQueue.isEmpty()) {
            TreeNode tempNode = treeQueue.poll();
            if (tempNode != null) {
                resultList.add(tempNode.value);
                treeQueue.add(tempNode.left);
                treeQueue.add(tempNode.right);
            }
        }
        return resultList;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            TreeNode tempNode = treeStack.pop();
            if (tempNode != null) {
                resultList.add(tempNode.value);
                treeStack.push(tempNode.right);
                treeStack.push(tempNode.left);
            }
        }
        return resultList;
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
