/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sid
 */
public class Test_11988 {
  
  //keep an index, where to insert to the list
  //whent you get [, reset the insert pointer to 0
  //when you get ], reset the insert pointer to list.size()
  //for everything else, insert the character at pointer, increment the pointer
  
  public static void main(String args[]){
    testLL();
  }
  
  static void testLL(){
    List l = new LinkedList<Character>();
    l.add(0, '0');
    l.add(1, '1');
    l.add(2, '3');
    l.add(2, '2');
    pLL(l);
  }
  
  static void pLL(List<Character> l){
    String s = "";
    for(char i : l){
      s = s + " " + i;
    }
    System.out.println(s);
  }
  
  static int getNextIndex(char ch, int curIndex, int size){
    int index = curIndex + 1;
    if(ch == '['){
      index = 0;
    }else if( ch == ']'){
      index = size;
    }
    return index;
  } 
}
