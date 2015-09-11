package com.vijfhart.casus.tree.file;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nerom on 11-9-2015.
 */
public class TestFileTree {
    @Test
    public void testGetPathName() throws Exception {
        FileTree fileTree = new FileTree("C:\\Users\\nerom\\IdeaProjects\\TreeAPI\\src\\main\\resources\\werknemers.txt");
        assertEquals("C:\\Users\\nerom\\IdeaProjects\\TreeAPI\\src\\main\\resources\\werknemers.txt",fileTree.getPathName());
    }
}
