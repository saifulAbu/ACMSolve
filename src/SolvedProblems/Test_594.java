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
    //pn(decimalTo32BitBinary(0));
    //pn(decimalTo32BitBinary(10));
    //pn(decimalTo32BitBinary(7));
    //pn(decimalTo32BitBinary(8));
    pn(addOne("01111111111111111111111111111111"));
    
    //pn(binary32BitToDecimal(decimalTo32BitBinary(10)) + "");
    //pn(onesCompliment(unSigneddecimalTo32BitBinary(0)));
  }
  
  public static String unSigneddecimalTo32BitBinary(int num){
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
  
  public static int unSignedbinary32BitToDecimal(String num){
    if(num.length() != 32){
      throw new RuntimeException(num + " does not have 32 bits");
    }
    int result = 0;
    
    char [] numArr = num.toCharArray();
    
    for(int i = 0; i < 32; i++){
      result = result * 2 + (numArr[i] - '0');
    }
    
    return result;
  }
  
  public static String onesCompliment(String num){
    String result = "";
    char []numArr = num.toCharArray();
    
    for(int i = 0; i < numArr.length; i++){
      if(numArr[i] == '0'){
        numArr[i] = '1';
      }else{
        numArr[i] = '0';
      }
    }
    return String.valueOf(numArr);
  }
  
  public static String addOne(String num){
    char []numArr = num.toCharArray();
    
    for(int i = 31; i >= 0; i--){
      if(numArr[i] == '1'){
        numArr[i] = '0';
      }else {
        numArr[i] = '1';
        break;
      }
    }
    return String.valueOf(numArr);
  }
  
  
  
  public static String twosCompliment(String str){
    return "";
  }
  
  public static void pn(int num){
    pn("" + num);
  }
  
  public static void pn(String str){
    System.out.println(str);
  }
  
  public static void p(String str){
    System.out.print(str);
  }
}
