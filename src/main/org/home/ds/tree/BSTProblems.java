package org.home.ds.tree;

public class BSTProblems {

    /**
     * Ceil Value LevelOrderTreeNode: LevelOrderTreeNode with smallest data larger than or equal to key value.
     * Imagine we are moving down the tree, and assume we are root node. The comparison yields three possibilities,
     * <ol>
     *   <li>Root data is equal to key. We are done, root data is ceil value.</li>
     *   <li>Root data < key value, certainly the ceil value can’t be in left subtree. Proceed to search on right subtree
     * as reduced problem instance.</li>
     *   <li>Root data > key value, the ceil value may be in left subtree. We may find a node with is larger data than key
     * value in left subtree, if not the root itself will be ceil node.</li>
     * </ol>
     * @param root
     * @param key
     * @return
     */
    public int findCeil(TreeNodeInt root, Integer key){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(root.getKey()== key){
            return root.getKey();
        }
        if(root.getKey()<key){
            return findCeil(root.getRight(),key);
        }

        Integer x = findCeil(root.getLeft(),key);
        return x>=key ? x:root.getKey();

    }

    public int findFloor(TreeNodeInt root, Integer key){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(root.getKey()== key){
            return root.getKey();
        }
        if(root.getKey()>key){
            return findFloor(root.getLeft(),key);
        }

        Integer x = findFloor(root.getRight(),key);
        return x<=key ? x:root.getKey();
    }

    public TreeNodeInt sortedArrayToBST(int[] arr){
        if(arr == null || arr.length==0){
            return null;
        }else if(arr.length ==1){
            return new TreeNodeInt(arr[0]);
        }else{
            return sortedArrayToBSTUtil(arr,0,arr.length-1);
        }

    }

    private TreeNodeInt sortedArrayToBSTUtil(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (int)Math.ceil((start+end)/2);
        TreeNodeInt node = new TreeNodeInt(arr[mid]);
        node.left = sortedArrayToBSTUtil(arr,start,mid-1);
        node.right = sortedArrayToBSTUtil(arr, mid+1,end);
        return node;
    }

    public void printTree(TreeNodeInt root){
        if(root == null){
            return;
        }else{
            System.out.print(root.key+" ");
            printTree(root.left);
//            System.out.print(root.key+" ");
            printTree(root.right);
        }
    }

    class GlobalSum{
        int globalSum = 0;
    }
    public void updateBSTWithGreaterValue(TreeNodeInt root){
        if(root == null){
            return;
        }
        GlobalSum gSum = new GlobalSum();
        updateBSTWithGreaterValueUtil(root,gSum);
    }

    private void updateBSTWithGreaterValueUtil(TreeNodeInt node, GlobalSum sum){
        if(node == null){
            return;
        }
        updateBSTWithGreaterValueUtil(node.right,sum);
        node.key = sum.globalSum + node.key;
        sum.globalSum = node.key;
        updateBSTWithGreaterValueUtil(node.left,sum);
    }
}
