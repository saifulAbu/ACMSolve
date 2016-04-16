package SolvedProblems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package acmprobintrial;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.out;
import java.math.BigInteger;

/**
 * Use this file to submit. UVA only accepts class Main
 */
public class Main_10172 {

    public static final boolean DEBUG = false;

    static String factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact.toString();
    }

    static void test() {
       System.out.println(String.format("abc%06dabc", 68));
    }

    static void runFunc() throws IOException {
        BufferedOutputStream output = new BufferedOutputStream(System.out);
        InputReader input = new InputReader(System.in);
        StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        int digitFreq[] = new int[10];

        int n;
        while ((n = input.readInt()) > 0) {

            String fact = factorial(n);
            
            //count digit frequency
            //init array
            for(int i = 0; i < digitFreq.length; i++){
                digitFreq[i] = 0;
            }
            
            for(int i = 0; i < fact.length(); i++){
                digitFreq[fact.charAt(i) - '0']++;
            }
            
            //print result
            sb.append( n + "!" + " --\n");
            for(int i = 0; i < 2; i++){
                sb.append("   "); //3 spaces
                for(int j = 0; j < 5; j++){
                    int index = 5 * i + j;
                    
                    String formatted = String.format("(%d)%5d    ", index, digitFreq[index]);
                    sb.append(formatted);
                }
                sb.append("\n");
            }

        }

        output.write(sb.toString().getBytes());
        output.flush();
        output.close();
    }

    public static void main(String[] args) throws IOException {

        runFunc();

        //test();

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
 *************************************************************************
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
