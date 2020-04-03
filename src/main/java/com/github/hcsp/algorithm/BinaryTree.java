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


        /*// Creating an empty Stack
        Stack<String> STACK = new Stack<String>();

        // Use add() method to add elements
        STACK.push("Welcome");
        STACK.push("To");
        STACK.push("Geeks");
        STACK.push("For");
        STACK.push("Geeks");

        // Displaying the Stack
        System.out.println("Initial Stack: " + STACK);

        // Removing elements using pop() method
        System.out.println("Popped element: " +
                STACK.pop());
        System.out.println("Popped element: " +
                STACK.pop());

        // Displaying the Stack after pop operation
        System.out.println("Stack after pop peration "
                + STACK);*/
    }

    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        //利用了Queue队列先进先出的特性
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.value + "  ");


            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            list.add(treeNode.value);
        }

        return list;
    }

    // 请实现二叉树的深度优先遍历（前序）,利用栈的先进后出
    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.value + " ");

            //stack 先进后出，所以先右后左
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }

            list.add(treeNode.value);


        }
        return list;

    }

    /*以上图中的二叉树为例，先将6入栈，此时List为空，Stack只有一个元素6，进入while循环，
    弹出栈顶加入List，将6的右孩子和左孩子入栈，此时Stack从栈底到栈顶元素为8,2，List元素为6，
    由于栈不为空，进入while循环，弹出栈顶2,将2加入List,同时将2的右孩子和左孩子分别入栈，
    此时Stack从栈底到栈顶的元素为8,4,0, List的元素为6,2，由于栈不为空再次进入while循环…
    依次下去，弹出0加入List，入栈1,null，此时Stack从栈底到栈顶为8,4,1,null，List为6,2,0，
    弹出null为空继续弹出1，如此下去就可以了…
*/

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
