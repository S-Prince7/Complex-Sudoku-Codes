package OfficialSudokuSolver;

import java.util.stream.IntStream;

public class Sudoku {

    // Represents consecutive progression
    private static int y = -1;
    // Represents doubling of element.
    private static int z = -2;

    //Storing the vals:-
    private static int point = 0;

    //Matrix representing the board:-
    public static int[][] matrix = new int[9][9];


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

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======================");

        return matrix;

    }

    //**
    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++)
        {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        //**
        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++)
        {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num)
            {
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }


    //This method to solve for sudoku:-
    public static boolean solveSudoku(
            int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    col = j;

                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // No empty space left
        if (isEmpty)
        {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(
            int[][] board, int N)
    {

        // We got the answer, just print it
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
      matrix = Board();

        System.out.println("==== Solution-Board ====");
        System.out.println("=======================");
      // Solving for board if the dimensions are valid:-
        int N = matrix.length;

        if (solveSudoku(matrix, N))
        {
            // print solution
            print(matrix, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}

/*
// Insuring all cells are filled:-
               if (board[row][col]==0) {
                   for (int numToTry = 1; numToTry <= matrix.length; numToTry++) {
                       if (isValidPlaced(board, numToTry, row, col)) {

                           // Putting in value.
                           board[row][col] = numToTry;

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


               if (board[8][1] != 0) {
                                if (board[8][1] + 1 == numToTry) {
                                    board[8][2] = board[8][1] + 1;
                                } else {
                                    board[8][2] = board[8][1] - 1;
                                }
                            }


                            if (board[0][6] != 0 && board[0][7] != 0) {
                                   if (board[0][6] > board[0][7]) {
                                       board[0][6] = board[0][7] + 1;
                                   } else if (board[0][7] > board[0][6]) {
                                       board[0][7] = board[0][6] + 1;
                                   }
                               }

                               //PROBLEM HERE:-
                               if (board[0][7] != 0 && board[0][8] != 0) {
                                   if (board[0][7] > board[0][8]) {
                                       board[0][7] = board[0][8] * 2;
                                   } else if (board[0][8] > board[0][7]) {
                                       board[0][8] = board[0][7] * 2;
                                   }
                               }
 */