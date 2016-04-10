package SolvedProblems;

//comment out package line when submitting
//package ProblemInTrial;
/* 
 ID: saifula1 
 LANG: JAVA 
 PROG: transform 
 */

import java.util.*;
import java.io.*;

 public class transform {

    static int submit = 1;
    static String IN_FILE_NAME = "transform.in";
    static String OUT_FILE_NAME = "transform.out";

    public static void main(String[] args) throws IOException {
        if (submit == 0) {
            IN_FILE_NAME = "input.txt";
            OUT_FILE_NAME = "output.txt";
        }
       // HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //open file
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE_NAME));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME)));
        //PrintStream out = System.out;
        //get total person count 

        //parse
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());    // first integer

        //out.println("Hello World");
        //out.println(f.readLine());
        char [][][] combinationArrays = new char [8][n][n];
        char[][] transformCheckArray = new char[n][n];
        //test();
        //5 index array with no change
        char[][] arr;
        arr = combinationArrays[combinationArrays.length - 1];
        for(int row = 0; row < n; row++){
            String rowStr = f.readLine();
            arr[row] = rowStr.toCharArray();
        }
        
        for(int row = 0; row < n; row++){
            String rowStr = f.readLine();
            transformCheckArray[row] = rowStr.toCharArray();
        }
        //printArray(transformCheckArray);
        //end of input collection
        //first array 90 clock wise
        transformClockwise90(combinationArrays[combinationArrays.length - 1], combinationArrays[0]);
        
        //2nd array 180
        transformClockwise90(combinationArrays[0], combinationArrays[1]);
        //3rd array 270
        transformClockwise90(combinationArrays[1], combinationArrays[2]);
        //4 threflect
        reflexVertical(combinationArrays[combinationArrays.length - 1], combinationArrays[3]);
        //printArray(combinationArrays[3]);
        //5 reflect + 90
        transformClockwise90(combinationArrays[3], combinationArrays[4]);
        //6 reflect + 180
        transformClockwise90(combinationArrays[4], combinationArrays[5]);
        //7 reflect + 270
        transformClockwise90(combinationArrays[5], combinationArrays[6]);
        //8 normal
        
        int matchedIndex;
        for(matchedIndex = 0; matchedIndex < combinationArrays.length; matchedIndex++){
            boolean matched = false;
            matched = compareArray(combinationArrays[matchedIndex], transformCheckArray);
            if(matched){
                //printArray(transformCheckArray);
                break;
            }
        }
        
        int printVal;
        if(matchedIndex < 4){
            printVal = matchedIndex + 1;
        }else if((matchedIndex >= 4) && (matchedIndex < 7)){
            printVal = 5;
        }else if(matchedIndex == 7){
            printVal = 6;
        }else{
            printVal = 7;
        }
        
        out.println("" + printVal);
        //printArray(arr);
        //out.println();
        //printArray(transformCheckArray);
        out.close();
        //test();

    }

    static void test() {
        
        int start = 0;
        char[][] testArr = {
            {'0', '1', '2'},
            {'3', '4', '5'},
            {'6', '7', '8'}
        };
        int size = testArr.length;
        char [][] transformedArr = new char[size][size];
        transformClockwise90(testArr, transformedArr);
        //reflexVertical(size, testArr, transformedArr);
        printArray(testArr);
        System.out.println();
        printArray(transformedArr);
    }

    static void reflexVertical(char[][] original, char[][] transformed) {
        int size = original.length; 
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                transformed[row][(size - 1) - col] = original[row][col];
            }
        }
    }//end method
    
    static void transformClockwise90(char[][] original, char[][] transformed) {
        int size = original.length;
        for(int row = 0; row < (size); row++){
            for(int col = 0; col < (size); col++){
                int transRow = col;
                int transCol = (size - 1) - (row); //start + (size - 1) - (row - start)
                transformed[transRow][transCol] = original[row][col];
                //System.out.println("" + transRow + " " + transCol);
            }
        }
    }
    static void printArray(char[][]array){
        int size = array.length;
        for(int row = 0; row < size; row++){
            String rowString = "";
            for(int col = 0; col < size; col++){
                rowString += (array[row][col] + " ");
            }
            System.out.println(rowString);
        }
    }
    
    static boolean compareArray(char[][] array1, char[][] array2)
    {
        int size = array1.length;
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(array1[row][col] != array2[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
