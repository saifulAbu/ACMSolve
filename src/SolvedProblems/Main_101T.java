package SolvedProblems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Main_101T {

    public static final boolean DEBUG = true;
    
    public static int[] count;
    public static int[][] block;
    public static int[] x;
    public static int[] y;
    
    public static void init(int size){
        count = new int[size];
        block = new int[size][size];
        x = new int[size];
        y = new int[size];
        
        for(int i = 0; i < size; i++){
            block[i][0] = i;
            x[i] = i;
            y[i] = 0;
            count[i] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedOutputStream output;
        //StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        //InputReader input;
        Scanner input;
        if (DEBUG) {
            output = new BufferedOutputStream(System.out);
            input = new Scanner(new File("input.txt"));;
        }else{
            output = new BufferedOutputStream(System.out);
            input = new Scanner(System.in);
        }
        
        int blockCount = input.nextInt();
        init(blockCount);
        println("num blocks " + blockCount);
        while(input.hasNext()){
            String firstPart = input.next();
            if(firstPart.equals("quit")){
                println("quit");
                break;
            }
            
            int movingBlock = input.nextInt();
            String secondPart = input.next();
            int staticBlock = input.nextInt();
            
            if(firstPart.equals("move")){
                if(secondPart.equals("onto")){
                    moveOnto(movingBlock, staticBlock);
                }else{
                    moveOver(movingBlock, staticBlock);
                }
            }else{
                if(secondPart.equals("onto")){
                    pileOnto(movingBlock, staticBlock);
                }else{
                    pileOver(movingBlock, staticBlock);
                }
            }
        }
        
        StringBuilder sb = printBlockWorldState();

        output.write(sb.toString().getBytes());
        output.flush();
        output.close();

    }// end of static void main

    private static void println(String string) {
        System.out.println(string);
    }
    
    private static void returnBlock(int i, int j){
        int blck = block[i][j];
        println("moving block " + blck);
        count[i]--;
        count[blck]++;
        
        block[i][j] = -1;
        block[blck][0] = blck;
        
        x[blck] = blck;
        y[blck] = 0;
    }
    
    private static void returnAllBlocksFrom(int blck){
        println("returning all blocks from " + blck);
        int block_x = x[blck];
        int block_y = y[blck];
        int numBlockOver = count[block_x] - block_y - 1;
        for(int i = 1; i <= numBlockOver; i++){
            returnBlock(block_x, block_y + i);
        }
    }
    
    private static boolean onSameColumn(int block1, int block2){
        return (x[block1] == x[block2]);
    }

    private static void moveOnto(int movingBlock, int staticBlock) {
        if(onSameColumn(movingBlock, staticBlock)){
            return;
        }
        returnAllBlocksFrom(staticBlock);
        moveOver(movingBlock, staticBlock);
    }

    private static void moveOver(int movingBlock, int staticBlock) {
        if(onSameColumn(staticBlock, movingBlock)){
            return;
        }
        
        returnAllBlocksFrom(movingBlock);
        
        int m_x = x[movingBlock];
        int m_y = y[movingBlock];
        int s_x = x[staticBlock];
        
        block[s_x][count[s_x]] = movingBlock;
        block[m_x][m_y] = -1;
        
        x[movingBlock] = s_x;
        y[movingBlock] = count[s_x];
        
        count[m_x]--;
        count[s_x]++;
    }
    
    private static void shiftblock(int movingBlock, int staticBlock){
        return;
    }
    
    private static void shiftBlocks(int movingBlock, int staticBlock){
        //numblocksOver = numBlocks(movingBlock)
        //m_y = moving block's y
        //m_x = moving block's x
        //count[m_x] = count[m_x] - numblocksover - 1
        //for i = 0; i <= numBlocksover; i++
        // shift block m_x, m_y + i to static block
        return;
    }
    

    private static void pileOnto(int movingBlock, int staticBlock) {
        returnAllBlocksFrom(staticBlock);
        shiftBlocks(movingBlock, staticBlock);
    }

    private static void pileOver(int movingBlock, int staticBlock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static StringBuilder printBlockWorldState() {
        StringBuilder sb = new StringBuilder(2000); //assume initial size of 2000 chars
        for(int i = 0; i < block.length; i++){
            String str = i + ": ";
            for(int j = 0; j < count[i]; j++){
                str = str + block[i][j] + " ";
            }
            str = str + "\n";
            sb.append(str);
        }
        return sb;
    }
    
    /**stuffs to solve the problem*/
    
    /** stuffs to solve the problem end **/

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
