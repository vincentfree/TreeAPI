package com.vijfhart.casus.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 1-6-2015.
 */
public class NodeTreeTest {

    @Test
    public void testAddNewValue() throws Exception {
        NodeTree tree = new NodeTree();
        NameNode node = new NameNode();
        tree.add(node);
        assertEquals(1,tree.getNodeList().size());


    }
}
