package SolvedProblems;

//comment out package line when submitting
//package ProblemInTrial;
/* 
 ID: saifula1 
 LANG: JAVA 
 PROG: namenum 
 */

import java.util.*;
import java.io.*;

public class namenum {

    static int submit = 1;
    static String IN_FILE_NAME = "namenum.in";
    static String OUT_FILE_NAME = "namenum.out";

    public static void main(String[] args) throws IOException {
        if (submit == 0) {
            IN_FILE_NAME = "input.txt";
            OUT_FILE_NAME = "output.txt";
        }
       // HashMap<String, Integer> hm = new HashMap<String, Integer>();

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
        
        //open file
        BufferedReader dictFile = new BufferedReader(new FileReader("dict.txt"));
        //create hashmap
        HashMap<String, TreeSet> map = new HashMap<String, TreeSet>();
        //read line from file
        //test();
        String line;
        TreeSet currentTreeSet;
        while((line = dictFile.readLine()) != null){
            if(line.contains("Q") || line.contains("Z")){
                continue;
            }
            String group = "";
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                int val = charToGroup(ch);
                group += val;
            }
            
            if(map.containsKey(group)){
                currentTreeSet = map.get(group);
            }else{
                currentTreeSet = new TreeSet();
                map.put(group, currentTreeSet);
            }
            currentTreeSet.add(line);
        }
        
        String input = f.readLine();
        currentTreeSet = map.get(input);
        if(currentTreeSet == null){
            out.println("NONE");
        }else{
            Iterator itr = currentTreeSet.iterator();
            while(itr.hasNext()){
                out.println(itr.next());
            }
        }
        //out.println("ebd");
        out.close();
    }
    
    static void test()
    {
        for(char ch = 'A'; ch <= 'Y'; ch++){
            int val = charToGroup(ch);
            System.out.println("" + val + " " + ch);
        }
    }
    
    static int charToGroup(char ch)
    {
        if(ch > 'Q'){
            ch -= 1;
        }
        int group = ((ch - 'A') / 3) + 2;
        return group;
    }
}
