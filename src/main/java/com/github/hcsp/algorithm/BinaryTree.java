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
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);



        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node4.left = node8;
        node4.right = node9;

        node6.left = node7;
        node6.right = node10;

//        System.out.println(bfs(node1));
        System.out.println(dfs(node1));
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 使用队列存储树节点
        while (queue.size() != 0) {
            TreeNode tempRoot = queue.poll();
            list.add(tempRoot.value);
            if (tempRoot.left != null) {
                queue.add(tempRoot.left);
            }
            if (tempRoot.right != null) {
                queue.add(tempRoot.right);
            }
        }
        return list;
    }



    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 使用栈（双端队列）
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        list.add(root.value);
        boolean flag = true;
        while (deque.size() != 0) {
            TreeNode tempNode = deque.peekLast();
            if (tempNode.left != null && flag) {
                TreeNode leftNode = tempNode.left;
                list.add(leftNode.value);
                deque.add(leftNode);
            } else {
                deque.pollLast();
                if (tempNode.right != null) {
                    TreeNode rightNode = tempNode.right;
                    list.add(rightNode.value);
                    deque.add(rightNode);
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        return list;
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
