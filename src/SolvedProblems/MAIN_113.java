/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ProblemInTrial;

/**
 *
 * @author InspireServe
 */
// @JUDGE_ID:  1000AA  100  Java  "Easy algorithm"
import java.io.*;
import java.util.*;

class Main {

    static String ReadLn(int maxLg) // utility function to read from stdin
    {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) {
                    break;
                }
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) {
            printf("returning nulll");
            return (null);
        }  // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[]) // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        try {
            myWork.Begin();
        } catch (Exception ex) {
        }            // the true entry point
    }
    
    void Begin() throws NumberFormatException, IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = stdin.readLine()) != null && line.length() != 0) {
            double n = Double.parseDouble(line);
            //if (x==0.0) break;
            double p = Double.parseDouble(stdin.readLine());;
            //printf("" + p);
            //System.out.println(Math.log10(y));
            //System.out.println(x);
            System.out.println( Math.round(Math.pow(p, 1/n)));
        }
        
    }

    static void printf(String str) {
        System.out.println(str);
    }//end of printf
}
