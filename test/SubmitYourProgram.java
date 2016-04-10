/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author InspireServe
 */
public class SubmitYourProgram {
    
    public static void main(String[] args){
        int maxLine = 4;
        for(int cl = 0; cl < maxLine; cl++){
            int space = maxLine - cl - 1;
            int star = 2* cl + 1;
            for(int i = 0; i < space; i++){
                System.out.print(" ");
            }
            for (int i = 0; i < star; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
