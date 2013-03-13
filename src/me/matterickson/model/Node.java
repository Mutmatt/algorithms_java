/**
 * Copyright (c) 2013, Matthew Erickson (Matt@MattErickson.ME)
 * All rights reserved.
 * 
 * Please see copyright.txt for full license details
 **/
package me.matterickson.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matt@MattErickson.ME
 *
 */
public class Node extends GenericNode {
  private List<Node> m_edgeNodes = new ArrayList<Node>();
  
  public Node() {
    super();
  }
  
  public Node(int index) {
    super(index);
  }

  public Node(String value) {
    super(value);
  }
  
  public Node(List<Node> nodes) {
    m_edgeNodes.addAll(nodes);
  }
  
  public Node(String value, List<Node> nodes) {
    setValue(value);
    m_edgeNodes.addAll(nodes);
  }
  
  public void setEdges(List<Node> nodes) {
    m_edgeNodes.addAll(nodes);
  }
  
  public List<Node> getEdges() {
    return m_edgeNodes;
  }
}
