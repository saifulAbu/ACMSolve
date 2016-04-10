//comment out package line when submitting
//package Template;
/* 
 ID: saifula1 
 LANG: JAVA 
 PROG: milk 
 */


import java.util.*;
import java.io.*;

class milk {

    static int submit = 1;
    static String IN_FILE_NAME = "milk.in";
    static String OUT_FILE_NAME = "milk.out";

    public static void main(String[] args) throws IOException {
        if (submit == 0) {
            IN_FILE_NAME = "input.txt";
            OUT_FILE_NAME = "output.txt";
        }
        StringBuilder sb = new StringBuilder(2000);
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
        int neededMilkAmount = Integer.parseInt(st.nextToken());    // first integer
        int milkManCount = Integer.parseInt(st.nextToken());
        int totalCost = 0;
        int[][] milkManInfo = new int[milkManCount][2];
        //sb.append("\n");
        for(int i = 0; i < milkManCount; i++){
            st = new StringTokenizer(f.readLine());
            milkManInfo[i][0] = Integer.parseInt(st.nextToken()); //unit price
            milkManInfo[i][1] = Integer.parseInt(st.nextToken());   //amount
            //sb.append("hello");
        }//end for
        
        //sort
        Comparator<int[]> c = new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Arrays.sort(milkManInfo, c);
        
        for(int i = 0; i < milkManCount; i++){
            int unitCost = milkManInfo[i][0];
            int availableUnits = milkManInfo[i][1];
            
            if(neededMilkAmount >= availableUnits){
                neededMilkAmount -= availableUnits;
                totalCost = totalCost + (unitCost * availableUnits);
            }else{
                totalCost += (unitCost * neededMilkAmount);
                neededMilkAmount = 0;
                break;
            }
        }//end for

        //out.print(sb.toString());
        out.println(totalCost);
        out.flush();
        out.close();
    }
}
