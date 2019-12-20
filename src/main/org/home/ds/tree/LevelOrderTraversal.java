package org.home.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    /**
     * Print the level order traversal of the tree.
     * @param root {@Link LevelOrderTreeNode}
     * @return - traversal list
     */
    public ArrayList<Integer> printLevelOrderTraversal(LevelOrderTreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<LevelOrderTreeNode> q = new LinkedList();
        q.add(root);


        while (true) {
            int count = q.size();
            if (count == 0) {
                break;
            }
            while (count > 0) {
                LevelOrderTreeNode n = q.remove();
                result.add(n.value);
                count--;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }

        return result;
    }

    public void linkTreeNode(LevelOrderTreeNode root){
        if (root == null) {
            return;
        }
        Queue<LevelOrderTreeNode> q = new LinkedList();
        q.add(root);
        while (true) {
            int count = q.size();
            if (count == 0) {
                break;
            }
            while (count > 0) {
                LevelOrderTreeNode n = q.remove();

                //result.add(n.value);
                count--;
                if(count == 0){
                  n.nextPtr = null;
                }else{
                  LevelOrderTreeNode m = q.peek();
                  n.nextPtr = m;
                }

                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }

    }

    public void printSpiral(LevelOrderTreeNode root){
        if(root == null){
            return;
        }
        Stack<LevelOrderTreeNode> lTRStack = new Stack<>();
        Stack<LevelOrderTreeNode> rTLStack = new Stack<>();
        boolean lTRTraversalFlag = true;
        lTRStack.push(root);

        while(!lTRStack.isEmpty() || ! rTLStack.isEmpty()){
            if(lTRTraversalFlag){
                LevelOrderTreeNode n = lTRStack.pop();
                System.out.print(n.value+" ");
                if(n.left != null){
                    rTLStack.push(n.left);
                }
                if(n.right != null){
                    rTLStack.push(n.right);
                }
                if(lTRStack.isEmpty()){
                    lTRTraversalFlag = false;
                }
            }else{
                LevelOrderTreeNode n = rTLStack.pop();
                System.out.print(n.value+" ");
                if(n.right != null){
                    lTRStack.push(n.right);
                }
                if(n.left != null){
                    lTRStack.push(n.left);
                }
                if(rTLStack.isEmpty()){
                    lTRTraversalFlag = true;
                }
            }
        }
    }

    public void printTree(LevelOrderTreeNode root){
      if(root==null){
        return ;
      }
      printTree(root.left);
      System.out.println(root);
      printTree(root.right);

    }

    public int findAlternateLevelSumDifference(LevelOrderTreeNode root){
        if(root == null){
            return 0;
        }else{
            Queue<LevelOrderTreeNode> queue = new LinkedList<>();

            int sum = 0;
            int levelSum = 0;
            boolean flag = true;
            queue.add(root);
            int count = queue.size();
            while(count != 0){
                while(count>0){
                    LevelOrderTreeNode node = queue.remove();
                    levelSum += node.value;
                    count --;
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
                if(flag){
                    sum+=levelSum;
                    flag = false;
                    levelSum = 0;

                }else{
                    sum-=levelSum;
                    flag = true;
                    levelSum = 0;
                }
                count = queue.size();
            }
            return sum;
        }

    }

    public int getLevelDiff(LevelOrderTreeNode root){
        if(root == null){
            return 0;
        }else{
            return root.value -  getLevelDiff(root.left) - getLevelDiff(root.right);
        }
    }
}
