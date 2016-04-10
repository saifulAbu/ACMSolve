//comment out package line when submitting
package trash;
/* 
ID: saifula1 
LANG: JAVA 
PROG: ride 
*/
import java.util.*;
import java.io.*;

public class beads  {
    //static String IN_FILE_NAME = "ride.in";
     static String IN_FILE_NAME = "input.txt";
     //static String OUT_FILE_NAME = "ride.in";
     static String OUT_FILE_NAME = "input.txt";
     
     public static void main(String []args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        //open file
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE_NAME));
                                           // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME)));
        PrintStream out = System.out;
        //get total person count 
        
        //parse
        StringTokenizer st = new StringTokenizer(f.readLine());
                      // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());    // first integer
        char[] bead = f.readLine().toCharArray();     
        int maxBead = 0;
        int maxindex = 0;
        for(int breakPos = 0; breakPos < n; breakPos++){
            int curBeadTotal = 0;
            
            //move forward
            char prev = 'w';
            for(int j = 0; j < n; j++){
                int curIndex = (breakPos + j) % n;
                char cur = bead[curIndex];
                
                if(cur != 'w'){
                    if(prev == 'w'){
                        prev = cur;
                    }else if(prev != cur){
                        break;
                    }
                }
                curBeadTotal++;    
            }//end for
            
            if(curBeadTotal == n){
                maxBead = n;
                maxindex = breakPos;
                break;
            }
            
            prev = 'w';
            for(int j = 1; j < n; j++){
                int curIndex = (breakPos - j + n) % n;
                char cur = bead[curIndex];
                
                if(cur != 'w'){
                    if(prev == 'w'){
                        prev = cur;
                    }else if(prev != cur){
                        break;
                    }
                }
                curBeadTotal++;    
            }//end for
            
            if(curBeadTotal == n){
                maxBead = n;
                maxindex = breakPos;
                break;
            }
            
            if(maxBead < curBeadTotal){
                maxBead = curBeadTotal;
                maxindex = breakPos;
            }
        }//end for
        out.println("" + maxBead);
        out.close();
     }
}

