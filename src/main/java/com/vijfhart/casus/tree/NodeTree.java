package com.vijfhart.casus.tree;
import java.util.*;

public class NodeTree<T extends Node<T>> implements Tree<T> {
  

  private ArrayList<T> nodeList = new ArrayList<>();


  public NodeTree(){}

  public NodeTree(List<T> tree){
    nodeList=new ArrayList<T>();
    for(T t:tree){
       nodeList.add(t);
    }
  }


  public void add(T t){
     nodeList.add(t);
  }


  public List<T> descendantsOf(T node){
    NodeTree<T> copy = new NodeTree<>(nodeList);
    TreeIterator<T> iterator = copy.iterator();
    iterator.startWith(node);
    List<T> list = new ArrayList<>();
    while(iterator.hasNext()){
      list.add(iterator.next());
    }
    return list;
  }

  public int descendantCount(T t){
    List<T> list = descendantsOf(t);
 /*   int count=0;
    for(T node: list){
      count+=node.descendantCount();
    }
    return count;
  */
    return descendantsOf(t).size()-1;
  }


  public int descendantSum(T t, NodeInt<T> nodeInt){
    List<T> list = descendantsOf(t);
    int sum=0;
    for(T node: list){
      sum+=nodeInt.get(node);
    }
    return sum;
  }

  public double descendantSum(T t, NodeDouble<T> nodeInt){
    List<T> list = descendantsOf(t);
    double sum=0;
    for(T node: list){
      sum+=nodeInt.get(node);
    }
    return sum;
  }

  public TreeIterator<T> iterator(){
     return new TreeIterator<T>(){
         
         private Iterator<T> iterator=nodeList.iterator(); 
         private T current;
         private List<T> ancestors = new ArrayList<>();
         private boolean nextCalled;
         private T startWith;
         private boolean started;
         private TreeComparator<T> treeComparator = new TreeComparator<>();

         {
          Collections.sort(nodeList);
          iterator = nodeList.iterator();
         }


         public void startWith(T startWith){
           if(started)
             throw new IllegalStateException(
              "startWith can only be called before the first call to next");
           List<T> list=new ArrayList<>();
           this.startWith=startWith;
           T node = null;
           while(iterator.hasNext()){
              node = iterator.next();
              if(childOfStartWith(node))
                list.add(node);
            }
           this.iterator=list.iterator();
           started=true;
         }

         public void orderSiblingsBy(Comparator<T> comparator){
           
           this.treeComparator.orderSiblingsBy(comparator);
           Collections.sort(nodeList, treeComparator);
           iterator=nodeList.iterator();
         }

         private boolean childOfStartWith(T t){
           T node = t;
           if(node == startWith) return true;
           while(node.getParent() != null){
             if(node.getParent()==startWith) return true;
             node=node.getParent();
           }
           return false;
         }

         public boolean hasNext(){
           return iterator.hasNext();
         }

         public T next(){
           if(iterator.hasNext()){
             ancestors.clear();
             current=iterator.next();
             fillAncestors(current);
             nextCalled=true;
             started=true;
             return current;
           }
           else throw new IllegalStateException("Last element has been reached");
         }

         public int descendantCount(){
           return NodeTree.this.descendantCount(current);
         }

         public int level(){
           return ancestors.size();
         }
         
         private void fillAncestors(T t){
           if(t==startWith) return ;
           T node=t;
           while(node.getParent()!=null){
             if(node.getParent()==startWith){
               ancestors.add(node.getParent());
               return;
             }
             ancestors.add(node.getParent());
             node=node.getParent();
           }
         }

         public boolean isLeaf(){
           return descendantsOf(current).size()==1;
         }

         public void remove(){
            if(nextCalled){
              if(isLeaf()){
                nodeList.remove(current);
                iterator.remove();
                nextCalled=false;
              }
              else {
                throw new RuntimeException(String.format( "%s is a parent, so can't be removed", current));
              }
            }
            else {
              throw new IllegalStateException("remove can only be called after a call to next");
            }
         }

         public String path(NodeString<T> nodeString, String separator){
           StringBuilder sb = new StringBuilder();
           //T t = current;
           //for(int i=0;i<=level();i++){
           sb.append(new StringBuilder(separator).append(nodeString.get(current)));
           for(T t:ancestors){
              sb.insert(0,new StringBuilder(separator).append(nodeString.get(t)));
            //  t=t.getParent();
           }

           return sb.toString();
         }

     };
  }


}

