/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//12015
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class Main_12015 {

    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) throws IOException {
        //test();
        run();
    }//end of main

    //public static void run()throws FileNotFoundException{
    public static void run() throws IOException {
        //take input
        //Scanner lineReader = new Scanner(System.in);
        //BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner lineReader = new Scanner(new File("input.txt"));
        //Scanner valueReader;
        StringTokenizer valueReader;
        String line;

        int numberOfTestCases = Integer.parseInt(lineReader.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            int max = 0;
            HashMap<Integer, List<String>> hashMap = new HashMap<Integer, List<String>>();
            for (int urlNo = 0; urlNo < 10; urlNo++) {
                List<String> listUrl;
                line = lineReader.readLine();
                valueReader = new StringTokenizer(line);
                String url = valueReader.nextToken();
                int rank = Integer.parseInt(valueReader.nextToken());
                if(max < rank){
                    max = rank;
                }
                if (hashMap.containsKey(rank)) {
                    listUrl = hashMap.get(rank);
                } else {
                    listUrl = new LinkedList<String>();
                    hashMap.put(rank, listUrl);
                }
                listUrl.add(url);
                //List<String> listUrl = new LinkedList<String>();
            }//end for
            List<String> maxUrl = hashMap.get(max);
            //Case #1:
            printf("Case #"+(i+1)+":");
            for(String url : maxUrl){
                printf(url);
            }//end for
        }//end for

    }//end of run

    public static void test() {
    }//end of test

    public static void printf(String str) {
        System.out.println(str);
    }//end of printf
}//end of class
