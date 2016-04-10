//comment out package line when submitting
package Template;
/* 
 ID: saifula1 
 LANG: JAVA 
 PROG: ride 
 */

import java.util.*;
import java.io.*;

public class TemplateUSACO {

    static int submit = 0;
    static String IN_FILE_NAME = "ride.in";
    static String OUT_FILE_NAME = "ride.out";

    public static void main(String[] args) throws IOException {
        if (submit == 0) {
            IN_FILE_NAME = "input.txt";
            OUT_FILE_NAME = "output.txt";
        }
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        //open file
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE_NAME));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME)));
        //PrintStream out = System.out;
        //get total person count 

        //parse
        //StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        //int i1 = Integer.parseInt(st.nextToken());    // first integer

        out.println("Hello World");
        out.println(f.readLine());
        out.close();
    }
}
