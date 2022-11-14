package OfficialSudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku2 {

    //Matrix representing the board:-
    public static int[][] matrix = new int[9][9];

    //TEST MATRIX:-
    public static int [][] matrix1 = new int[][]{
            {9, 2, 1, 3, 6, 5, 7, 8, 4},
            {5, 6, 4, 7, 8, 2, 9, 1, 3},
            {3, 7, 8, 1, 9, 4, 2, 5, 6},
            {6, 9, 3, 8, 2, 1, 5, 4, 7},
            {4, 8, 7, 9, 5, 6, 1, 3, 2},
            {2, 1, 5, 4, 3, 7, 6, 9, 8},
            {7, 5, 9, 2, 4, 3, 8, 6, 1},
            {1, 4, 6, 5, 7, 8, 3, 2, 9},
            {8, 3, 2, 6, 1, 9, 4, 7, 5}

    };

    //Given board:
    public static int[][] Board(){

        System.out.println("=======================");
        System.out.println("===== Given board =====");
        System.out.println("=======================");

        //Using the matrix format to print out the board.
        matrix = new int[][]{

                // 0 represents no presence of integer.
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // ORDER OF GRIDS FOR MATRIX:-
        /*
        GRID1,GRID2,GRID3;
        GRID4,GRID5,GRID6;
        GRID7,GRID8,GRID9
         */


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======================");

        return matrix;

    }

    private static int [][] smartSolver(int [][] matrix){

        // GIVEN SOLUTIONS:-
        for(int row = 0; row< matrix.length;row++){
            for(int col=0;col< matrix.length;col++){

                if(matrix[row][col]!=0) {
                    for (int i = 1; i<= matrix.length ; i++) {

                        if (isValidPlaced(matrix, i, row, col)) {

                            //FOR GRID-1"
                            if (row == 0 && col == 1 && matrix[0][2]!=0 && i == matrix[0][2] *2 || i == matrix[0][2] /2 && isValidPlaced(matrix, i, 0, 1)) {
                                matrix[0][1] = i;
                            }
                            if (row == 0 && col == 2  && matrix[0][1]!=0 && i == matrix[0][1] *2 || i == matrix[0][1] /2 && isValidPlaced(matrix, i, 0, 2)) {
                                matrix[0][2] = i;
                            }
                            if (row == 1 && col == 0  && matrix[1][1]!=0 && i == matrix[1][1] +1 || i == matrix[1][1] -1 && isValidPlaced(matrix, i, 1, 0)) {
                                matrix[1][0] = i;
                            }
                            if (row == 1 && col == 1  && matrix[1][0]!=0 && i == matrix[1][0] +1 || i == matrix[1][0] -1 && isValidPlaced(matrix, i, 1, 1)) {
                                matrix[1][1] = i;
                            }
                            if (row == 1 && col == 1  && matrix[2][1]!=0 && i == matrix[2][1] +1 || i == matrix[2][1] -1 && isValidPlaced(matrix, i, 1, 1)) {
                                matrix[1][1] = i;
                            }
                            if (row == 2 && col == 1  && matrix[1][1]!=0 && i == matrix[1][1] +1 || i == matrix[1][1] -1 && isValidPlaced(matrix, i, 2, 1)) {
                                matrix[2][1] = i;
                            }
                            if (row == 2 && col == 1  && matrix[2][2]!=0 && i == matrix[2][2] +1 || i == matrix[2][2] -1 && isValidPlaced(matrix, i, 2, 1)) {
                                matrix[2][1] = i;
                            }
                            if (row == 2 && col == 2  && matrix[2][1]!=0 && i == matrix[2][1] +1 || i == matrix[2][1] -1 && isValidPlaced(matrix, i, 2, 2)) {
                                matrix[2][2] = i;
                            }
                            if (row == 2 && col == 2  && matrix[1][2]!=0 && i == matrix[1][2] *2 || i == matrix[1][2] /2 && isValidPlaced(matrix, i, 2, 2)) {
                                matrix[2][2] = i;
                            }
                            if (row == 1 && col == 2  && matrix[2][2]!=0 && i == matrix[2][2] +1 || i == matrix[2][2] -1 && isValidPlaced(matrix, i, 1, 2)) {
                                matrix[1][2] = i;
                            }
                            if (row == 2 && col == 0  && matrix[3][0]!=0 &&  i == matrix[3][0] *2 || i == matrix[3][0] /2 && isValidPlaced(matrix, i, 2, 0)) {
                                matrix[2][0] = i;
                            }

                            //FOR GRID-2"
                            if (row == 0 && col == 3  && matrix[0][4]!=0 && i == matrix[0][4] *2 || i == matrix[0][4] /2 && isValidPlaced(matrix, i, 0, 3)) {
                                matrix[0][3] = i;
                            }
                            if (row == 0 && col == 4 && matrix[0][3]!=0 && i == matrix[0][3] *2 || i == matrix[0][3] /2 && isValidPlaced(matrix, i, 0, 4)) {
                                matrix[0][4] = i;
                            }
                            if (row == 0 && col == 4 && matrix[0][5]!=0 && i == matrix[0][5] +1 || i == matrix[0][5] -1 && isValidPlaced(matrix, i, 0, 4)) {
                                matrix[0][4] = i;
                            }
                            if (row == 0 && col == 5 && matrix[0][4]!=0 && i == matrix[0][4] +1 || i == matrix[0][4] -1 && isValidPlaced(matrix, i, 0, 5)) {
                                matrix[0][5] = i;
                            }
                            if (row == 1 && col == 3 && matrix[1][4]!=0 && i == matrix[1][4] +1 || i == matrix[1][4] -1 && isValidPlaced(matrix, i, 1, 3)) {
                                matrix[1][3] = i;
                            }
                            if (row == 1 && col == 4 && matrix[1][3]!=0 && i == matrix[1][3] +1 || i == matrix[1][3] -1 && isValidPlaced(matrix, i, 1, 4)) {
                                matrix[1][4] = i;
                            }
                            if (row == 1 && col == 4 && matrix[2][4]!=0 && i == matrix[2][4] +1 || i == matrix[2][4] -1 && isValidPlaced(matrix, i, 1, 4)) {
                                matrix[1][4] = i;
                            }
                            if (row == 1 && col == 5 && matrix[2][5]!=0 && i == matrix[2][5] *2 || i == matrix[2][5] /2 && isValidPlaced(matrix, i, 1, 5)) {
                                matrix[1][5] = i;
                            }
                            if (row == 2 && col == 4 && matrix[1][4]!=0 && i == matrix[1][4] +1 || i == matrix[1][4] -1 && isValidPlaced(matrix, i, 2, 4)) {
                                matrix[2][4] = i;
                            }
                            if (row == 2 && col == 5 && matrix[1][5]!=0 && i == matrix[1][5] *2 || i == matrix[1][5] /2 && isValidPlaced(matrix, i, 2, 5)) {
                                matrix[2][5] = i;
                            }
                            if (row == 2 && col == 5 && matrix[2][6]!=0 && i == matrix[2][6] *2 || i == matrix[2][6] /2 && isValidPlaced(matrix, i, 2, 5)) {
                                matrix[2][5] = i;
                            }

                            //FOR GRID-3"
                            if (row == 0 && col == 6 && matrix[0][7]!=0  && i == matrix[0][7] +1 || i == matrix[0][7] -1 && isValidPlaced(matrix, i, 0, 6)) {
                                matrix[0][6] = i;
                            }
                            if (row == 0 && col == 7 && matrix[0][6]!=0 && i == matrix[0][6] +1 || i == matrix[0][6] -1 && isValidPlaced(matrix, i, 0, 7)) {
                                matrix[0][7] = i;
                            }
                            if (row == 0 && col == 7 && matrix[0][8]!=0  && i == matrix[0][8] *2 || i == matrix[0][8] /2 && isValidPlaced(matrix, i, 0, 7)) {
                                matrix[0][7] = i;
                            }
                            if (row == 0 && col == 8 && matrix[0][7]!=0 && i == matrix[0][7] *2 || i == matrix[0][7] /2 && isValidPlaced(matrix, i, 0, 8)) {
                                matrix[0][8] = i;
                            }
                            if (row == 0 && col == 8 && matrix[0][8]!=0 && i == matrix[1][8] +1 || i == matrix[1][8] -1 && isValidPlaced(matrix, i, 0, 8)) {
                                matrix[0][8] = i;
                            }
                            if (row == 1 && col == 8 && matrix[0][8]!=0 && i == matrix[0][8] +1 || i == matrix[0][8] -1 && isValidPlaced(matrix, i, 1, 8)) {
                                matrix[1][8] = i;
                            }
                            if (row == 1 && col == 8 && matrix[2][8]!=0 && i == matrix[2][8] *2 || i == matrix[2][8] /2 && isValidPlaced(matrix, i, 1, 8)) {
                                matrix[1][8] = i;
                            }
                            if (row == 2 && col == 8 && matrix[1][8]!=0 && i == matrix[1][8] *2 || i == matrix[1][8] /2 && isValidPlaced(matrix, i, 2, 8)) {
                                matrix[2][8] = i;
                            }
                            if (row == 2 && col == 8 && matrix[3][8]!=0 && i == matrix[3][8] +1 || i == matrix[3][8] -1 && isValidPlaced(matrix, i, 2, 8)) {
                                matrix[2][8] = i;
                            }
                            if (row == 2 && col == 8 && matrix[2][7]!=0 && i == matrix[2][7] +1 || i == matrix[2][7] -1 && isValidPlaced(matrix, i, 2, 8)) {
                                matrix[2][8] = i;
                            }
                            if (row == 2 && col == 7 && matrix[2][8]!=0 && i == matrix[2][8] +1 || i == matrix[2][8] -1 && isValidPlaced(matrix, i, 2, 7)) {
                                matrix[2][7] = i;
                            }
                            if (row == 2 && col == 7 && matrix[3][7]!=0 && i == matrix[3][7] +1 || i == matrix[3][7] -1 && isValidPlaced(matrix, i, 2, 7)) {
                                matrix[2][7] = i;
                            }
                            if (row == 2 && col == 6 && matrix[2][5]!=0 && i == matrix[2][5] *2 || i == matrix[2][5] /2 && isValidPlaced(matrix, i, 2, 6)) {
                                matrix[2][6] = i;
                            }


                            //FOR GRID-4"-
                            if (row == 3 && col == 1 && matrix[4][1]!=0 && i == matrix[4][1] +1 || i == matrix[4][1] -1 && isValidPlaced(matrix, i, 3, 1)) {
                                matrix[3][1] = i;
                            }
                            if(row==4 && col==2  && matrix[4][1]!=0 && i == matrix[4][1]+1 || i == matrix[4][1]-1 && isValidPlaced(matrix,i,4,2)){
                                matrix[4][2]=i;
                            }
                            if(row==4 && col==0  && matrix[4][1]!=0 && i == matrix[4][1]*2 || i == matrix[4][1]/2 && isValidPlaced(matrix,i,4,0) ){
                                matrix[4][0]=i;
                            }
                            if(row==5 && col==0  && matrix[4][0]!=0 && i == matrix[4][0]*2 || i == matrix[4][0]/2 && isValidPlaced(matrix,i,5,0) ){
                                matrix[5][0]=i;
                            }
                            if(row==5 && col==1  && matrix[5][0]!=0 && i == matrix[5][0]*2 || i == matrix[5][0]/2 && isValidPlaced(matrix,i,5,1) ){
                                matrix[5][1]=i;
                            }
                            if(row==5 && col==2  && matrix[5][3]!=0 && i == matrix[5][3]+1 || i == matrix[5][3]-1 && isValidPlaced(matrix,i,5,2) ){
                                matrix[5][2]=i;
                            }


                            //FOR GRID-5"
                            if(row==3 && col==3  && matrix[4][3]!=0 && i == matrix[4][3]+1 || i == matrix[4][3]-1 && isValidPlaced(matrix,i,3,3)){
                                matrix[3][3]=i;
                            }
                            if(row==4 && col==3  && matrix[3][3]!=0 && i == matrix[3][3]+1 || i == matrix[3][3]-1 && isValidPlaced(matrix,i,4,3)){
                                matrix[4][3]=i;
                            }
                            if(row==3 && col==4  && matrix[3][5]!=0 && i == matrix[3][5]*2 || i == matrix[3][5]/2 && isValidPlaced(matrix,i,3,4) ){
                                matrix[3][4]=i;
                            }
                            if(row==3 && col==5  && matrix[3][4]!=0 && i == matrix[3][4]*2 || i == matrix[3][4]/2 && isValidPlaced(matrix,i,3,5) ){
                                matrix[3][5]=i;
                            }
                            if(row==4 && col==5  && matrix[4][4]!=0 && i == matrix[4][4]+1 || i == matrix[4][4]-1 && isValidPlaced(matrix,i,4,5) ){
                                matrix[4][5]=i;
                            }if(row==4 && col==5  && matrix[5][5]!=0 && i == matrix[5][5]+1 || i == matrix[5][5]-1 && isValidPlaced(matrix,i,4,5) ){
                                matrix[4][5]=i;
                            }
                            if(row==4 && col==4  && matrix[4][5]!=0 && i == matrix[4][5]+1 || i == matrix[4][5]-1 && isValidPlaced(matrix,i,4,4) ){
                                matrix[4][4]=i;
                            }
                            if(row==5 && col==5  && matrix[4][5]!=0 && i == matrix[4][5]+1 || i == matrix[4][5]-1 && isValidPlaced(matrix,i,5,5) ){
                                matrix[5][5]=i;
                            }
                            if(row==5 && col==5  && matrix[5][6]!=0 && i == matrix[5][6]+1 || i == matrix[5][6]-1 && isValidPlaced(matrix,i,5,5)){
                                matrix[5][5]=i;
                            }
                            if(row==5 && col==4  && matrix[5][3]!=0 && i == matrix[5][3]+1 || i == matrix[5][3]-1 && isValidPlaced(matrix,i,5,4)){
                                matrix[5][4]=i;
                            }
                            if(row==5 && col==4  && matrix[6][4]!=0 && i == matrix[6][4]+1 || i == matrix[6][4]-1 && isValidPlaced(matrix,i,5,4)){
                                matrix[5][4]=i;
                            }
                            if(row==5 && col==3  && matrix[5][4]!=0 && i == matrix[5][4]+1 || i == matrix[5][4]-1 && isValidPlaced(matrix,i,5,3)){
                                matrix[5][3]=i;
                            }
                            if(row==5 && col==3  && matrix[6][3]!=0 && i == matrix[6][3]*2 || i == matrix[6][3]/2 && isValidPlaced(matrix,i,5,3)){
                                matrix[5][3]=i;
                            }
                            if(row==5 && col==3  && matrix[5][2]!=0 && i == matrix[5][2]+1 || i == matrix[5][2]-1 && isValidPlaced(matrix,i,5,3)){
                                matrix[5][3]=i;
                            }


                            //FOR GRID-6"
                            if(row==3 && col==6  && matrix[3][7]!=0 && i == matrix[3][7]+1 || i == matrix[3][7]-1 && isValidPlaced(matrix,i,3,6)){
                                matrix[3][6]=i;
                            }
                            if(row==3 && col==7  && matrix[3][6]!=0 && i == matrix[3][6]+1 || i == matrix[3][6]-1 && isValidPlaced(matrix,i,3,7)){
                                matrix[3][7]=i;
                            }
                            if(row==3 && col==7  && matrix[2][7]!=0 && i == matrix[2][7]+1 || i == matrix[2][7]-1 && isValidPlaced(matrix,i,3,7)){
                                matrix[3][7]=i;
                            }
                            if(row==3 && col==7  && matrix[4][7]!=0 && i == matrix[4][7]+1 || i == matrix[4][7]-1 && isValidPlaced(matrix,i,3,7)){
                                matrix[3][7]=i;
                            }
                            if(row==3 && col==8  && matrix[2][8]!=0 && i == matrix[2][8]+1 || i == matrix[2][8]-1 && isValidPlaced(matrix,i,3,8)){
                                matrix[3][8]=i;
                            }
                            if(row==4 && col==8  && matrix[4][7]!=0 && i == matrix[4][7]+1 || i == matrix[4][7]-1 && isValidPlaced(matrix,i,4,8)){
                                matrix[4][8]=i;
                            }
                            if(row==4 && col==7  && matrix[3][7]!=0 && i == matrix[3][7]+1 || i == matrix[3][7]-1 && isValidPlaced(matrix,i,4,7)){
                                matrix[4][7]=i;
                            }
                            if(row==4 && col==7  && matrix[4][8]!=0 && i == matrix[4][8]+1 || i == matrix[4][8]-1 && isValidPlaced(matrix,i,4,7)){
                                matrix[4][7]=i;
                            }
                            if(row==5 && col==8  && matrix[5][7]!=0 && i == matrix[5][7]+1 || i == matrix[5][7]-1 && isValidPlaced(matrix,i,5,8)){
                                matrix[5][8]=i;
                            }
                            if(row==5 && col==7  && matrix[5][8]!=0 && i == matrix[5][8]+1 || i == matrix[5][8]-1 && isValidPlaced(matrix,i,5,7)){
                                matrix[5][7]=i;
                            }
                            if(row==5 && col==6  && matrix[5][5]!=0 && i == matrix[5][5]+1 || i == matrix[5][5]-1 && isValidPlaced(matrix,i,5,6)){
                                matrix[5][6]=i;
                            }

                            //FOR GRID-7"
                            if(row==6 && col==1  && matrix[7][1]!=0 && i == matrix[7][1]+1 || i == matrix[7][1]-1 && isValidPlaced(matrix,i,6,1)){
                                matrix[6][1]=i;
                            }
                            if(row==7 && col==1  && matrix[6][1]!=0 && i == matrix[6][1]+1 || i == matrix[6][1]-1 && isValidPlaced(matrix,i,7,1)){
                                matrix[7][1]=i;
                            }
                            if(row==7 && col==1  && matrix[8][1]!=0 && i == matrix[8][1]+1 || i == matrix[8][1]-1 && isValidPlaced(matrix,i,7,1)){
                                matrix[7][1]=i;
                            }
                            if(row==8 && col==1  && matrix[7][1]!=0 && i == matrix[7][1]+1 || i == matrix[7][1]-1 && isValidPlaced(matrix,i,8,1)){
                                matrix[8][1]=i;
                            }
                            if(row==8 && col==1  && matrix[8][2]!=0 && i == matrix[8][2]+1 || i == matrix[8][2]-1 && isValidPlaced(matrix,i,8,1)){
                                matrix[8][1]=i;
                            }
                            if(row==8 && col==2  && matrix[8][1]!=0 && i == matrix[8][1]+1 || i == matrix[8][1]-1 && isValidPlaced(matrix,i,8,2)){
                                matrix[8][2]=i;
                            }
                            if(row==7 && col==2  && matrix[7][3]!=0 && i == matrix[7][3]+1 || i == matrix[7][3]-1 && isValidPlaced(matrix,i,7,2)){
                                matrix[7][2]=i;
                            }

                            //FOR GRID-8"
                            if(row==7 && col==3  && matrix[7][2]!=0 && i == matrix[7][2]+1 || i == matrix[7][2]-1 && isValidPlaced(matrix,i,7,3)){
                                matrix[7][3]=i;
                            }
                            if(row==7 && col==3  && matrix[8][3]!=0 && i == matrix[8][3]+1 || i == matrix[8][3]-1 && isValidPlaced(matrix,i,7,3)){
                                matrix[7][3]=i;
                            }
                            if(row==8 && col==3  && matrix[7][3]!=0 && i == matrix[7][3]+1 || i == matrix[7][3]-1 && isValidPlaced(matrix,i,8,3)){
                                matrix[8][3]=i;
                            }
                            if(row==8 && col==5  && matrix[7][5]!=0 && i == matrix[7][5]+1 || i == matrix[7][5]-1 && isValidPlaced(matrix,i,8,5)){
                                matrix[8][5]=i;
                            }
                            if(row==7 && col==5  && matrix[8][5]!=0 && i == matrix[8][5]+1 || i == matrix[8][5]-1 && isValidPlaced(matrix,i,7,5)){
                                matrix[7][5]=i;
                            }
                            if(row==7 && col==5  && matrix[7][4]!=0 && i == matrix[7][4]+1 || i == matrix[7][4]-1 && isValidPlaced(matrix,i,7,5)){
                                matrix[7][5]=i;
                            }
                            if(row==6 && col==5  && matrix[6][4]!=0 && i == matrix[6][4]+1 || i == matrix[6][4]-1 && isValidPlaced(matrix,i,6,5)){
                                matrix[6][5]=i;
                            }
                            if(row==6 && col==4  && matrix[6][5]!=0 && i == matrix[6][5]+1 || i == matrix[6][5]-1 && isValidPlaced(matrix,i,6,4)){
                                matrix[6][4]=i;
                            }
                            if(row==6 && col==4  && matrix[5][4]!=0 && i == matrix[5][4]+1 || i == matrix[5][4]-1 && isValidPlaced(matrix,i,6,4)){
                                matrix[6][4]=i;
                            }
                            if(row==6 && col==4  && matrix[6][3]!=0 && i == matrix[6][3]*2 || i == matrix[6][3]/2 && isValidPlaced(matrix,i,6,4)){
                                matrix[6][4]=i;
                            }
                            if(row==6 && col==3  && matrix[6][4]!=0 && i == matrix[6][4]*2 || i == matrix[6][4]/2 && isValidPlaced(matrix,i,6,3)){
                                matrix[6][3]=i;
                            }
                            if(row==6 && col==3  && matrix[5][3]!=0 && i == matrix[5][3]*2 || i == matrix[5][3]/2 && isValidPlaced(matrix,i,6,3)){
                                matrix[6][3]=i;
                            }

                            //FOR GRID-9"
                            if(row==7 && col==6  && matrix[7][7]!=0 && i == matrix[7][7]+1 || i == matrix[7][7]-1 && isValidPlaced(matrix,i,7,6)){
                                matrix[7][6]=i;
                            }
                            if(row==7 && col==6  && matrix[8][6]!=0 && i == matrix[8][6]+1 || i == matrix[8][6]-1 && isValidPlaced(matrix,i,7,6)){
                                matrix[7][6]=i;
                            }
                            if(row==7 && col==7  && matrix[7][6]!=0 && i == matrix[7][6]+1 || i == matrix[7][6]-1 && isValidPlaced(matrix,i,7,7)){
                                matrix[7][7]=i;
                            }
                            if(row==8 && col==6  && matrix[7][6]!=0 && i == matrix[7][6]+1 || i == matrix[7][6]-1 && isValidPlaced(matrix,i,8,6)){
                                matrix[8][6]=i;
                            }

                        }
                    }
                }
            }

        }
        return matrix;
    }


    // SOLVING FOR THE SUDOKU:-
    // VERIFYING UNIQUE-NUMS POSITION:-

    //Checking for unique-numbers in row:
    private static boolean isNumInRow(int [] [] board, int num, int row){
        for (int i = 0; i< board.length;i++){
            if (board[row][i]==num){
                
                return true;
            }
        }
        return false;
    }

    //Checking for unique-numbers in column:
    private static boolean isNumInCol(int [] [] board, int num, int col){
        for (int i = 0; i< board.length;i++){
            if (board[i][col]==num){
                return true;
            }
        }
        return false;
    }

    //Checking for unique-numbers in sub-grid:
    private static boolean isNumInSubGrid(int [] [] board, int num, int row, int col){
        //Starting co-ordinates of the sub-grid:-
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        //Looping through all the elements of the sub-grid:-
        for (int i = localBoxRow; i<localBoxRow+3;i++){
            for (int j = localBoxCol; j<localBoxCol+3;j++){
                if (board[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlaced(int [][] board,int num, int row, int col){
        //Checking for valid placement by expecting false bool through following statement:-
        return !isNumInRow(board,num,row) && !isNumInCol(board,num,col) &&
                !isNumInSubGrid(board,num,row,col);
    }


    //SOLVING THE BOARD:-
    private static boolean solveBoard(int [][] board){

        // Iterating through rows:
        for(int row = 0; row < matrix.length;row++){
            // Iterating through columns:
            for(int col = 0; col< matrix.length;col++){

                // Insuring all cells are filled:-
               if (board[row][col]==0) {
                   for (int numToTry = 1; numToTry <= matrix.length; numToTry++) {
                       if (isValidPlaced(board, numToTry, row, col)) {

                           // Putting in value.
                           // FOR ALL ZERO VALUES.
                           board[row][col] = numToTry;


                           //Solving the board based on given data from question, after it starts filling with numbers:-
                           //smartSolver(board);

                           //Recursively calling this resp. func to solve the complete board.
                           if (solveBoard(board)){
                               return true;

                           }

                           else {
                               // In-case the above int doesn't work:-
                               board[row][col] = 0;
                           }

                       }
                    }
                   return false;
               }
            }
        }
        return true;
    }


    //Object to return first non-zero element of the provided array-list.
    private static int get_arrayNum(ArrayList<Integer> arraylist){
        int element = 0;
        for (int i = 0; i<arraylist.size();i++){
            if(arraylist.get(i)!=0){
                element = arraylist.get(i);
            }
        }
        return element;
    }

    private static int[][] pivoting_Cell(int [] [] matrix, int n , int row, int col){
        ArrayList<Integer> num_array = new ArrayList<>();
        num_array.add(1);num_array.add(2);num_array.add(3);num_array.add(4);num_array.add(5);num_array.add(6);
        num_array.add(7);num_array.add(8);num_array.add(9);

        //Starting co-ordinates of the sub-grid:-
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        //Looping through all the elements of the sub-grid:-
        for (int i = 0; i<matrix.length;i++){
            for (int j = 0; j< matrix.length;j++){

                //Converts int to zero in given list:-
                if(matrix[i][j]!=0 && num_array.contains(matrix[i][j])){

                    int ind = num_array.indexOf(matrix[i][j]);

                    if(num_array.contains(matrix[i][j])){
                        num_array.set(ind,0);
                    }
                }

                try {
                    //Sets int on given int and 'smart-solves' it.
                    if (n != 0 && matrix[i][j] == 0) {
                        if (isValidPlaced(matrix, n, i, j)) {
                            matrix[i][j] = n;
                            smartSolver(matrix);
                            int ind = num_array.indexOf(n);
                            num_array.set(ind, 0);
                        }
                    }
                }catch (Exception e){
                    // Dodging the error when unneeded element is verified.
                    System.out.println("Dodged Index Error!");
                }

                try {
                    // Solves for rest of the given grid.
                    if (matrix[i][j] == 0 && isValidPlaced(matrix, get_arrayNum(num_array), i, j)) {

                        matrix[i][j] = get_arrayNum(num_array);
                        smartSolver(matrix);

                        int num = num_array.indexOf(matrix[i][j]);
                        num_array.set(num, 0);
                    }
                }catch (Exception e){
                    // Dodging the error when unneeded element is verified.
                    System.out.println("Dodged Index Error!");
                }

                System.out.println(Arrays.toString(num_array.toArray()));
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
        matrix = Board();
        if (solveBoard(matrix)) {
            System.out.println("====Solution-Board====");

            // Printing out solution-board:-
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("=======================");
        }
        else {
            System.out.println("No solution exists!");
        }
    }
}