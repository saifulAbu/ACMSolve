/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//11547 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class Main_11547 {
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) throws FileNotFoundException, IOException{
        run();
    }//end of main
    
    public static void run()throws FileNotFoundException, IOException{
    //public static void run() throws IOException{
        //take input
        //Scanner lineReader = new Scanner(System.in);
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner lineReader = new Scanner(new File("input.txt"));
        //Scanner valueReader;
        //BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer valueReader;
        String line;
        /*
        while ((lineReader.readLine()) != null) {
            line = lineReader.readLine();
            valueReader = new StringTokenizer(line);

        }//end while
        * */
        int testCases = Integer.parseInt(lineReader.readLine());
        for(int i = 0; i < testCases; i++){
            int n = Integer.parseInt(lineReader.readLine());
            /*
             Multiply n by 567, 
             * then divide the result by 9, 
             * then add 7492, 
             * then multiply by 235, 
             * then divide by 47, 
             * then subtract 498. 
             * What is the digit in the tens column
             */
            int calculateValue = ((((((n * 567) / 9) + 7492) * 235) / 47) - 498);
            int digit = Math.abs((calculateValue / 10) % 10);
            printf("" + digit);
            
        }//end for
    }//end of run
    
    public static void test(){
    
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
