package com.vijfhart.casus.tree;

import java.util.Collection;

/**
 * Created by a591220 on 29-5-2015.
 */
public interface Tree<E> extends TreeIterable {
    //Collection collection();
    Tree add(E node);

}
