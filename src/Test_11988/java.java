/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_11988;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sid
 */
public class java {
  
  //keep an index, where to insert to the list
  //whent you get [, reset the insert pointer to 0
  //when you get ], reset the insert pointer to list.size()
  //for everything else, insert the character at pointer, increment the pointer
  int getIndex(char currentChar, int curIndex, int listSize){
    return 0;
  }
  
  public static void main(String args[]){
    testLL();
  }
  
  static void testLL(){
    List l = new LinkedList<Integer>();
    l.add(0, 0);
    l.add(1, 1);
    l.add(2, 3);
    l.add(2, 2);
    l.add(0, -1);
    pLL(l);
  }
  
  static void pLL(List<Integer> l){
    String s = "";
    for(int i : l){
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
