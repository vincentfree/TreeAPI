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

            /**
             * Removes from the underlying collection the last element returned
             * by this iterator (optional operation).  This method can be called
             * only once per call to {@link #next}.  The behavior of an iterator
             * is unspecified if the underlying collection is modified while the
             * iteration is in progress in any way other than by calling this
             * method.
             *
             * @throws UnsupportedOperationException if the {@code remove}
             *                                       operation is not supported by this iterator
             * @throws IllegalStateException         if the {@code next} method has not
             *                                       yet been called, or the {@code remove} method has already
             *                                       been called after the last call to the {@code next}
             *                                       method
             * @implSpec The default implementation throws an instance of
             * {@link UnsupportedOperationException} and performs no other action.
             */
            @Override
            public void remove() {
                
            }
        };
    }
}