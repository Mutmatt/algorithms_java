/**
 * Copyright (c) 2013, Matthew Erickson (Matt@MattErickson.ME)
 * All rights reserved.
 * 
 * Please see copyright.txt for full license details
 **/
package me.matterickson.model;

/**
 * @author "Matt@MattErickson.ME"
 *
 */
public class TreeNode {
  private TreeNode m_left;
  private TreeNode m_right;
  private int m_value;
  private String m_message;
  
  public TreeNode(int value, String message) {
    setValue(value);
    setMessage(message);
  }

  public TreeNode() {
  }

  public TreeNode(int value) {
    setValue(value);
  }

  public TreeNode(TreeNode left, TreeNode right) {
    m_left = left;
    m_right = right;
  }

  public TreeNode getLeft() {
    return m_left;
  }

  public void setLeft(TreeNode left) {
    m_left = left;
  }

  public TreeNode getRight() {
    return m_right;
  }

  public void setRight(TreeNode right) {
    m_right = right;
  }
  
  public void setValue(int value) {
    m_value = value;
  }

  public String getMessage() {
    return m_message;
  }

  public void setMessage(String message) {
    m_message = message;
  }

  public int getValue() {
    return m_value;
  }
  
  @Override
  public String toString() {
    return m_value + " " + m_message;
  }
}
