package com.vijfhart.casus.tree;
import java.util.*;

public class test{
  public static void main (String args[]){


    NameNode a = new NameNode("a",null);
    NameNode b = new NameNode("b",a);
    NameNode c = new NameNode("c",b);
    NameNode d = new NameNode("d",a);
    NameNode e = new NameNode("e",b);
    NameNode f = new NameNode("f",e);
    final NodeTree<NameNode> list = new NodeTree<>();
    list.add(b);
    list.add(a);
    list.add(e);
    list.add(c);
    list.add(f);
    list.add(d); 
    
    TreeIterator<NameNode> iterator = list.iterator();

    NodeString<NameNode> nodeName = new NodeString<NameNode>(){
      public String get(NameNode node){
        return node.getName();
      }
    };
    NodeInt<NameNode> nameLength = new NodeInt<NameNode>(){
      public int get(NameNode node){
        return node.getName().length();
      }
    };
    Comparator<NameNode> comparator = new Comparator<NameNode>(){
      public int compare(NameNode first, NameNode other){
        return other.getName().compareTo(first.getName());
      }
    };
    iterator.orderSiblingsBy(comparator);
    iterator.startWith(a);
    while(iterator.hasNext()){
      NameNode node=iterator.next();
     // if(node==e)iterator.remove();
      System.out.println(node + " " + iterator.level() + " " + 
                         list.descendantCount(node)+ " "+ 
                         iterator.path(nodeName,"/")+ " " +
                         iterator.isLeaf());
    }


    
  }

 
}

