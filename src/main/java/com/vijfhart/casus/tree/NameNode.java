package com.vijfhart.casus.tree;

/**
 * Created by Vincent Free on 29-5-2015.
 */
public class NameNode implements Node<NameNode> {

    private String naam;
    private NameNode parent;

    public NameNode() {
    }

    public NameNode(String naam) {
        this.naam = naam;
    }

    /**
     * @param naam naam van de node
     * @param node de node die je mee geeft?
     */
    public NameNode(String naam, NameNode node) {
        this.naam = naam;
        this.parent = node;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * get parent van node
     */
    public NameNode getParent() {
        return parent;
    }

    /**
     * set parent van node
     *
     * @param node
     */
    public void setParent(NameNode node) {
        this.parent = node;
    }

    /**
     * geeft aan of het een leaf node betreft
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    public int compareTo(NameNode o) {
        return compareLevelTo(o);
    }

    /**
     * @param node node wordt doorgegeven vanuit Node
     */
    public int compareLevelTo(NameNode node) {
        if (this.getParent() == node.getParent()) return 0;
        if (this.getParent() == null) return -1;
        if (node.getParent() == null) return 1;
        return this.getParent().compareTo(node.getParent());
    }

    @Override
    public String toString() {
        return "NameNode "+this.getNaam();
    }

    @Override
    public boolean equals(Object object) {
        //object
        if (object instanceof NameNode) {
            NameNode nn = (NameNode) object;
            if (this.naam.equals(nn.getNaam())) {
                return true;
            }
        }
        return false;
    }

}
