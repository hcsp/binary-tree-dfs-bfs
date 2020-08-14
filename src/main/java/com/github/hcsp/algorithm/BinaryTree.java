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
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> treeNodeList = new ArrayList<>();
        if (root == null) {
            return treeNodeList;
        }
        //将根节点插入队列
        queue.add(root);
        //当队列中所有的值依次取出直到为空时，退出循环
        while (!queue.isEmpty()) {
            //从队列中取出节点
            TreeNode node = queue.poll();
            //如果存在子节点的话，将子节点插入点列。
            //由于队列具有先进先出的特点，所以插入队列的顺序是node.left然后是node.right
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            //将当前节点的值插入到列表中
            treeNodeList.add(node.value);
        }


        return treeNodeList;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> treeNodeList = new ArrayList<>();
        if (root == null) {
            return treeNodeList;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 由于栈的先进后出的特点，所以插入栈的顺序是node.right然后是node.left
            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
            treeNodeList.add(node.value);
        }
        return treeNodeList;
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
