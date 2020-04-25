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
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode cureentRoot = deque.poll();
            result.add(cureentRoot.value);
            if (cureentRoot.left != null) {
                deque.offer(cureentRoot.left);
            }
            if (cureentRoot.right != null) {
                deque.offer(cureentRoot.right);
            }
        }
        return result;
    }

    // 请实现二叉树的深度优先遍历（前序）对任一子树，先访问根，然后遍历其左子树，最后遍历其右子树
    public static List<Integer> dfs(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        linkedList.push(root);
        while (!linkedList.isEmpty()) {
            TreeNode cureentRoot = linkedList.pop();
            result.add(cureentRoot.value);
            if (cureentRoot.right != null) {
                linkedList.push(cureentRoot.right);
            }
            if (cureentRoot.left != null) {
                linkedList.push(cureentRoot.left);
            }
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
