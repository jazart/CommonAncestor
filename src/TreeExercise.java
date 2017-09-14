/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 *
 * @author Jeremy Payne
 */
public class TreeExercise {

    public static void main(String args[]) {

        String[] myStringChars = new String[26];

        for (int i = 0; i < 26; i++) {
            myStringChars[i] = new String(Character.toChars(i + 65));

        }

        TreeNode<String> root0 = new TreeNode<String>(myStringChars[0], null);
        //creating root node in tree

        TreeNode<String> tempRoot = root0;

        //two temp root nodes that will move to child nodes
        int level = 0;
        System.out.println(myStringChars.length);

        for (int i = 0; i < myStringChars.length; i++) {
            if (i < myStringChars.length / 2) {
                tempRoot = root0.findNodeOnTree(myStringChars[i]);

                if (2 * i + 1 < myStringChars.length && 2 * (i + 1) < myStringChars.length) {
                    tempRoot.setLeftChild(new TreeNode(myStringChars[2 * i + 1], tempRoot));
                    tempRoot.getLeftChild().setLevel(tempRoot.getLevel() + 1);
                    tempRoot.setRightChild(new TreeNode(myStringChars[2 * (i + 1)], tempRoot));
                    tempRoot.getRightChild().setLevel(tempRoot.getLevel() + 1);

                }
            }

            if (2 * i + 1 == myStringChars.length - 1) {
                tempRoot.setLeftChild(new TreeNode(myStringChars[2 * i + 1], tempRoot));
                tempRoot.getLeftChild().setLevel(tempRoot.getLevel() + 1);
            }

        }


        TreeNode<String > n = new TreeNode<String>("1", root0.findNodeOnTree("N"));
        TreeNode<String > n1 = new TreeNode<String>("1", root0.findNodeOnTree("N"));
        //TreeNode<String > n2 = new TreeNode<String>("1", root0.findNodeOnTree("O"));
        //TreeNode<String > n3 = new TreeNode<String>("1", root0.findNodeOnTree("O"));

        root0.findNodeOnTree("N").setLeftChild(n);
        root0.findNodeOnTree("N").setRightChild(n1);
        //root0.findNodeOnTree("O").setLeftChild(n2);
        //root0.findNodeOnTree("O").setRightChild(n3);
        root0.findNodeOnTree("M").setRightChild(n);


        n.setLevel(4);
        n1.setLevel(4);
        //n2.setLevel(4);
        //n3.setLevel(4);

        //System.out.println(root0.findNodeOnTree("B").getLevel());
        System.out.println(perfectTree(root0.findNodeOnTree("G")));
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter two letters: ");
        TreeNode<String> node1;
        TreeNode<String> node2;


        node1 = root0.findNodeOnTree(input.nextLine().toUpperCase());
        node2 = root0.findNodeOnTree(input.nextLine().toUpperCase());

        System.out.println("The lowest common ancestor is: " + findLowestCommonAncestor(node1, node2).getContents());


    }


    public static TreeNode findLowestCommonAncestor(TreeNode node1, TreeNode node2) {

        while (node1.getLevel() > node2.getLevel()) {
            node1 = node1.getParent();
        }


        if (node2.getLevel() == node1.getLevel()) {
            while (node1.getParent() != node2.getParent()) {
                node1 = node1.getParent();
                node2 = node2.getParent();

            }
            return node1.getParent();
        } else {
            while (node2.getLevel() > node1.getLevel()) {
                node2 = node2.getParent();
            }
            while (node2.getParent() != node1.getParent()) {
                node2 = node2.getParent();
                node1 = node1.getParent();
            }
            return node2.getParent();

        }


    }

    public static int getLeaves(TreeNode<String> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 1;
        }

        return getLeaves(root.getRightChild()) + getLeaves(root.getLeftChild());

    }


         public static boolean isPerfect(TreeNode<String> root) {
            if (root == null) {
                return true;
            }
            if(root.getLeftChild() != null && root.getRightChild() != null) {
                return isPerfect(root.getLeftChild()) && isPerfect(root.getRightChild());
            }
            if(root.getRightChild() != null && root.getLeftChild() != null) {
                return root.getLeftChild().getLevel() == root.getRightChild().getLevel();
            }
            if(root.getLeftChild() == null && root.getRightChild() == null){
                return true;
            }
            return false;


        }

        public static boolean perfectTree(TreeNode<String> node){
            if(node == null){
                return true;
            }

            if(node.getLeftChild() == null ^ node.getRightChild() == null){
                return false;
            }
                return isPerfect(node.getRightChild())&&isPerfect(node.getLeftChild());

        }

        public static int countLeaves(TreeNode<String> node){
            if(node == null){
                return 0;
            }
            if(node.getLeftChild() == null && node.getRightChild() == null){
                return 1;
            }
            return countLeaves(node.getLeftChild()) + countLeaves(node.getRightChild());
        }
    }


