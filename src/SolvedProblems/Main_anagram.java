//was not accepted due to the time limit
package SolvedProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Main_anagram {
    static Scanner in = new Scanner(System.in);

    static PrintWriter out = new PrintWriter(System.out, true);
    static int stringLen = 0;
    static String srcStr, destStr;
    static Stack<Character> stack = new Stack();
    static String finalString = "";
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("input.txt"));
        while (in.hasNext()) {
            srcStr = in.nextLine();
            destStr = in.nextLine();
            //System.out.println(srcStr + " " + destStr + " " + hasSameCharacters(srcStr, destStr));
            if(!hasSameCharacters(srcStr, destStr)){
                continue;
            }//end if
            stringLen = srcStr.length();
            //out.println("[");
            finalString += "[" + "\n";
            generateCombinations("", 0, 0);
            finalString += "]" + "\n";
        }//end while
        out.println(finalString);
    }//end of main
    
    public static void generateCombinations(String prefix, int iCount, int oCount){
        if(iCount + oCount == stringLen * 2){
            //out.println(prefix);
            checkOutput(prefix);
            return;
        }//end if
        
        if(iCount < stringLen){
            generateCombinations(prefix + 'i', iCount + 1, oCount);
        }//end if
        
        if(oCount < iCount){
            generateCombinations(prefix + 'o', iCount, oCount + 1);
        }//end if
        
    }//end of method generate combinations

    public static boolean hasSameCharacters(String src, String dest) {
        if(src.length() != dest.length()){
            return false;
        }
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for (char ch : src.toCharArray()) {
            int count = 1;
            if (frequencyMap.containsKey(ch)) {
                count = frequencyMap.get(ch) + 1;
            }//end if
            frequencyMap.put(ch, count);
        }//end for

        for (char ch : dest.toCharArray()) {

            if (frequencyMap.containsKey(ch)) {
                int count = frequencyMap.get(ch) - 1;
                frequencyMap.put(ch, count);
                if (count == 0) {
                    frequencyMap.remove(ch);
                }
            } else {
                return false;
            }//end if else

        }//end for
        if (frequencyMap.isEmpty()) {
            return true;
        }
        return false;
    }//end of method
    
    public static void checkOutput(String combination){
        stack.removeAllElements();
        String outputSring = "";
        String srcStringCopy = srcStr;
        for(char ch : combination.toCharArray()){
            switch(ch){
                case 'i':
                    stack.push(srcStringCopy.charAt(0));
                    srcStringCopy = srcStringCopy.substring(1);
                    break;
                case 'o':
                    outputSring += stack.pop();
            }//end of switch case
        }//end for
        if(outputSring.equals(destStr)){
            for(char ch : combination.toCharArray()){
                finalString += ch + " ";
            }//end for
            finalString += "\n";
        }
    }//end of method
}//END OF CLASS
