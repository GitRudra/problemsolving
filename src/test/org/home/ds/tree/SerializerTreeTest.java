package org.home.ds.tree;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SerializerTreeTest {

    @Test
    public void testSerializeDeserializeOne() {
        TreeNodeInt root = new TreeNodeInt(12);
        root.left = new TreeNodeInt(13);
        ArrayList<Integer> list = new ArrayList();
        SerializerTree treeSerializer = new SerializerTree();
        System.out.println("Original Tree---");
        treeSerializer.print(root);
        treeSerializer.serialize(root,list);
        TreeNodeInt cloned = treeSerializer.deSerialize(list);
        System.out.println("\n Cloned Tree---");
        treeSerializer.print(cloned);
        //root.right = new TreeNodeInt(22);
        //root.
    }

    @Test
    public void testSerializeDeserializeTwo() {
        TreeNodeInt root = new TreeNodeInt(20);
        root.left = new TreeNodeInt(8);
        root.right = new TreeNodeInt(22);
        ArrayList<Integer> list = new ArrayList();
        SerializerTree treeSerializer = new SerializerTree();
        System.out.println("Original Tree---");
        treeSerializer.print(root);
        treeSerializer.serialize(root,list);
        TreeNodeInt cloned = treeSerializer.deSerialize(list);
        System.out.println("\n Cloned Tree---");
        treeSerializer.print(cloned);
        //root.right = new TreeNodeInt(22);
        //root.
    }

    @Test
    public void testSerializeDeserializeThree() {
        TreeNodeInt root = new TreeNodeInt(20);
        root.left = new TreeNodeInt(8);
        root.left.right = new TreeNodeInt(12);
        root.left.left = new TreeNodeInt(4);
        root.left.right.left = new TreeNodeInt(10);
        root.left.right.right = new TreeNodeInt(14);

        ArrayList<Integer> list = new ArrayList();
        SerializerTree treeSerializer = new SerializerTree();
        System.out.println("Original Tree---");
        treeSerializer.print(root);
        treeSerializer.serialize(root,list);
        TreeNodeInt cloned = treeSerializer.deSerialize(list);
        System.out.println("\n Cloned Tree---");
        treeSerializer.print(cloned);
        //root.right = new TreeNodeInt(22);
        //root.
    }
}