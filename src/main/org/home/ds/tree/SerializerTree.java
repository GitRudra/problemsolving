package org.home.ds.tree;

import java.util.ArrayList;

/**
 * Serialization is to store tree in a file so that it can be later restored.
 * The structure of tree must be maintained.
 * Deserialization is reading tree back from file.
 *
 * Following are some simpler versions of the problem:
 *
 * If given Tree is Binary Search Tree?
 * If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder traversal. In case of Binary Search Trees, only preorder or postorder traversal is sufficient to store structure information.
 *
 * If given Binary Tree is Complete Tree?
 * A Binary Tree is complete if all levels are completely filled except possibly the last level and all nodes of last level are as left as possible (Binary Heaps are complete Binary Tree). For a complete Binary Tree, level order traversal is sufficient to store the tree. We know that the first node is root, next two nodes are nodes of next level, next four nodes are nodes of 2nd level and so on.
 *
 * If given Binary Tree is Full Tree?
 * A full Binary is a Binary Tree where every node has either 0 or 2 children. It is easy to serialize such trees as every internal node has 2 children. We can simply store preorder traversal and store a bit with every node to indicate whether the node is an internal node or a leaf node.
 *
 * How to store a general Binary Tree?
 * A simple solution is to store both Inorder and Preorder traversals. This solution requires requires space twice the size of Binary Tree.
 * We can save space by storing Preorder traversal and a marker for NULL pointers.
 */
public class SerializerTree {
    private final int INF = -99999;
    private int index=-1;
    public void serialize(TreeNodeInt root, ArrayList<Integer> list){
        if(root == null){
            list.add(INF);
            return;
        }else{
            list.add(root.key);
        }
        serialize(root.left,list);
        serialize(root.right,list);
    }

    public TreeNodeInt deSerialize(ArrayList<Integer>list){
        TreeNodeInt temp = null;
        index++;
        if(index<list.size()){
            if(list.get(index) != INF){
                temp = new TreeNodeInt(list.get(index));
                temp.setLeft(deSerialize(list));
                temp.setRight(deSerialize(list));
            }


        }
        return temp;
    }

    public void print(TreeNodeInt root){
        if(root==null){
            return;
        }
        print(root.left);
        System.out.print(root);
        print(root.right);
    }
}
