package com.vijfhart.casus.tree;

/**
 * Created by Vincent Free on 29-5-2015.
 */
public interface Node <E extends Node<E>> extends Comparable <E>, LevelComparable<E> {
    /** get parent van node*/
    E getParent();
    /** set parent van node*/
    void setParent(E node);
    /** geeft aan of het een leaf node betreft*/
    boolean isLeaf();
}