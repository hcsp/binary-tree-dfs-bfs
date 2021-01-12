package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
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
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        LinkedList<Integer> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            list.add(currNode.value);

            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }

        return list;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        ArrayList list = new ArrayList();
        list.add(root.value);

        if (root.left != null) {
            list.addAll(BinaryTree.dfs(root.left));
        }

        if (root.right != null) {
            list.addAll(BinaryTree.dfs(root.right));
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
