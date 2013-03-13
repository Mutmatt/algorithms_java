/**
 * Copyright (c) 2013, Matthew Erickson (Matt@MattErickson.ME)
 * All rights reserved.
 * 
 * Please see copyright.txt for full license details
 **/
package me.matterickson.model;


/**
 * @author Matt@MattErickson.ME
 *
 */
public class GenericNode {
  private int m_index;
  protected String m_value;

  public GenericNode() {
  }

  public GenericNode(int index) {
    setIndex(index);
  }

  public GenericNode(String value) {
    setValue(value);
  }
  
  public GenericNode(String value, int index) {
    setValue(value);
    setIndex(index);
  }

  /**
   * @return the m_value
   */
  public String getValue() {
    return m_value;
  }

  /**
   * @param m_value the m_value to set
   */
  public void setValue(String m_value) {
    this.m_value = m_value;
  }
  
  /**
   * @return the m_index
   */
  public int getIndex() {
    return m_index;
  }

  /**
   * @param m_index the m_index to set
   */
  public void setIndex(int m_index) {
    this.m_index = m_index;
  }

  @Override
  public String toString() {
    return m_value + " " + m_index;
  }
}
