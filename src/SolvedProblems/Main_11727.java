/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//11727 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class Main_11727 {
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) throws IOException{
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
        int numberOfTestCases = Integer.parseInt(lineReader.readLine());
        int first, second, third, mid;
        for(int i = 0; i < numberOfTestCases; i++){
            line = lineReader.readLine();
            valueReader = new StringTokenizer(line);
            first = Integer.parseInt(valueReader.nextToken());
            second = Integer.parseInt(valueReader.nextToken());
            third = Integer.parseInt(valueReader.nextToken());
            
            if(first > second){
                if(first < third){
                    mid = first;
                }else{
                    if(third > second){
                        mid = third;
                    }else{
                        mid = second;
                    }
                }
            }else{
                if(first > third){
                    mid = first;
                }else{
                    if(second > third){
                        mid = third;
                    }else{
                        mid = second;
                    }
                }
            }//end if else
            printf("Case "+ (i+1)+ ": " + mid);
        }//end for
        /*
        while ((lineReader.readLine()) != null) {
            line = lineReader.readLine();
            valueReader = new StringTokenizer(line);

        }//end while
        * */
    }//end of run
    
    public static void test(){
    
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
