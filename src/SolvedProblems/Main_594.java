/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

import Template.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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

/**
 * Use this file to submit. UVA only accepts class Main
 */
class Main_594 {

    public static final boolean DEBUG = true;

    public static void main(String[] args) throws IOException {
        BufferedOutputStream output;
        StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        //InputReader input;
        Scanner input;
        if (DEBUG) {
            output = new BufferedOutputStream(System.out);
            input = new Scanner(new File("input/uva594.txt"));;
        }else{
            output = new BufferedOutputStream(System.out);
            input = new Scanner(System.in);
        }

        String line;
        while(input.hasNext()){
            line = input.nextLine();
            int number = Integer.parseInt(line);
            int result = processNumber(number);

            sb.append(number + " converts to " + result + "\n");

        }

        output.write(sb.toString().getBytes());
        output.flush();
        output.close();

    }// end of static void main
    
    public static int processNumber(int num){
    String numStr = unSigneddecimalTo32BitBinary(Math.abs(num));
    if(num < 0){
      numStr = twosCompliment(numStr);
    }
    String endConverted = changeEndian(numStr);
    return unSignedbinary32BitToDecimal(endConverted);
  }
  
  public static String changeEndian(String num){
    String result = "";
    int beginIndex = 24;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 8; j++){
        int nextIndex = beginIndex + j;
        //p(nextIndex + " ");
        result = result + num.charAt(nextIndex);
      }
      //pn("");
      beginIndex -= 8;
    }
    return result;
  }
  
  public static String unSigneddecimalTo32BitBinary(int num){
    String result = "";
    
    while(num != 0){
      int mod = num % 2;
      num = num / 2;
      result = mod + result ;
    }
    
    int padLength = 32 - result.length();
    for(int i = 0; i < padLength; i++){
      result = "0" + result;
    }
    
    return result;
  }
  
  public static int unSignedbinary32BitToDecimal(String num){
    if(num.length() != 32){
      throw new RuntimeException(num + " does not have 32 bits");
    }
    int result = 0;
    
    char [] numArr = num.toCharArray();
    
    for(int i = 0; i < 32; i++){
      result = result * 2 + (numArr[i] - '0');
    }
    
    return result;
  }
  
  public static String onesCompliment(String num){
    String result = "";
    char []numArr = num.toCharArray();
    
    for(int i = 0; i < numArr.length; i++){
      if(numArr[i] == '0'){
        numArr[i] = '1';
      }else{
        numArr[i] = '0';
      }
    }
    return String.valueOf(numArr);
  }
  
  public static String addOne(String num){
    char []numArr = num.toCharArray();
    
    for(int i = 31; i >= 0; i--){
      if(numArr[i] == '1'){
        numArr[i] = '0';
      }else {
        numArr[i] = '1';
        break;
      }
    }
    return String.valueOf(numArr);
  }
  
  public static String twosCompliment(String str){
    return addOne(onesCompliment(str));
  }

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
