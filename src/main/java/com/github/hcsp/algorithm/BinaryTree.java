package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        } else {
            treeNodes.add(root);
            result.add(root.value);
            while (!treeNodes.isEmpty()) {
                TreeNode tempNode = treeNodes.remove(0);
                if (tempNode.left != null) {
                    treeNodes.add(tempNode.left);
                    result.add(tempNode.left.value);
                }
                if (tempNode.right != null) {
                    treeNodes.add(tempNode.right);
                    result.add(tempNode.right.value);
                }
            }
        }
        return result;
    }

    private static void recursive_dfs(TreeNode treeNode, ArrayList<Integer> intergers) {
        if (treeNode != null) {
            intergers.add(treeNode.value);
            recursive_dfs(treeNode.left, intergers);
            recursive_dfs(treeNode.right, intergers);
        }
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        } else {
            recursive_dfs(root, result);
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
