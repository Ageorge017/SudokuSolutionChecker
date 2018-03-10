/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_sudokupuzzle;

/**
 *
 * @author albertgeorge
 */
public class Lab3_SudokuPuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [][]sudoku = {
            {2,4,6,8,5,7,9,1,3},  //row 1
            {1,8,9,6,4,3,2,7,5},  //row 2
            {5,7,3,2,9,1,4,8,6},  //row 3
            {4,1,8,3,2,9,5,6,7},  //row 4
            {6,3,7,4,8,5,1,2,9},  //row 5
            {9,5,2,1,7,6,3,4,8},  //row 6
            {7,6,4,5,3,2,8,9,1},  //row 7
            {3,2,1,9,6,8,7,5,4},  //row 8
            {8,9,5,7,1,4,6,3,2}   //row 9
        };
        int []tempList = new int[9];
        boolean error = false;
        
        //prints out sudoku solution
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            System.out.print(sudoku[i][j] + " ");
            }
        System.out.println();
        }
        
        //Loop validates the numbers in range 0-9
        for (int i = 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
                if ((sudoku[i][j] < 0 || sudoku[i][j]>9)){
                    System.out.println("Not valid number in row-column: "+ (1+i) +"-" + (1+j) +"." );
                    error =  true;
                }
            
            }
        }
        
        //Row check
        for (int i = 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
                //Creates a temporary list for a row
                tempList[j] = sudoku[i][j];  
            }
                //Checks row for duplicate
                for (int k = 0; k < tempList.length; k++){
                    for(int l = (k +1); l < tempList.length; l++){
                        if (tempList[k]==(tempList[l])){
                            System.out.println("Duplicate number in a row.");
                            error = true;
                        }
                    }
                }
        }
        
        //Column check
        for (int i = 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
                //Creates a temporary list for a column
                tempList[j] = sudoku[j][i];  
            }
                //Checks column for duplicate
                for (int k = 0; k < tempList.length; k++){
                    for(int l = (k +1); l < tempList.length; l++){
                        if (tempList[k]==(tempList[l])){
                            System.out.println("Duplicate number in a column.");
                            error = true;
                        }
                    }
                }
        }
        
        //3x3 box check
        for (int i = 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
                //creates temporary list from each 3x3 section
                tempList[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            
            //Checks boxes for duplicate
            for (int k = 0; k < tempList.length; k++){
                    for(int l = (k +1); l < tempList.length; l++){
                        if (tempList[k]==(tempList[l])){
                            System.out.println("Duplicate number in a box.");
                            error = true;
                        }
                    }
                }
            }
            
        //Displays message if no duplicates were found
        if (!error){
            System.out.println("Solution has no errors.");
        }
        
    }
    
}