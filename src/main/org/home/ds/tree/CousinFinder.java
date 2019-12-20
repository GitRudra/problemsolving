package org.home.ds.tree;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class CousinFinder {
    static int targetnodelevel = 0;
    private static TreeNodeInt getLevel(TreeNodeInt root, int key, int level){
        if(root == null){
            return null;
        }
        root.height = level;
        if(root.key == key){
            return root;
        }
        TreeNodeInt targetNode = getLevel(root.left,key,level+1);
        if(targetNode != null){
            return targetNode;
        }
        targetNode = getLevel(root.right, key, level+1);
        return targetNode;
    }

    private static void printNodeForALevel(TreeNodeInt root, TreeNodeInt targetNode, int level ){
       // System.out.println("Node found "+root.key);
        if(root == null){
            return;
        }
        if((root.left != null && root.left == targetNode) ||
                (root.right != null && root.right == targetNode)){
            return;
        }
        if(targetnodelevel == level){
            System.out.println(root.key);
        }/*else if(root.height > level){
            return;
        }*/else{
            printNodeForALevel(root.left,targetNode,level+1);
            printNodeForALevel(root.right,targetNode,level+1);
        }
    }

    public static void printCousinNode(TreeNodeInt root, int targetKey){
        TreeNodeInt targetNode = getLevel(root,targetKey,0);
        //System.out.println(targetNode.key);
        if(targetNode == null){
            System.out.println("Key not found !!!");
            return;
        }
        targetnodelevel = targetNode.height;
        printNodeForALevel(root,targetNode, 0);

    }

    public static void printCousinNodeLevelOrder(TreeNodeInt root, int targetKey){

        Queue<TreeNodeInt> helperQueue = new ArrayDeque();
        int level  = 0;
        int maxAllowableLevel = Integer.MAX_VALUE;
        root.height = level;
        helperQueue.add(root);
        while(helperQueue.size() >0){
            TreeNodeInt elt = helperQueue.remove();
            if(elt.key == targetKey){
                maxAllowableLevel = elt.height;
            }
            if(elt.height > maxAllowableLevel){
                break;
            }else if(elt.height == maxAllowableLevel){
                System.out.print(elt.key);
            }else{
                if(elt.left != null){
                    elt.left.height = elt.height+1;
                    helperQueue.add(elt.left);
                }
                if(elt.right != null){
                    elt.right.height = elt.height+1;
                    helperQueue.add(elt.right);
                }
            }
        }
    }
}
