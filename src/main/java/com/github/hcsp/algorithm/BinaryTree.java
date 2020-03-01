package com.github.hcsp.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<TreeNode> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        int index = 0;
        while (currentNodes.size() != index) {
            TreeNode treeNode = currentNodes.get(index);
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left != null) {
                currentNodes.add(left);
            }
            if (right != null) {
                currentNodes.add(right);
            }
            index++;
        }
        return currentNodes.stream().map(TreeNode::getValue).collect(Collectors.toList());
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveDfs(result, root);
        return result;
    }

    public static void recursiveDfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        result.add(root.getValue());
        recursiveDfs(result, left);
        recursiveDfs(result, right);
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
