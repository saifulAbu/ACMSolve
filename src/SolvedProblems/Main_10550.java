/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

import java.util.Scanner;

/**
 *
 * @author InspireServe
 */
class Main_10550 {
    public static int ONE_DIGIT_EQUI_DEGREE = (360 / 40);
    public static int FORTY_DEGREE = 40;
    public static int FIXED_DEGREE = 3 * 360;
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]){
        //take input
        Scanner lineReader = new Scanner(System.in);
        //Scanner lineReader = new Scanner(new File("input.txt"));
        Scanner valueReader;
        int first, second, third, fourth;
        String line;
        while(lineReader.hasNextLine()){
            line = lineReader.nextLine();
            valueReader = new Scanner(line);
            first = valueReader.nextInt();
            second = valueReader.nextInt();
            third = valueReader.nextInt();
            fourth = valueReader.nextInt();
            
            if((first == 0) && (second == 0) && (third == 0) && (fourth == 0)){
                break;
            }
            int degreeCount = FIXED_DEGREE + 
                    getClockWiseDegree(first, second) + 
                    getAntiClockWiseDegree(second, third) +
                    getClockWiseDegree(third, fourth);
            printf("" + degreeCount);
        }//end while
    }//end of main
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
    
    public static int getAntiClockWiseDegree(int start, int target){
        return ((FORTY_DEGREE + target - start)%FORTY_DEGREE) * ONE_DIGIT_EQUI_DEGREE;
    }//end of method
    
    public static int getClockWiseDegree(int start, int target){
        return ((FORTY_DEGREE * ONE_DIGIT_EQUI_DEGREE- getAntiClockWiseDegree(start, target)));
    }//end of method
}//end of class
