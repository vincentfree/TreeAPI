package com.vijfhart.casus.tree.file;

import com.vijfhart.casus.tree.Node;
import com.vijfhart.casus.tree.WrapperNode;

import java.nio.file.Path;

/**
 * Created by Vincent Free on 10-9-2015.
 */
public class PathNode<T extends Node<T>> extends WrapperNode {
    protected Path path;
    //T obj;
    protected PathNode(Comparable object) {
        super(object);
    }
}