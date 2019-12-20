package org.home.ds.tree;

/**
 * Given a binary tree containing n nodes.
 * The problem is to find the sum of all the parent node’s
 * which have a child node with value x.
 */
public class SumOfParentsHavingChildX {

    private Integer SUM = 0;

    /**
     * Time Complexity: O(n)
     * @param root
     * @param key
     * @return
     */
    public Integer getSum(TreeNodeInt root, Integer key){
        if(root == null){
            return SUM;
        }
        getSumUtil(root,key);
        return SUM;
    }

    private void getSumUtil(TreeNodeInt root,Integer key){
        if(root == null){
            return;
        }
        if((root.getLeft() != null && root.getLeft().getKey() == key) ||
                (root.getRight() != null && root.getRight().getKey() == key)){
            SUM += root.getKey();
        }
        getSumUtil(root.getLeft(),key);
        getSumUtil(root.getRight(),key);
    }

    public TreeNodeInt createTree(int[] input){
        if(input == null || input.length == 0){
            return null;
        }else{
            return createTreeUtil(input,0);
        }
    }

    private TreeNodeInt createTreeUtil(int[] input, int index){
        if(index >= input.length){
            return null;
        }
        TreeNodeInt node = new TreeNodeInt(input[index]);
        node.setLeft(createTreeUtil(input,2*index+1));
        node.setRight(createTreeUtil(input,2*(index+1)));
        return node;
    }

    public void displayTree(TreeNodeInt root){
        if(root== null){
            return;
        }
        displayTree(root.getLeft());
        System.out.print(root.getKey()+" ");
        displayTree(root.getRight());
    }


}
