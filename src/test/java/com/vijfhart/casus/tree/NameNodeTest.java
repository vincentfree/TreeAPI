package com.vijfhart.casus.tree;

import com.vijfhart.casus.tree.NameNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vincent on 31-5-2015.
 */
public class NameNodeTest {
    @Test
    @Category(com.vijfhart.casus.tree.NameNode.class)
    public void testNameRetrieval() {
        NameNode nameNode = new NameNode("testNaam");
        assertEquals("testNaam", nameNode.getName());
    }

    @Test
    public void testToString() throws Exception {
        NameNode nameNode = new NameNode("testNaam");
        assertEquals("NameNode " + nameNode.getName(), nameNode.toString());
    }

    /*@Test
        @Category(com.vijfhart.casus.tree.NameNode.class)
        public void testParentRetrieval(){
            NameNode nameNode = new NameNode("testnaam", new NameNode(""));
            assertEquals(nameNode,nameNode.getParent());

        }*/

    @Test
    public void testSetParent() throws Exception {
        NameNode nameNode = new NameNode("testnode");
        NameNode nameNode1 = new NameNode("ChildNode");
        nameNode1.setParent(nameNode);
        assertEquals(nameNode,nameNode1.getParent());

    }

    @Test
    public void testEquals() {
        NameNode node = new NameNode("test");
        NameNode node1 = new NameNode("test");
        assertEquals(true, node.equals(node1));
        assertEquals(false, node1.equals(new Object()));
    }
}
