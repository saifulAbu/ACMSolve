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
public class Test_146 {
    public static void main(String args[]){
        String str = "0125330";
        char arr[] = str.toCharArray();
        System.out.println(suffixLongestDecreasingSequence(arr));
    }
    
    static int suffixLongestDecreasingSequence(char[] input){
        int size = input.length;
        int index = size -1;
        
        for(int i = size-2; i >= 0; i--){
            if(input[i] < input[i+1]){
                break;
            }
            index = i;
        }
        return index;
    }
}
