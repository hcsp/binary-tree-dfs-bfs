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
        List<Integer> bfsList = new ArrayList<>();
        if (root == null) {
            return bfsList;
        } else {
            // 借助队列的先进先出特性
            Queue<TreeNode> queue = new LinkedList<>();
            // 根节点入队列
            queue.offer(root);
            while (queue.size() != 0) {
                TreeNode node = queue.poll();

                // 开始遍历，将 node 保存到 bfsList
                bfsList.add(node.value);
                // 同时将其不为空的左右节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return bfsList;
        }
    }

    // 请实现二叉树的深度优先遍历（前序）
    public static List<Integer> dfs(TreeNode root) {
        // （非递归）借助栈的后进先出特性
        List<Integer> dfsList = new ArrayList<>();
        if (root == null) {
            return dfsList;
        } else {
            Stack<TreeNode> stack = new Stack<>();
            // 根节点入栈
            stack.push(root);
            dfsList.add(root.value);
            TreeNode node = root;
            while (stack.size() != 0) {
                while (node.left != null) {
                    // 当左子树不为空时
                    // 先根节点，再左节点，最后右节点
                    dfsList.add(node.left.value);
                    stack.push(node.left);
                    node = node.left;
                }
                // 每次向上一个节点
                node = stack.pop();
                if (node.right != null) {
                    dfsList.add(node.right.value);
                    // 同样记得要压入栈，否则后面无法向上
                    stack.push(node.right);
                    node = node.right;
                }
            }

            return dfsList;
        }
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
