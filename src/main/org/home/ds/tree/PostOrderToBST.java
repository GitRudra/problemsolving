package org.home.ds.tree;


public class PostOrderToBST {
    public static void main(String[] args) {
        int[] input = {1, 7, 5, 50, 40, 10};
        PostOrderToBST pob = new PostOrderToBST();
        TreeNodeInt node = pob.postOrderToBST(input, 0, input.length-1);
        pob.displayTree(node);
    }

    public void displayTree(TreeNodeInt root){
        if(root== null){
            return;
        }
        displayTree(root.getLeft());
        System.out.print(root.getKey()+" ");
        displayTree(root.getRight());
    }

    public TreeNodeInt postOrderToBST(int[] preorder, int start, int end){
        TreeNodeInt node = null;
        if(start>end){
            return node;
        }else if(start==end){
            return new TreeNodeInt(preorder[start]);
        }else{
            node = new TreeNodeInt(preorder[end]);
            int pos=-1;
            for(int i=start;i<end;i++){
                if(preorder[i]>preorder[end]){
                    pos = i;
                    break;
                }
            }
            if(pos<end){
                node.setLeft(postOrderToBST(preorder, start, pos-1));
                node.setRight(postOrderToBST(preorder, pos, end-1));
            }

        }
        return node;

    }
}
