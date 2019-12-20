package org.home.ds.tree;

public class DistanceBetweenTwoKeyCalculator {
    private int d1;
    private int d2;
    private int dist;

    private int findLevel(TreeNodeInt root,int key, int level){
        if(root == null){
            return -1;
        }
        if(root.getKey() == key){
            return level;
        }
        int l = findLevel(root.getLeft(),key,level+1);

        return (l!=-1)?l:findLevel(root.getRight(),key,level+1);
    }

    /**
     *
     * @param root
     * @param k1
     * @param k2
     * @param lvl
     * @return
     */
    private TreeNodeInt findDistanceUtil(TreeNodeInt root, int k1, int k2, int lvl){
        if (root == null)
            return null;

        if(root.getKey() == k1){
            d1 = lvl;
            return root;
        }

        if(root.getKey() == k2){
            d2 = lvl;
            return root;
        }

        TreeNodeInt left_lca = findDistanceUtil(root.getLeft(),k1,k2,lvl+1);
        TreeNodeInt right_lca = findDistanceUtil(root.getRight(), k1, k2, lvl+1);

        if(left_lca != null && right_lca != null){
            dist = d1+d2 - 2*lvl;
            return root;
        }
        return (left_lca!=null)?left_lca:right_lca;
    }

    /**
     *
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    public int findDistance(TreeNodeInt root, int k1, int k2){
        d1 = -1;
        d2 = -1;
        dist = 0;
        TreeNodeInt lca = findDistanceUtil(root,k1,k2,1);
        if(d1 != -1 && d2 != -1){
            return dist;
        }
        if(d1 != -1){
            return findLevel(lca,k2,0);
        }
        if(d2 != -1){
            return findLevel(lca,k1,0);
        }

        return -1;
    }
}
