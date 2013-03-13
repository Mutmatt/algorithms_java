/**
 * Copyright (c) 2013, Matthew Erickson (Matt@MattErickson.ME)
 * All rights reserved.
 * 
 * Please see copyright.txt for full license details
 **/
package me.matterickson;

import java.util.Random;

import me.matterickson.exception.BadInput;
import me.matterickson.model.Node;
import me.matterickson.problems.BinarySearch;
import me.matterickson.problems.TreeLength;

/**
 * @author Matt@MattErickson.ME
 */
public class Run {
  public static Random m_random = new Random();
  
  public static void main(String[] args) {
    TreeLength treeAlg = new TreeLength(2);
    Node node = null;
    try {
      node = treeAlg.heavyLifting("yerp", null);
    } catch (BadInput | InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(node == null ? "None found" : node);
    if (node != null) {
      for (Node edgeNode : node.getEdges()) {
        System.out.println(edgeNode); 
      }
    }
    
    System.out.println("Starting B-Search building and searching!");
    BinarySearch bSearch = new BinarySearch();
    bSearch.runSearch(m_random.nextInt(500));
    
  }
}
