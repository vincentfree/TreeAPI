package com.vijfhart.casus.tree;

public abstract class AbstractNode<T extends AbstractNode<T>> implements Node<T> {

  private T parent;
  private int descendantsCount=0;
  
  public void setParent(T t){
    if(isChild(t))
      throw new IllegalArgumentException(String.format("%s is a child of %s, so can't be a parent",t, this));
      this.parent=t;
  }

  protected AbstractNode(){ }


  public T getParent(){
    return parent;
  }

  private boolean isChild(T t){
    T node = t;
    while(node!=null && node.getParent()!=null){
      if(node.getParent()==this) return true;
      node=node.getParent();
    }
    return false;
  }

  public int compareLevelTo(T other){
     if(other==null) return 1;
     if(this.getParent()==null) return -1;
     if(this.getParent()==other.getParent()) return 0;
      return this.getParent().compareLevelTo(other.getParent()); 
  }

  public int compareTo(T other){
    if(getParent()==null) return -1;
    if(other.getParent()==null) return 1;
    if (this.compareLevelTo(other)>0){
      if(getParent()==other) return 1;
      return getParent().compareTo(other);
    }
    if (this.compareLevelTo(other)<0){
      if(this==other.getParent()) return -1;
      return this.compareTo(other.getParent());
    }
    if(this.getParent()==other.getParent()){
      return this.toString().compareTo(other.toString());
    }
    return this.getParent().compareTo(other.getParent());
  }
}

