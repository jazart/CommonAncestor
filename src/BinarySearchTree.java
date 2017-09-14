///**
// * Created by jazart on 11/3/2016.
// */
//
///**
// * Write a description of class BinarySearchTree here.
// *
// * @author (your name)
// * @version (a version number or a date)
// */
//public class BinarySearchTree<T>
//{
//
//    protected   Node root;
//
//    public BinarySearchTree(T Node){
//
//
//    }
//
//    public  Node find(T id){
//        Node temp = root;
//        while(temp.right.data.compareTo(id) > 0){
//            temp = temp.left;
//
//            if(temp.right.data == id || temp.left.data == id){
//                return true;
//            }
//            else if (temp.right.data == null || temp.left.data ==null){
//            return false;
//            }
//
//        while(temp !=null){
//            if(id.compareTo(temp.data) ==0){
//                return temp;
//            }
//            if(id.compareTo(temp.data) <0){
//                temp = temp.left;
//            }
//            else{
//                temp = temp.right;
//            }
//        }
//        return temp;
//}
//
//
//
//    public void insert(String id){
//        Node newNode = new Node(id);
//
//        if(root==null){
//            root = newNode;
//            return;
//        }
//        Node temp = root;
//        Node parent = null;
//
//
//        while(true){
//            parent = temp;
//
//            if(id.compareTo(temp.data)<=0) {
//                temp = temp.left;
//                if (temp == null) {
//                    parent.left = newNode;
//                    return;
//                }
//            }
//
//            else{
//                temp = temp.right;
//                if(temp == null){
//                    parent.right = newNode;
//                    return;
//                }
//            }
//        }
//
//
//
//}
//
//    public void display(Node root){
//
//        if(root !=null) {
//            display(root.left);
//            System.out.print(" " + root.data);
//        }
//    }
//
//
//    public boolean delete(String id){
//        Node parent = root;
//        Node current = root;
//        boolean isLeftChild = false;
//        while(current.data!=id){
//            parent = current;
//            if(current.data.compareTo(id) >0){
//                isLeftChild = true;
//                current = current.left;
//            }else{
//                isLeftChild = false;
//                current = current.right;
//            }
//            if(current ==null){
//                return false;
//            }
//        }
//        //if i am here that means we have found the node
//        //Case 1: if node to be deleted has no children
//        if(current.left==null && current.right==null){
//            if(current==root){
//                root = null;
//            }
//            if(isLeftChild ==true){
//                parent.left = null;
//            }else{
//                parent.right = null;
//            }
//        }
//        //Case 2 : if node to be deleted has only one child
//        else if(current.right==null){
//            if(current==root){
//                root = current.left;
//            }else if(isLeftChild){
//                parent.left = current.left;
//            }else{
//                parent.right = current.left;
//            }
//        }
//        else if(current.left==null){
//            if(current==root){
//                root = current.right;
//            }else if(isLeftChild){
//                parent.left = current.right;
//            }else{
//                parent.right = current.right;
//            }
//        }else if(current.left!=null && current.right!=null){
//
//            //now we have found the minimum element in the right sub tree
//            Node successor   = getSuccessor(current);
//            if(current==root){
//                root = successor;
//            }else if(isLeftChild){
//                parent.left = successor;
//            }else{
//                parent.right = successor;
//            }
//            successor.left = current.left;
//        }
//        return true;
//    }
//
//    public Node getSuccessor(Node deleleNode){
//        Node successsor =null;
//        Node successsorParent =null;
//        Node current = deleleNode.right;
//        while(current!=null){
//            successsorParent = successsor;
//            successsor = current;
//            current = current.left;
//        }
//        //check if successor has the right child, it cannot have left child for sure
//        // if it does have the right child, add it to the left of successorParent.
//        //      successsorParent
//        if(successsor!=deleleNode.right){
//            successsorParent.left = successsor.right;
//            successsor.right = deleleNode.right;
//        }
//        return successsor;
//    }
//
//
//
//}
//
//class Node {
//    String data = "";
//    Node left;
//    Node right;
//
//    public Node(String data){
//        this.data = data;
//        left = null;
//        right = null;
//    }
//
//    public Node(){
//        this.data = data;
//        left = null;
//        right = null;
//    }
//
//
//}
