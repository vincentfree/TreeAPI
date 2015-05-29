package com.vijfhart.casus.tree;

/**
 * Created by Vincent Free on 29-5-2015.
 */
public interface LevelComparable <T> {
    /**
     * @param node node wordt doorgegeven vanuit Node
     * */
    public abstract int compareLevelTo(T node);
}