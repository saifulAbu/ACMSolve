/* problem 11286
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;
import java.util.HashMap;

/**
 * Use this file to submit. UVA only accepts class Main
 */
class Main_11286 {

    public static final boolean DEBUG = false;

    public static void main(String[] args) throws IOException {
        BufferedOutputStream output;
        StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        //InputReader input;
        Scanner input;
        if (DEBUG) {
            output = new BufferedOutputStream(System.out);
            input = new Scanner(new File("input.txt"));;
        }else{
            output = new BufferedOutputStream(System.out);
            input = new Scanner(System.in);
        }

        String str;
        int[] course = new int[5];
        HashMap<String, Integer> combinationCount = new HashMap<String, Integer>();
        while(input.hasNext()){
            combinationCount.clear();
            int maxPopularity = Integer.MIN_VALUE;
            int studentCount = input.nextInt();
            if(studentCount == 0){
                break;
            }//end if
            for(int i = 0; i < studentCount; i++){
                for(int courseNum = 0; courseNum < 5; courseNum++){
                    course[courseNum] = input.nextInt();
                    //System.out.print(course[courseNum] + " ");
                }//end for
                Arrays.sort(course);
                String courseStr = "";
                for(int courseNum : course){
                    courseStr += courseNum;
                    //System.out.print(course + " ");
                }//end for
                //System.out.println(courseStr);
                int popularity = 1;
                if(combinationCount.containsKey(courseStr)){
                    popularity = combinationCount.get(courseStr) + 1;
                }//end if
                combinationCount.put(courseStr, popularity);
                if(popularity > maxPopularity){
                    maxPopularity = popularity;
                }//end if
            }//end for
            int totalStudentTakingPopularCourse = 0;
            for(int popularity : combinationCount.values()){
                if(popularity == maxPopularity){
                    totalStudentTakingPopularCourse += popularity;
                }
            }//end for
            out.println(totalStudentTakingPopularCourse);            

        }//end while
        out.println();
        output.write(sb.toString().getBytes());
        output.flush();
        output.close();

    }// end of static void main

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readLine() {
            int c = read();
            //theres no ASCII -1 value. this signify EOF, and we return empty string
            if (c == -1) {
                return "";
            }

            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (c != '\n');
            return res.toString();
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {

        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class IOUtils {

        public static int[] readIntArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }
    }
}//End of Main Class
/**
 * ************************************************************************
 * Fast I/O functions (prevents i/o flushing by buffering)
 * ************************************************************************
 */
//BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

/* 
 Slightly less efficient 
 BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out)); 
 output.write(stringBuilder.toString());

 More efficient: 
 BufferedOutputStream output = new BufferedOutputStream(System.out); // more efficient  
 output.write(stringBuilder.toString().getBytes());
 */
//or we can use the below utilitiy classes: 

/** 
* Various utility class for Fast I/O in java.  
* Readings: http://www.codechef.com/wiki/java#IO_in_Java 
* BufferedInputStream > BufferedReader > Scanner  
* 
* USAGE: 
* InputReader in 		= new InputReader(System.in);
* OutputWriter out	=	new OutputWriter(System.out);
* 
* int i = in.readInt(); //read int
* String s = in.readString(); //read string
* int[] x = IOUtils.readIntArray(in,N); //read int array of size N
* String s = in.readLine() // read a line ( to be used with tokenizer );
* 
* out.printLine("X");
*  
* out.flush(); // flush output
* out.close(); // remember to close the outputstream, at the end (might be able to not do this to save some time) 
*/
