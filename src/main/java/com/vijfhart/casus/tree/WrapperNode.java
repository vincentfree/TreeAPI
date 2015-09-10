package com.vijfhart.casus.tree;

public abstract class WrapperNode<T extends WrapperNode<T, E>, E extends Comparable<E>> extends AbstractNode<T> {

    private E object;

    protected WrapperNode(E object) {
        this.object = object;
    }

    protected WrapperNode(E object, T parent) {
        this.object = object;
        setParent(parent);
    }

    public E getObject() {
        return object;
    }

    public int compareTo(T other) {
        if (getParent() == null) return -1;
        if (other.getParent() == null) return 1;
        if (this.compareLevelTo(other) > 0) {
            if (getParent() == other) return 1;
            return getParent().compareTo(other);
        }
        if (this.compareLevelTo(other) < 0) {
            if (this == other.getParent()) return -1;
            return this.compareTo(other.getParent());
        }
        if (this.getParent() == other.getParent()) {
            return object.compareTo(other.getObject());
        }
        return this.getParent().compareTo(other.getParent());
    }

    public String toString() {
        return object.toString();
    }
}