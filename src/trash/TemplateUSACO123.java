package trash;
import java.util.*;
import java.io.*;

public class TemplateUSACO123  {
    //static String IN_FILE_NAME = "ride.in";
     static String IN_FILE_NAME = "input.txt";
     //static String OUT_FILE_NAME = "ride.in";
     static String OUT_FILE_NAME = "output.txt";
     
     static int monthDay[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     //                       jan feb mar apr may jun jul aug sep oct nov dec
     
     static int dayCount13[] = {0, 0, 0, 0, 0, 0, 0};
     //                         Mo Tu We Th Fr Sa Su
     
     // April, June, September, November,
     public static void main(String []args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        //open file
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE_NAME));
                                              // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_NAME)));
        //PrintStream out = System.out;
        //take input
        StringTokenizer st = new StringTokenizer(f.readLine());
                      // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());    // first integer
        int dayCount = 0;
        for(int yearIndex = 1900; yearIndex < 1900 + n; yearIndex++){
           for(int monthIndex = 0; monthIndex < 12; monthIndex++){
               //go to 13 th day
               dayCount13[(dayCount + 12) % 7]++;
               int daysToNextMonth;
               if(monthIndex == 1){
                   daysToNextMonth = getFebruaryDay(yearIndex);
               }else{
                   daysToNextMonth = monthDay[monthIndex];
               }
               dayCount += (daysToNextMonth);
           }//end for
        }//end for
        
        String result = "";
        for(int i = 0; i < dayCount13.length; i++){
            result = result + " " + dayCount13[(i + 5) % 7];
        }
        result = result.trim();
        out.println(result);
        out.close();
     }
     
     static int getFebruaryDay(int year)
     {
         int extraDay = 0;
         if((year % 4) == 0){
             extraDay = 1;
             if((year % 100) == 0 && ((year % 400) != 0)){
                 extraDay = 0;
             }
         }
         return 28 + extraDay;
     }
}

