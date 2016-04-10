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
class Main_11332 {

    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) {
        run();
        //test();
    }//end of test

    //public static void run() throws FileNotFoundException{
    public static void run(){
        //take input
        Scanner lineReader = new Scanner(System.in);
        //Scanner lineReader = new Scanner(new File("input.txt"));
        Scanner valueReader;
        String line;
        while (lineReader.hasNextLine()) {
            line = lineReader.nextLine();
            valueReader = new Scanner(line);
            int value = valueReader.nextInt();
            if (value == 0) {
                break;
            }

            while (value >= 10) {
                value = g(value);
            }
            printf("" + value);

        }//end while
    }//end of run

    public static void test() {
        printf(g(9) + " " + g(0) + " " + g(111) + " " + g(1234567892));
    }//end of test

    public static int g(int value) {
        int sumOfDigit = 0;
        do {
            sumOfDigit += (value % 10);
            value /= 10;
        } while (value != 0);
        return sumOfDigit;

    }//end of method

    public static void printf(String str) {
        System.out.println(str);
    }//end of printf
}//end of class
