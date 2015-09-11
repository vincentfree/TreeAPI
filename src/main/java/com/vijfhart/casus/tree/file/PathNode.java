package com.vijfhart.casus.tree.file;

import com.vijfhart.casus.tree.Node;
import com.vijfhart.casus.tree.WrapperNode;
import java.nio.file.Path;

/**
 * Created by Vincent Free on 10-9-2015.
 */
public class PathNode extends WrapperNode<PathNode, Path> {
    protected Path path;
    //T obj;
    protected PathNode(Path object, PathNode pathNode) {
        super(object,pathNode);
    }
}