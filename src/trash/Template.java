/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class Template {
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) throws IOException{
        //test();
        run();
    }//end of main
    
    //public static void run()throws FileNotFoundException{
    public static void run() throws IOException{
        //take input
        //Scanner lineReader = new Scanner(System.in);
        //BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner lineReader = new Scanner(new File("input.txt"));
        //Scanner valueReader;
        StringTokenizer valueReader;
        String line;
        while (true) {
            line = lineReader.readLine();
            if(line == null){
                break;
            }
            valueReader = new StringTokenizer(line);

        }//end while
        
        /*
         int numberOfTestCases = Integer.parseInt(lineReader.readLine());
         for(int i = 0; i < numberOfTestCases; i++){
        
         }//end for
         */
    }//end of run
    
    public static void test(){
    
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
