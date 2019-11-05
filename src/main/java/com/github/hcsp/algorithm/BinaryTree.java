package com.github.hcsp.algorithm;

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
        System.out.println(ldr(node1));
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.remove();

            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
            list.add(t.value);
        }
        return list;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                list.add(pNode.value);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop().right;
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
    // 请实现二叉树的深度优先遍历（中序）

    public static List<Integer> ldr(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.value);
                pNode = node.right;
            }
        }
        return list;
    }
}
