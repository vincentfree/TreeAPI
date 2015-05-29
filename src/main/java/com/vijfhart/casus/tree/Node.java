package com.vijfhart.casus.tree;

/**
 * Created by a591220 on 29-5-2015.
 */
public interface Node <E extends Node<E>> {

    public E getParent();
    public E setParent();
}
