package com.vijfhart.casus.tree.file;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by nerom on 11-9-2015.
 */
public class TestPathNode {

    @Test
    public void testgetPathNode() throws Exception {
        Path path = Paths.get("C:\\Users\\nerom\\IdeaProjects\\TreeAPI\\src\\main\\resources\\werknemers.txt");
        PathNode pathNode = new PathNode(path);
        assertEquals(path, pathNode.getPath());

    }

    @Test
    public void testsetPathNode() throws Exception {
        Path path = Paths.get("C:\\Users\\nerom\\IdeaProjects\\TreeAPI\\src\\main\\resources\\werknemers.txt");
        PathNode pathNode = new PathNode(path, new PathNode(Paths.get("test.xml")));
        pathNode.setPath(Paths.get("test.xml"));
        assertNotEquals(path, pathNode.getPath());
        assertEquals(Paths.get("test.xml"), pathNode.getPath());

    }
}
