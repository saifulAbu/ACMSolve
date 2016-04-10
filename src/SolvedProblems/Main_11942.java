/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//11942 
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
class Main_11942 {
    
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
        /*
        while ((lineReader.readLine()) != null) {
            line = lineReader.readLine();
            valueReader = new StringTokenizer(line);

        }//end while
        */
        int numberOfTestCases = Integer.parseInt(lineReader.readLine().trim());
        printf("Lumberjacks:");
        for(int i = 0; i < numberOfTestCases; i++){
            boolean ordered = true;
            
            valueReader = new StringTokenizer(lineReader.readLine().trim());
            int current = Integer.parseInt(valueReader.nextToken());
            int next = Integer.parseInt(valueReader.nextToken());
            
            boolean increasing;
            if(next > current){
                increasing = true;
            }else{
                increasing = false;
            }
            
            //current = next;
            for(int manIndex = 3; manIndex <= 10; manIndex++){
                current = next;
                next = Integer.parseInt(valueReader.nextToken());
                if(increasing){
                    if(next < current){
                        ordered = false;
                        break;
                    }
                }else{
                    if(next > current){
                        ordered = false;
                        break;
                    }
                }//end if else                 
            }//end for
            
            if (ordered) {
                printf("Ordered");
            } else {
                printf("Unordered");
            }
        }//end for
    }//end of run
    
    public static void test(){
    
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
