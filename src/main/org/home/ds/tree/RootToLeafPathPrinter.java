package org.home.ds.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Solution to print path from root to each leaf node.
 * Approach :
 *   Create a linked list to keep the path.
 *   Traverse the tree in PostOrder. Keep each non leaf node in the list
 *   If it is a leaf node then put the node in the list.
 *   print the list and remove the last leaf node.
 *   Remove the last non leaf node from the list when both left and
 *   right subtrees are visited.
 */
public class RootToLeafPathPrinter {

    /**
     * Method to print the path from root to leaf.
     * @param root
     */
    public void printPath(TreeNodeInt root){
        if(root == null){
            System.out.println("In valid input !!!");
            return;
        }
        LinkedList<TreeNodeInt> path = new LinkedList();
        printPathUtil(root,path);
    }

    /**
     * Utility method to check leaf node
     * @param node
     * @return
     */
    private boolean isLeaf(TreeNodeInt node){
        return (node.left == null) && (node.right == null);
    }

    /**
     *
     * @param root
     * @param path
     */
    private void printPathUtil(TreeNodeInt root, LinkedList<TreeNodeInt> path){
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            path.addLast(root);
            printPath(path);
            return;
        }else{
            path.addLast(root);
        }
        printPathUtil(root.left, path);
        printPathUtil(root.right, path);
        path.removeLast();
    }

    /**
     * Print the path using parent pointer
     * @param node
     * @param parent
     */
    private void printPath(TreeNodeInt node, HashMap<TreeNodeInt,TreeNodeInt> parent){
        Stack<TreeNodeInt> printStack = new Stack<>();
        while(node != null){
            printStack.push(node);
            node = parent.get(node);
        }
        TreeNodeInt temp =  null;
        System.out.println("");
        while(!printStack.isEmpty()){
            temp = printStack.pop();
            System.out.print(temp.key + " ");
        }
    }

    /**
     * Approach :The idea is to maintain a map to store
     * parent pointers of binary tree nodes. Now whenever we encounter
     * a leaf node while doing iterative preorder traversal,
     * we can easily print root to leaf path using parent pointer.
     * Below is implementation of this idea.
     *
     * @param root
     */
    public void printRootToLeafPathIterative(TreeNodeInt root){
        if(root == null){
            return;
        }
        HashMap<TreeNodeInt,TreeNodeInt> parent = new HashMap<>();
        Stack<TreeNodeInt> nodeStack = new Stack();
        parent.put(root,null);
        nodeStack.push(root);

        while(!nodeStack.isEmpty()){
            TreeNodeInt element = nodeStack.pop();
            if(isLeaf(element)){
                printPath(element,parent);
            }else{
                if(element.right != null){
                    nodeStack.push(element.right);
                    parent.put(element.right,element);
                }
                if(element.left != null){
                    nodeStack.push(element.left);
                    parent.put(element.left,element);
                }
            }
        }

    }

    private void printPath(LinkedList<TreeNodeInt> path){
        System.out.println();
        path.stream().forEach(e-> System.out.print(e.key+" "));
        path.removeLast();
    }
}
