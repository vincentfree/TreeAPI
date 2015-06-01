package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vincent on 1-6-2015.
 */
public class NodeTree implements Tree<NameNode> {

    public List<NameNode> getNodeList() {
        return nodeList;
    }


    private List<NameNode> nodeList = new ArrayList<NameNode>();

    public void add(NameNode node) {
        nodeList.add(node);
    }

    /**
     * @return Iterator or TreeIterator
     */
    public Iterator<NameNode> iterator() {

        return new TreeIterator<NameNode>() {

            private Iterator<NameNode> treeIterator = nodeList.iterator();
            {
                Collections.sort(nodeList);
            }
            public int level() {
                return 0;
            }

            public void startWith(NameNode node) {

            }

            public boolean isLeaf() {
                return false;
            }

            public boolean hasNext() {
                return false;
            }

            public NameNode next() {
                return null;
            }
        };
    }
}