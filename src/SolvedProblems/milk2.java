package SolvedProblems;

//comment out package line when submitting
//package ProblemInTrial;
/* 
 ID: saifula1 
 LANG: JAVA 
 PROG: milk2 
 */

import java.util.*;
import java.io.*;

public class milk2 {

    static String IN_FILE_NAME = "milk2.in";
    static String OUT_FILE_NAME = "milk2.out";
    static int submit = 0;

    public static void main(String[] args) throws IOException {
        if (submit == 0) {
            IN_FILE_NAME = "input.txt";
            OUT_FILE_NAME = "output.txt";
        }
        //HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //open file
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE_NAME));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME)));
        //PrintStream out = System.out;
        //get total person count 

        //parse
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());    // first integer

        //take input
        int input[][] = new int[n][2];
        //1st input
        for (int index = 0; index < n; index++) {
            st = new StringTokenizer(f.readLine());
            input[index][0] = Integer.parseInt(st.nextToken());
            input[index][1] = Integer.parseInt(st.nextToken());
        }
        //sort array
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return Integer.compare(o1[0], o2[0]);
                return o1[0] - o2[0];
            }
        });

        /*
         lowerBound = getFirstLower
         upperBound = getFirstUpper
         maxContinuous = upper - lower
         maxInterval = 0
         */

        int lowerBound, upperBound, maxContinuous, maxInterval;
        lowerBound = input[0][0];
        upperBound = input[0][1];
        maxContinuous = upperBound - lowerBound;
        maxInterval = 0;

        for (int i = 1; i < n; i++) {

            int curLower, curUpper;
            curLower = input[i][0];
            curUpper = input[i][1];
            if (curLower <= upperBound) {


                if (curUpper > upperBound) {
                    upperBound = curUpper;
                    //checkBound = true;
                    int curContinous = upperBound - lowerBound;
                    if (curContinous > maxContinuous) {
                        maxContinuous = curContinous;
                    }
                }

            } else {
                int curInterval = curLower - upperBound;
                if (curInterval > maxInterval) {
                    maxInterval = curInterval;
                }
                lowerBound = curLower;
                upperBound = curUpper;
            }

        }
        out.println("" + maxContinuous + " " + maxInterval);
        //out.println(f.readLine());
        out.close();

    }
}
