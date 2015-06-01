package com.vijfhart.casus.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 1-6-2015.
 */
public class NodeTreeTest {

    NameNode nodePieters = new NameNode("Pieters");
    NameNode nodeSanders = new NameNode("Sanders", nodePieters);
    NameNode nodeVermeulen = new NameNode("Vermeulen", nodePieters);
    NameNode nodeAdelaar = new NameNode("Adelaar", nodeSanders);

    @Test
    public void testAddNewValue() throws Exception {
        NodeTree tree = new NodeTree();
        NameNode node = new NameNode();
        tree.add(node);
        assertEquals(1,tree.getNodeList().size());
    }
    @Test
    public void testTreeIterator(){
        NodeTree tree = new NodeTree();
        tree.add(new NameNode("Jan"));
        tree.add(nodePieters);
        tree.add(nodeAdelaar);
        tree.add(nodeVermeulen);
        tree.iterator();

    }
}
