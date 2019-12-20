package org.home.ds.tree;

public class DistributeCandiInTree {
    public int distributeCandy(TreeNodeInt root){
        if(root==null){
            return -1;
        }
        Answer ans  = new Answer();
        distributeUtil(root,ans);
        return ans.ans;
    }

    private int distributeUtil(TreeNodeInt root, Answer a){
        if(root == null){
            return 0;
        }

        int l = distributeUtil(root.getLeft(), a);
        int r = distributeUtil(root.getRight(), a);

        a.ans += Math.abs(l)+Math.abs(r);

        return root.key+l+r -1;
    }
}

class Answer{
    public int ans;
    public Answer(){
        ans = 0;
    }
}

