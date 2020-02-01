package com.github.hcsp.algorithm;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    BinaryTree.TreeNode node1 = new BinaryTree.TreeNode(1);
    BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(2);
    BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(3);
    BinaryTree.TreeNode node4 = new BinaryTree.TreeNode(4);
    BinaryTree.TreeNode node5 = new BinaryTree.TreeNode(5);
    BinaryTree.TreeNode node6 = new BinaryTree.TreeNode(6);

    {
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
    }

    @Test
    public void bfsTest() {

        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), BinaryTree.bfs(node1));
    }

    @Test
    public void dfsTest() {
        Assertions.assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), BinaryTree.dfs(node1));
    }
}
