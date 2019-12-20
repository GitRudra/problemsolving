package org.home.ds.tree;

import java.util.HashSet;

public class LowestCommonAncestor {

    /**
     * Flag to control recursion if the key is found.
     * i.e. if the key is found then it will not go to lower level.
     */
    private boolean found = false;
    public static final int NOT_FOUND = -9999;

    /**
     * Find the path from root to key if exist.
     * If the key exist then it store the path from root to key in the
     * HashSet <code>path</code>
     * @param root root node
     * @param path - {@link HashSet} to store the path.
     * @param key - the search key
     */
    private void findPath(TreeNodeInt root, HashSet<TreeNodeInt> path, int key){
        if(root == null){
            return;
        }
        //set the flag found to true if the key found.
        if(root.key == key){
            path.add(root);
            found = true;
            return;
        }

        //skip lower level explore if key is already found
        if(!found){
            findPath(root.left,path,key);
        }
        //skip lower level explore if key is already found
        if(!found){
            findPath(root.right,path,key);
        }
        //add root to path
        if(found){
            path.add(root);
        }
    }

    private TreeNodeInt findLCAHelper(TreeNodeInt root, HashSet<TreeNodeInt> path, int key){
        if(root == null){
            return root;
        }
        if(root.key == key){
            found = true;
            return path.contains(root) ? root : null;
        }
        TreeNodeInt n = null;
        if(!found){
            n = findLCAHelper(root.left,path,key);
        }
        if(!found){
            n = findLCAHelper(root.right,path,key);
        }

        if(found){
            if(n == null){
                return path.contains(root) ? root:null;
            }
        }
        return n;
    }

    public Integer findLCA(TreeNodeInt root, int key1, int key2){
        if(root == null){
            return NOT_FOUND;
        }
        HashSet<TreeNodeInt> pathForFirstKey = new HashSet<>();
        findPath(root,pathForFirstKey,key1);
        if(pathForFirstKey.isEmpty()){
            return NOT_FOUND;
        }
        found = false;
        TreeNodeInt lca = findLCAHelper(root,pathForFirstKey,key2);
        return lca == null ? NOT_FOUND : lca.key;
    }


}
