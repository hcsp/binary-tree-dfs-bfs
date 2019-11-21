package com.github.hcsp.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode root = makeArrToTreeNode(arr, 0);
        System.out.println("root = " + root);
        System.out.println(bfs(root));
        System.out.println(dfs(root));
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode t = deque.remove();
            list.add(t.value);
            if (t.left != null) {
                deque.add(t.left);
            }
            if (t.right != null) {
                deque.add(t.right);
            }

        }
        return list;
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            list.add(t.value);
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    private static TreeNode makeArrToTreeNode(int[] arr, int index) {
        if (index < arr.length) {
            int val = arr[index];
            TreeNode t = new TreeNode(val);
            t.left = makeArrToTreeNode(arr, (index << 1) + 1);
            t.right = makeArrToTreeNode(arr, (index << 1) + 2);
            return t;
        }
        return null;
    }
}
