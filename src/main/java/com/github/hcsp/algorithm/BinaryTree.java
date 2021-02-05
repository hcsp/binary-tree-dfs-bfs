package com.github.hcsp.algorithm;

import java.util.LinkedList;
import java.util.List;
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
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();

        treeNodeList.add(root);
        while (!treeNodeList.isEmpty()) {
            TreeNode tem = treeNodeList.remove();

            if (tem.left != null) {
                treeNodeList.add(tem.left);
            }
            if (tem.right != null) {
                treeNodeList.add(tem.right);
            }
            list.add(tem.value);
        }
        return list;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tem = stack.pop();
            list.add(tem.value);
            if (tem.right != null) {
                stack.push(tem.right);
            }
            if (tem.left != null) {
                stack.push(tem.left);
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
