/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

/**
 *
 * @author sid
 */
public class Test_594 {
  
  public static void main(String args[]){
    pn(decimalTo32BitBinary(0));
    pn(decimalTo32BitBinary(10));
    pn(decimalTo32BitBinary(7));
    pn(decimalTo32BitBinary(8));
  }
  
  public static String decimalTo32BitBinary(int num){
    String result = "";
    
    while(num != 0){
      int mod = num % 2;
      num = num / 2;
      result = mod + result ;
    }
    
    int padLength = 32 - result.length();
    for(int i = 0; i < padLength; i++){
      result = "0" + result;
    }
    
    return result;
  }
  
  public static String twosCompliment(String str){
    return "";
  }
  
  public static void pn(String str){
    System.out.println(str);
  }
  
  public static void p(String str){
    System.out.print(str);
  }
}
