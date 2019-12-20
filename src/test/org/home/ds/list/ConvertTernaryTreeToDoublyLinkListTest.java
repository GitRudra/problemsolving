package org.home.ds.list;

import org.home.ds.tree.TernaryTree;
import org.home.ds.tree.TernaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertTernaryTreeToDoublyLinkListTest {

    @Test
    public void testCreateDoubleLinkList() {
        TernaryTree tree = new TernaryTree();
        TernaryTreeNode root = tree.createTernaryTree();
        ConvertTernaryTreeToDoublyLinkList converter = new ConvertTernaryTreeToDoublyLinkList();
        converter.createDoubleLinkList(root);
        converter.printDoublyList(converter.getHead());
    }
}