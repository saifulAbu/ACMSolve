/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sid
 */
public class Main_414 {

    public static final boolean DEBUG = false;

    public static int getNumberofLines(Scanner file) {
        int line = file.nextInt();
        return line;
    }

    public static int countSpaces(String row) {
        int count = 0;
        for (char ch : row.toCharArray()) {
            if (ch == ' ') {
                count++;
            }
        }
        return count;
    }

    public static int[] readImage(Scanner file, int lineCount) {
        int[] spaces = new int[lineCount]; //use static array
        for (int i = 0; i < lineCount; i++) {
            String str = file.nextLine();
            spaces[i] = countSpaces(str);
        }
        return spaces;
    }
    
    private static int findRemainingSpace(int[] spaces, int lineCount) {
        int min = Integer.MAX_VALUE;
        for(int val : spaces){
            if(val < min){
                min = val;
            }
        }
        
        int remainingSpaces = 0;
        for(int val : spaces){
            remainingSpaces += (val - min);
        }
        
        return remainingSpaces;
    }

    public static void main(String[] args) throws IOException {
        BufferedOutputStream output;
        StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        //InputReader input;
        Scanner input;
        if (DEBUG) {
            output = new BufferedOutputStream(System.out);
            input = new Scanner(new File("input.txt"));;
        } else {
            output = new BufferedOutputStream(System.out);
            input = new Scanner(System.in);
        }

        int lineCount = getNumberofLines(input);
        while (lineCount != 0) {
            String str = input.nextLine();
            int[] spaces = readImage(input, lineCount);
            lineCount = getNumberofLines(input);
            int remainingSpace = findRemainingSpace(spaces, lineCount);
            sb.append(remainingSpace);
            sb.append("\n");
        }

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
