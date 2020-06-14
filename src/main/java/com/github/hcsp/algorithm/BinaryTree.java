package com.github.hcsp.algorithm;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

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
        List<Integer> integerList = new ArrayList<>();
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.remove();
            integerList.add(node.value);
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
        return integerList;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> integerList = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !treeNodes.isEmpty()) {
            if (node!=null) {
                integerList.add(node.value);
                treeNodes.push(node);
                node = node.left;
            }else {
                TreeNode node1=treeNodes.pop();
                node=node1.right;
            }
        }
        return integerList;
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
