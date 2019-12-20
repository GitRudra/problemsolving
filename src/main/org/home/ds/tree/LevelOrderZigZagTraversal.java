package org.home.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigZagTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int levelCount = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prevElementCount = 1;
        int currentElementCount = 0;
        while(!queue.isEmpty()){
            if(levelCount %2 ==1){
                List<Integer> levelTraversal = new ArrayList<>();
                while(prevElementCount>0){
                    TreeNode node = queue.remove();
                    levelTraversal.add(node.val);
                    if(node.right!=null){
                        queue.add(node.right);
                        currentElementCount++;
                    }
                    if(node.left != null){
                        queue.add(node.left);
                        currentElementCount++;
                    }
                    prevElementCount--;
                }
                if(!levelTraversal.isEmpty()){
                    result.add(levelTraversal);
                }
                prevElementCount = currentElementCount;
                currentElementCount = 0;
                levelCount++;
            }
            if(levelCount %2 == 0){
                List<Integer> levelTraversal = new ArrayList<>();
                while(prevElementCount>0){
                    TreeNode node = queue.remove();
                    levelTraversal.add(node.val);
                    if(node.left!=null){
                        queue.add(node.left);
                        currentElementCount++;
                    }
                    if(node.right != null){
                        queue.add(node.right);
                        currentElementCount++;
                    }
                    prevElementCount--;
                }
                if(!levelTraversal.isEmpty()){
                    result.add(levelTraversal);
                }

                prevElementCount = currentElementCount;
                currentElementCount = 0;
                levelCount++;
            }
        }

        return result;
    }
}
