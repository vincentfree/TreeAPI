package com.vijfhart.casus.tree;
import java.util.*;

public interface TreeIterator<T extends Node<T>> extends Iterator<T> {
  
  int level();
  void startWith(T t);
  String path(NodeString<T> nodeString , String separator);
  void orderSiblingsBy(Comparator<T> comparator);
  boolean isLeaf();

}
