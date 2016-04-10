/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SolvedProblems;

//162 
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author InspireServe
 */
class MyLinkedList{
    int currsentSize = 0;
    int first = 0;
    int last = 0;
    int maxSize = 54; //52 + 2
    int data[] = new int[maxSize];
    LinkedList<String> l;
    int size(){
        return currsentSize;
    }//ed of size
    
    boolean isEmpty(){ 
        return ((currsentSize == 0)?true:false);
    }//endof isEmpty
    
    void addFirst(int val){
        first = (maxSize + (first - 1)) % maxSize;
        data[first] = val;
        currsentSize++;
    }//end of add First
     
    int removeFirst(){
        int val = data[first];
        first = (maxSize + (first + 1)) % maxSize;
        currsentSize--;
        return val;
    }//end of removeFirst
    
    void addLast(int val){
        last = (maxSize + (last + 1)) % maxSize;
        data[last] = val;
        currsentSize++;
    }//end of add last
    
    int removeLast(){
        int val = data[last];
        last = (maxSize + (last - 1)) % maxSize;
        currsentSize--;
        return val;
    }//end of remove Last
    
    void reInit(){
        first = 0;
        last = 0;
        currsentSize = 0;
    }
}//end of class
class Main_162 {
    
    public static LinkedList<Integer> playerCard[];
    public static LinkedList<Integer> cardQueue;
    //public static MyLinkedList playerCard[];
    //public static MyLinkedList cardQueue;
    
    //public static void main(String args[]) throws FileNotFoundException{
    public static void main(String args[]) throws IOException{
        //initialize datastructure
        playerCard = new LinkedList[2];
         playerCard[0] = new LinkedList<Integer>();
         playerCard[1] = new LinkedList<Integer>();
          
         cardQueue = new LinkedList<Integer>();
        
        //playerCard = new MyLinkedList[2];
        //playerCard[0] = new MyLinkedList();
        //playerCard[1] = new MyLinkedList();

        //cardQueue = new MyLinkedList();

        //end of initialization
        //test();
        
        run();
    }//end of main
    
    //public static void run()throws FileNotFoundException{
    public static void run() throws IOException{
        
        
        
        //take input
        //Scanner lineReader = new Scanner(System.in);
        //BufferedReader lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner lineReader = new Scanner(new File("input.txt"));
        //Scanner valueReader;
        StringTokenizer valueReader;
        String line;
        while (true) {
            
            line = lineReader.readLine();
            if(line.trim().startsWith("#")){
                break;
            }
            
            //create data structures here
            //playerCard[0] = new MyLinkedList();
            //playerCard[1] = new MyLinkedList();

            //cardQueue = new MyLinkedList();

            playerCard[0] = new LinkedList();
            playerCard[1] = new LinkedList();

            cardQueue = new LinkedList();

            
            //printf(line);
            
            String totalCards = line;
            //read whole cards
            for (int i = 0; i < 3; i++) {
                line = lineReader.readLine();
                totalCards = totalCards + " " + line;
            }//end for
            
            //printf(totalCards);
            valueReader = new StringTokenizer(totalCards);
            
            //deal card
            for(int dealNum = 0; dealNum < 26; dealNum++){
                //non dealer gets first
                playerCard[1].addLast(getValue(valueReader.nextToken()));
                //dealer gets last
                playerCard[0].addLast(getValue(valueReader.nextToken()));
            }//end deal
            
            boolean gameOver = false;
            int turn = 1; //0 and 1 for player 1 and 2
            int due = 0;
            int winner = -1;
            int card;
            while(gameOver == false){
                //game over case
                if(playerCard[turn].size() == 0){
                    gameOver = true;
                    winner = nextPlayer(turn);
                    //ignore all the other lines
                    continue;
                }//end of game ove case
                
               //card is not empty so take one
               //remember we added new card to last when dealing\
                //so remove from last
               card = playerCard[turn].removeLast();
               //add this card to stack card
               //this stack will go face down to winner's list 
               //similar to queue structure
               cardQueue.addLast(card);
               
               //check card 
               //if it is normal case
               //if it is player's turn to pay due
               //if it is a face card
               
               if(card == 0){   //normal case
                   if(due != 0){
                       //reduce due
                       due--;
                       //all due paid now 
                        //add stack of card to other players bottom
                        //other player should play                       
                       if (due == 0) {
                           int sizeOfQueCard = cardQueue.size();
                           while (sizeOfQueCard > 0) {
                               playerCard[nextPlayer(turn)].addFirst(cardQueue.removeFirst());
                               sizeOfQueCard--;
                           }//end while
                       } else {
                           //due not paid 
                           // no need to flip player
                           continue;
                       }
                   }
               } else { //this player has showed a face card
                   due = card;
               }//
               
               turn = nextPlayer(turn);
               
            }//end one game
            //printf((winner + 1) + " " + playerCard[winner].size());
            System.out.format("%d%3d\n", (winner  + 1), playerCard[winner].size());
            

        }//end while
        //printf(playerCard[0].toString() + " " + playerCard[0].size());
        /*
         int numberOfTestCases = Integer.parseInt(lineReader.readLine());
         for(int i = 0; i < numberOfTestCases; i++){
        
         }//end for
         */
    }//end of run
    
    public static void test(){
        //printf("" + getValue("HA") + " " + getValue("CT") + " " + getValue("DK")+ getValue("SJ"));
        for(int i = 0; i < 3; i++){
            cardQueue.addFirst(i);
        }
        for(int i = 0; i < 3; i++){
            cardQueue.addLast(i+3);
        }
        
        for(int i = 0; i < 3; i++){
            cardQueue.removeFirst();
        }
        
        for(int i = 0; i < 3; i++){
            cardQueue.removeLast();
        }
        
        cardQueue.size();
    }//end of test
    
    public static void printf(String str){
        System.out.println(str);
    }//end of printf
    
    public static int getValue(String card){
        char number = card.charAt(1);
        switch (number) {
            case 'A':
                return 4;
            //break;
            case 'K':
                return 3;
            // break;
            case 'Q':
                return 2;
            //  break;
            case 'J':
                return 1;
            //  break;
            default:
                return 0;
        }
    }//end of getValue
    
    public static int nextPlayer(int currentPlayer){
        return (currentPlayer + 1) % 2;
    }//end of nextPlayer
}//end of class
