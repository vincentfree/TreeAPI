package com.vijfhart.casus.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Vincent on 1-6-2015.
 */
public class TreeApp {

    public static void main(String[] args) {

        NameNode nodePieters = new NameNode("Pieters");
        NameNode nodeSanders = new NameNode("Sanders", nodePieters);
        NameNode nodeVermeulen = new NameNode("Vermeulen", nodePieters);
        NameNode nodeAdelaar = new NameNode("Adelaar", nodeSanders);
        NameNode nodeSmits = new NameNode("Smits", nodeVermeulen);

        NodeTree nameNodeList = new NodeTree();

        nameNodeList.add(nodeSmits);
        nameNodeList.add(nodeAdelaar);
        nameNodeList.add(nodeVermeulen);
        nameNodeList.add(nodePieters);
        nameNodeList.add(nodeSanders);
        nameNodeList.iterator();
        System.out.println(nameNodeList.getNodeList());
        System.out.println(nameNodeList.getNodeList());
       /* for (NameNode node : nameNodeList) {
            System.out.println(node);
        }*/
    }
}