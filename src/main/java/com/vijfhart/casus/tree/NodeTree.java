package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vincent on 1-6-2015.
 */
public class NodeTree implements Tree<NameNode> {

    private NameNode current = new NameNode();

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
                treeIterator = nodeList.iterator();
            }

            public int level() {
                int i = 0;
                current = current.getParent();
                if (current == null) {
                    return 0;
                } else {
                    while (current != null) {
                        i++;
                        current = current.getParent();
                    }

                }
                return i;
            }

            public int getLevel() {
                return level();
            }

            public void startWith(NameNode node) {

            }

            public boolean isLeaf() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return treeIterator.hasNext();
            }

            @Override
            public NameNode next() {
                //current = (NameNode)treeIterator;
                return treeIterator.next();
            }
        };
    }
}