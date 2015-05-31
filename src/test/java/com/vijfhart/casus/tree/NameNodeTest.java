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
    public void testNameRetrieval(){
        NameNode nameNode = new NameNode("testNaam");
        assertEquals("testNaam", nameNode.getNaam());
        System.out.println(nameNode.getNaam());
    }
    public void testParentRetrieval(){
        NameNode nameNode = new NameNode("testnaam", new NameNode());
        assertEquals(nameNode,nameNode.getParent());

    }
}
