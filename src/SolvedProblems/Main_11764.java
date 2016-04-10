package SolvedProblems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//11764 
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
class Main_11764 {
    
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
        int highJumps = 0, lowJumps = 0;
        int numberOfTestCases = Integer.parseInt(lineReader.readLine());
        for(int i = 0; i < numberOfTestCases; i++){
            int numberOfWalls = Integer.parseInt(lineReader.readLine());
            highJumps = 0;
            lowJumps = 0;
            /*
            if((numberOfWalls == 1) || (numberOfWalls == 0)){
                
            }*/
            valueReader = new StringTokenizer(lineReader.readLine());
            int current = Integer.parseInt(valueReader.nextToken());
            int next;
            for(int k = 1; k < numberOfWalls; k++){
                next = Integer.parseInt(valueReader.nextToken());
                if(current < next){
                    highJumps++;
                }else if(current > next){
                    lowJumps++;
                }
                current = next;
            }//end for
            printf("Case " + (i+1) + ": " + highJumps + " " + lowJumps);
        }//end for
        
    }//end of run
    
    public static void test(){
    
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
}//end of class
