package com.vijfhart.casus.tree;
import java.util.*;
public interface Tree<T extends Node<T>> extends TreeIterable<T> {

  TreeIterator<T> iterator();
  int descendantSum(T t, NodeInt<T> nodeInt);
  int descendantCount(T t);
  List<T> descendantsOf(T node);
  void add(T t);
  
}
