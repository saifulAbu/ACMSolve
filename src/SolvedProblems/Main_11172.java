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
class Main_11172 {
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]){
        //take input
        Scanner lineReader = new Scanner(System.in);
        //Scanner lineReader = new Scanner(new File("input.txt"));
        Scanner valueReader;
        String line;
        /*
        while(lineReader.hasNextLine()){
            line = lineReader.nextLine();
            valueReader = new Scanner(line);
            
        }//end while
        * */
        int testCaseNumber = Integer.parseInt(lineReader.nextLine());
        for(int i = 0; i < testCaseNumber; i++){
            int first, second;
            line = lineReader.nextLine();
            valueReader = new Scanner(line);
            first = valueReader.nextInt();
            second = valueReader.nextInt();
            
            if(first > second){
                printf(">");
            }else if(first < second){
                printf("<");
            }else{
                printf("=");
            }
        }//end for
    }//end of main
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
