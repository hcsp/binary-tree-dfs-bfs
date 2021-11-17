package com.github.hcsp.algorithm;

import com.sun.jmx.remote.internal.ArrayQueue;

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
    List<Integer> list = new ArrayList<>();

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      TreeNode current = queue.removeFirst();
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
      list.add(current.value);
    }
    return list;
  }


  // 请实现二叉树的深度优先遍历（前序）
  public static List<Integer> dfs(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    deepCollect(list, root);
    return list;
  }

  public static void deepCollect(List<Integer> list, TreeNode node) {
    list.add(node.value);
    if (node.left != null) {
      deepCollect(list, node.left);
    }
    if (node.right != null) {
      deepCollect(list, node.right);
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
