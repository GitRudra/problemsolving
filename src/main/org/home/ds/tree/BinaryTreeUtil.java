package org.home.ds.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeUtil {

    /**
     * There are two types of nodes to be considered.
     * 1) Nodes in the subtree rooted with target node.
     *     For example if the target node is 8 and k is 2,
     *     then such nodes are 10 and 14.
     * 2) Other nodes, may be an ancestor of target,
     *     or a node in some other subtree.
     *     For target node 8 and k is 2,
     *     the node 22 comes in this category.
     *
     * Finding the first type of nodes is easy to implement.
     * Just traverse subtrees rooted with the target node and
     * decrement k in recursive call.
     * When the k becomes 0, print the node currently being traversed
     * (See this for more details).
     * Here we call the function as printkdistanceNodeDown().
     *
     * How to find nodes of second type?
     * For the output nodes not lying in the subtree with the target node as the root,
     * we must go through all ancestors.
     * For every ancestor, we find its distance from target node,
     * let the distance be d, now we go to other subtree
     * (if target was found in left subtree,
     * then we go to right subtree and vice versa) of the ancestor
     * and find all nodes at k-d distance from the ancestor.
     *
     *
     * @param root
     * @param target the node from where the algo find the nodes with distance k
     * @param k the distance from {@code target} node
     * @return
     */
    public int findNodesAtDistanceK(TreeNodeInt root, TreeNodeInt target, int k){
        // Prints all nodes at distance k from a given target node.
        // The k distant nodes may be upward or downward.This function
        // Returns distance of root from target node, it returns -1
        // if target node is not present in tree rooted with root.

        //Base case if root is null
        if(root == null){
            return -1;
        }

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if(root == target){
            printNodeAtDistanceKDown(root,k);
            return 0;
        }

        // Recur for left subtree
        int dl = findNodesAtDistanceK(root.getLeft(),target,k);
        // Check if target node was found in left subtree
        if(dl != -1){
            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if(dl+1 == k){
                System.out.print(root.getKey()+ " ");
            }else{
                // Else go to right subtree and print all k-dl-2 distant nodes
                // Note that the right child is 2 edges away from left child
                printNodeAtDistanceKDown(root.getRight(),k-dl-2);
                return 1+dl;
            }
        }
        // Check if target node was found in right subtree
        int dr = findNodesAtDistanceK(root.getRight(),target,k);
        if(dr != -1){
            if(dr+1 == k){
                System.out.print(root.getKey()+ " ");
            }else{
                printNodeAtDistanceKDown(root.getLeft(),k-dr-2);
                return 1+dr;
            }
        }
        // If target was neither present in left nor in right subtree
        return -1;
    }

    /**
     * Recursive function to print all the nodes at distance k in
     * tree (or subtree) rooted with given root.
     * @param root
     * @param k
     */
    public void printNodeAtDistanceKDown(TreeNodeInt root,int k){
        if(root== null){
           return;
        }
        if(k==0){
            System.out.println(root.getKey());
            return;
        }
        printNodeAtDistanceKDown(root.getLeft(),k-1);
        printNodeAtDistanceKDown(root.getRight(),k-1);
    }

    public TreeNodeInt createTree(){
        TreeNodeInt tree = new TreeNodeInt(20);

        /* Let us construct the tree shown in above diagram */
        tree.left = new TreeNodeInt(8);
        tree.right = new TreeNodeInt(22);
        tree.left.left = new TreeNodeInt(4);
        tree.left.right = new TreeNodeInt(12);
        tree.left.right.left = new TreeNodeInt(10);
        tree.left.right.right = new TreeNodeInt(14);
        return tree;
    }

    private boolean foundNode = false;

    /**
     * Find the path from a given key
     * @param root
     * @param path
     * @param key
     */
    public void findPath(TreeNodeInt root, LinkedList<TreeNodeInt> path, Integer key){
        if(root == null){
            return;
        }
        if(root.getKey() == key){
            path.addFirst(root);
            foundNode = true;
            return;
        }
        if(!foundNode){
            findPath(root.getLeft(),path, key);
        }
        if(!foundNode){
            findPath(root.getRight(),path,key);
        }
        if(foundNode){
            path.addFirst(root);
        }
    }

    public static void main(String[] args) {
        BinaryTreeUtil util = new BinaryTreeUtil();
//        util.execute();
        util.executeTwo();
    }

    public void execute(){
        TreeNodeInt root  = createTree();
        TreeNodeInt target = root.left;
        findNodesAtDistanceK(root,target,2);
    }

    public void executeTwo(){
        TreeNodeInt root = createTree();
        LinkedList<TreeNodeInt> path  = new LinkedList<>();
        findPath(root,path,10);
        path.stream().forEach(e-> System.out.println(e.key+" "));

    }
}
