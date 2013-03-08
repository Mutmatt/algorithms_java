/**
 * Copyright (c) 2013, Matthew Erickson (Matt@MattErickson.ME)
 * All rights reserved.
 * 
 * Please see copyright.txt for full license details
 **/
package me.matterickson.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.matterickson.Global;
import me.matterickson.exception.BadInput;
import me.matterickson.model.Node;

/**
 * @author Matt@MattErickson.ME
 */
public class TreeLength {
  private int m_searchLength;
  private static final int MAXCONNECTEDDEPTH = 15;
  
  /**
   * Default constructor
   */
  public TreeLength() {
    new TreeLength(new Random().nextInt(5));
  }
  
  /**
   * constructor with the length of our search
   * @param size
   */
  public TreeLength(int size) {
    m_searchLength = size;
  }
  
  public Node heavyLifting(String value, Integer passedSearch) throws BadInput, InterruptedException {
    if (passedSearch == null) {
      passedSearch = m_searchLength;
    }
    if (value == null || value == "") {
      throw new BadInput("Value must not be null");
    }
    System.out.println("Searching the tree for a set of [" + passedSearch + "] nodes with value [" + value + "]");
    
    List<Node> allNodes = populateNodes(value);
    
    if (Global.DEBUG) {
      System.out.println("Now, for conveinence, we will give you a \"show\" of what our list looks like... Ready? [" + allNodes.size() + "]");
      Thread.sleep(1000);
      for (Node node : allNodes) {
        System.out.print(node + " ^ ");
      }
      System.out.println();
      
      int counter = 0;
      while (counter < MAXCONNECTEDDEPTH) {
        for (Node node : allNodes) {
          try {
            System.out.print(node.getEdges().get(counter) + " ^ ");
          } catch (Exception e) {
            System.out.print("Empty spot ^ ");
          }
        }
        System.out.println();
        counter++;
      }
    }
    
    //Now lets find the actual string of expected strings
    for (Node node : allNodes) {
      int foundDepthCounter = 0;
      if (node.getValue().equals(value)) {
        foundDepthCounter++;
        if (foundDepthCounter >= m_searchLength) {
          return node;
        }
        for (Node edgeNode : node.getEdges()) {
          if (edgeNode.getValue().equals(value)) {
            foundDepthCounter++;
            if (foundDepthCounter >= m_searchLength) {
              return node;
            }
          }
        }
      }
    }
    return null;
  }
  
  private List<Node> populateNodes(String value) {
    Random randomGenerator = new Random();
    int returnNodeSize = randomGenerator.nextInt(100);
    List<Node> returnNodes = new ArrayList<Node>(returnNodeSize);
    while (returnNodeSize > 0) {
      Node thisNode = setNodeValue(randomGenerator, value, returnNodes.size());
      int connectedNodeSize = randomGenerator.nextInt(MAXCONNECTEDDEPTH);
      while (connectedNodeSize > 0) {
        if (randomGenerator.nextInt(3) == 1) {
          Node connectedNode = setNodeValue(randomGenerator, value, thisNode.getEdges().size() + 1);
          thisNode.getEdges().add(connectedNode);
          connectedNodeSize--;
        }
      }
      returnNodes.add(thisNode);
      returnNodeSize--;
    }
    return returnNodes;
  }
  
  private Node setNodeValue(Random random, String value, int indexInList) {
    Node node = new Node(indexInList);
    if (random.nextInt(3) == 1) {
      node.setValue(value);
    } else {
      node.setValue("NOT " + value);
    }
    return node;
  }
}
