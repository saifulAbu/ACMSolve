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
        String str = "cbbaa";
        char arr[] = str.toCharArray();
        int suffixIndex = suffixLongestDecreasingSequenceStartIndex(arr);
        if(suffixIndex == 0){
            System.out.println("no successor");
            return;
        }
        int minPrefixIndex = minElemInSuffixIndex(suffixIndex, arr);
        swap_min_suffix_last_elem_prefix(suffixIndex, minPrefixIndex, arr);
        reverseSuffix(suffixIndex, arr);
        String result = String.valueOf(arr);
        System.out.println(result);
    }
    
    static int suffixLongestDecreasingSequenceStartIndex(char[] input){
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
    
    static int minElemInSuffixIndex(int suffixStartIndex, char[] input){
        int minSuffixIndex = suffixStartIndex;
        int minElem = input[suffixStartIndex];
        for(int i = suffixStartIndex + 1; i < input.length; i++){
            if(input[i] <= minElem){
                minSuffixIndex = i;
                minElem = input[i];
            }
        }
        return minSuffixIndex;
    }
    
    static void swap_min_suffix_last_elem_prefix(int suffixStartIndex, int minSuffixIndex, char[] input){
        int lastPrefixIndex = suffixStartIndex - 1;
        char lastPrefixElem = input[lastPrefixIndex];
        char minPrefixElem = input[minSuffixIndex];
        input[lastPrefixIndex] = minPrefixElem;
        input[minSuffixIndex] = lastPrefixElem;
    }
    
    static void reverseSuffix(int suffixStartIndex, char[] input){
        int size = input.length;
        int lastIndex = size - 1;
        int middle = (size - suffixStartIndex) / 2;
        for(int i = 0; i < middle; i++){
            char temp;
            temp = input[suffixStartIndex + i];
            input[suffixStartIndex+i] = input[lastIndex-i];
            input[lastIndex-i] = temp;
        }
    }
}
