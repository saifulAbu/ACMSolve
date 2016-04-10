/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//11498 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class Main_11498 {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
    //public static void main(String args[]){
        //test();
        run();
    }//end of main
    
    public static void run()throws FileNotFoundException, IOException{
    //public static void run(){
        //take input
        //System.in;
        //Scanner lineReader = new Scanner(new BufferedInputStream(System.in));
        //Scanner lineReader = new Scanner(new File("input.txt"));
        //BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        //FileInputStream f = ;
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner valueReader;
        StringTokenizer valueReader;
        String line;
        /*
        while (lineReader.hasNextLine()) {
            line = lineReader.nextLine();
            valueReader = new Scanner(line);

        }//end while
        */
        while (true) {            
            //line = lineReader.nextLine();
            line = lineReader.readLine();
            int numberOfTestCases = Integer.parseInt(line);
            if (numberOfTestCases == 0) {
                break;
            }//end if
            //line = lineReader.nextLine();
            line = lineReader.readLine();
            //valueReader = new Scanner(line);
            valueReader = new StringTokenizer(line);
            int divisionPointX, divisionPointY, locationX, locationY;
            
            //divisionPointX = valueReader.nextInt();
            divisionPointX = Integer.parseInt(valueReader.nextToken());
            //divisionPointY = valueReader.nextInt();
            divisionPointY = Integer.parseInt(valueReader.nextToken());
            
            for(int i = 0; i < numberOfTestCases; i++){
                //line = lineReader.nextLine();
                line = lineReader.readLine();
                //valueReader = new Scanner(line); 
                valueReader = new StringTokenizer(line);
                //locationX = valueReader.nextInt();
                locationX = Integer.parseInt(valueReader.nextToken());
                //locationY = valueReader.nextInt();
                locationY = Integer.parseInt(valueReader.nextToken());
                printLocation(divisionPointX, divisionPointY, locationX, locationY);
            }//end for
        }//end while
    }//end of run
    
    public static void test(){
        /*
        
         -1000 -1000
         -1000 -1000
         0 0
         -2000 -10000
         -999 -1001
         * 
         divisa
         NE
         SO
         SE
         */
        int divisionPointX = -1000;
        int divisionPointY = -1000;
        int locationX = -999;
        int locationY = -1001;
        //printLocation(divisionPointX, divisionPointY, locationX, locationY));
        printLocation(divisionPointX, divisionPointY, locationX, locationY);
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
    
    public static void printLocation(int divisionPointX, int divisionPointY, int locationX, int locationY){
        int shiftedX, shiftedY;
        shiftedX = locationX - divisionPointX;
        shiftedY = locationY - divisionPointY;
        
        if((shiftedX == 0) || (shiftedY == 0)){
            printf("divisa");
        }else if((shiftedX > 0) && (shiftedY > 0)){
            printf("NE");
        } else if ((shiftedX > 0) && (shiftedY < 0)) {
            printf("SE");
        } else if ((shiftedX < 0) && (shiftedY < 0)) {
            printf("SO");
        } else if ((shiftedX < 0) && (shiftedY > 0)) {
            printf("NO");
        }
    }//end of method
}//end of class
