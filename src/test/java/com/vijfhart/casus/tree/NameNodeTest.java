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
        assertEquals("testNaam", nameNode.getNaam());
    }

    @Test
    public void testToString() throws Exception {
        NameNode nameNode = new NameNode();
        assertEquals("NameNode " + nameNode.getNaam(), nameNode.toString());
    }

    /*@Test
        @Category(com.vijfhart.casus.tree.NameNode.class)
        public void testParentRetrieval(){
            NameNode nameNode = new NameNode("testnaam", new NameNode(""));
            assertEquals(nameNode,nameNode.getParent());

        }*/


    @Test
    @Category(com.vijfhart.casus.tree.NameNode.class)
    public void testSetNaam() throws Exception {
        NameNode nameNode = new NameNode("testnaam");
        nameNode.setNaam("andereNaam");
        assertEquals("andereNaam", nameNode.getNaam());
    }

    @Test
    public void testIsLeaf() throws Exception {
        NameNode nameNode = new NameNode();
        assertEquals(false, nameNode.isLeaf());
    }

    @Test
    public void testEquals() {
        NameNode node = new NameNode("test");
        NameNode node1 = new NameNode("test");
        assertEquals(true, node.equals(node1));
        assertEquals(false, node1.equals(new Object()));
    }
}
