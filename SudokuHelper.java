package OfficialSudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuHelper {

    //Matrix representing the board:-
    public static int[][] matrix = new int[9][9];

    //Arraylist:-
    private static ArrayList<Integer> SudokuList = new ArrayList<>();




    private static boolean Board(){

        matrix = new int [][] {
                {0,6,0},
                {0,8,0},
                {0,0,0}

        };

        for(int row = 0; row< matrix.length;row++){
            for(int col=0;col< matrix.length;col++){


                if(matrix[row][col]==0) {
                    for (int i = 1; i <= 9; i++) {

                        //GRID3:-
                        if (isValidPlaced(matrix, i, row, col)) {
                            if (row == 0 && col == 3 && matrix[0][4]!=0 && i == matrix[0][4] *2 || i == matrix[0][4] /2 && isValidPlaced(matrix, i, 0, 3)) {
                                matrix[0][3] = i;
                            }

                        }
                    }
                }
            }

        }
        return true;
    }







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


    public static void main(String[] args) {
        //matrix = AIBoard();
        if (Board()) {
            System.out.println("====Solution-Board====");
            System.out.println("===============");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(Arrays.toString(SudokuList.toArray()));
        }

        else{
            System.out.println("No solution exists!");
        }
    }
}
