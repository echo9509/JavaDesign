package com.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sh
 * 二叉树
 */
public class Tree {

    public static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     * @param nodeList 前序遍历的结果
     * @param <T>
     */
    public static <T> TreeNode<T> createBinaryTree(LinkedList<T> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return null;
        }
        TreeNode<T> treeNode = null;
        T data = nodeList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode<>(data);
            treeNode.left = createBinaryTree(nodeList);
            treeNode.right = createBinaryTree(nodeList);
        }
        return treeNode;
    }

    /**
     * 前序遍历(栈)
     * @param node
     * @param <T>
     */
    public static <T> void preOrderTravelWithStack(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<T>> nodeList = new Stack<>();
        TreeNode<T> currentNode = node;
        while (currentNode != null || !nodeList.isEmpty()) {
            while (currentNode != null) {
                System.out.println(currentNode.data);
                nodeList.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!nodeList.isEmpty()) {
                currentNode = nodeList.pop();
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     * @param <T>
     */
    public static <T> void preOrderTravel(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }

    /**
     * 中序遍历
     * @param node
     * @param <T>
     */
    public static <T> void inOrderTravel(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.left);
        System.out.println(node.data);
        inOrderTravel(node.right);
    }

    /**
     * 中序遍历栈
     * @param node
     * @param <T>
     */
    public static <T> void inOrderTravelWithStack(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        TreeNode<T> currentNode = node;
        Stack<TreeNode<T>> nodeList = new Stack<>();
        while (currentNode != null || !nodeList.isEmpty()) {
            while (currentNode != null) {
                nodeList.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!nodeList.isEmpty()) {
                currentNode = nodeList.pop();
                System.out.println(currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param node
     * @param <T>
     */
    public static <T> void postOrderTravel(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.left);
        postOrderTravel(node.right);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     * @param node
     * @param <T>
     */
    public static <T> void leaveOrderTravel(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode<T>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()) {
            TreeNode<T> poll = nodeQueue.poll();
            System.out.println(poll.data);
            if (poll.left != null) {
                nodeQueue.offer(poll.left);
            }
            if (poll.right != null) {
                nodeQueue.offer(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> nodeList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode<Integer> tree = createBinaryTree(nodeList);
        System.out.println("------------前序遍历-------------");
        preOrderTravel(tree);
        System.out.println("------------前序遍历(栈)-------------");
        preOrderTravelWithStack(tree);
        System.out.println("------------中序遍历-------------");
        inOrderTravel(tree);
        System.out.println("------------中序遍历(栈)-------------");
        inOrderTravelWithStack(tree);
        System.out.println("------------后序遍历-------------");
        postOrderTravel(tree);
        System.out.println("------------层序遍历-------------");
        leaveOrderTravel(tree);
    }
}
