package com.vijfhart.casus.tree.file;

import com.vijfhart.casus.tree.WrapperNode;

import java.nio.file.Path;

/**
 * Created by Vincent Free on 10-9-2015.
 */
public class PathNode extends WrapperNode {
    protected Path path;

    protected PathNode(Comparable object) {
        super(object);
    }
}