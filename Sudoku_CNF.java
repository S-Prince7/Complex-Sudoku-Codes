package OfficialSudokuSolver;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Ilias
 */
public class Sudoku_CNF {

    static final int subN = 3;
    static final int N = subN*subN;
    static final int N2 = N*N;
    static final int VARS = N*N*N;
    static int clauses = 0;
    static ArrayList<String> DIMACS_CNF = new ArrayList();
    static int[] solution = {1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,18,-19,-20,-21,-22,-23,24,-25,-26,-27,-28,-29,-30,-31,32,-33,-34,-35,-36,-37,-38,-39,-40,-41,-42,43,-44,-45,-46,47,-48,-49,-50,-51,-52,-53,-54,-55,-56,-57,58,-59,-60,-61,-62,-63,-64,-65,-66,-67,-68,-69,-70,71,-72,-73,-74,75,-76,-77,-78,-79,-80,-81,-82,-83,-84,-85,-86,-87,-88,-89,90,-91,-92,93,-94,-95,-96,-97,-98,-99,-100,-101,-102,103,-104,-105,-106,-107,-108,109,-110,-111,-112,-113,-114,-115,-116,-117,-118,-119,-120,-121,-122,-123,-124,125,-126,-127,-128,-129,-130,131,-132,-133,-134,-135,-136,-137,-138,-139,-140,141,-142,-143,-144,-145,-146,-147,-148,-149,-150,151,-152,-153,-154,155,-156,-157,-158,-159,-160,-161,-162,-163,-164,165,-166,-167,-168,-169,-170,-171,-172,-173,-174,-175,-176,177,-178,-179,-180,-181,-182,-183,-184,-185,-186,-187,-188,189,-190,-191,-192,-193,-194,-195,-196,197,-198,199,-200,-201,-202,-203,-204,-205,-206,-207,-208,-209,-210,211,-212,-213,-214,-215,-216,-217,-218,-219,-220,221,-222,-223,-224,-225,-226,227,-228,-229,-230,-231,-232,-233,-234,-235,-236,-237,-238,-239,-240,241,-242,-243,-244,-245,-246,-247,-248,249,-250,-251,-252,253,-254,-255,-256,-257,-258,-259,-260,-261,-262,-263,-264,-265,-266,-267,-268,269,-270,-271,-272,-273,-274,-275,-276,277,-278,-279,-280,-281,-282,283,-284,-285,-286,-287,-288,-289,-290,291,-292,-293,-294,-295,-296,-297,-298,299,-300,-301,-302,-303,-304,-305,-306,-307,-308,-309,-310,311,-312,-313,-314,-315,-316,-317,-318,-319,-320,-321,-322,-323,324,-325,-326,-327,-328,329,-330,-331,-332,-333,-334,335,-336,-337,-338,-339,-340,-341,-342,-343,-344,-345,-346,-347,-348,349,-350,-351,-352,-353,-354,355,-356,-357,-358,-359,-360,-361,-362,-363,-364,-365,-366,-367,-368,369,370,-371,-372,-373,-374,-375,-376,-377,-378,-379,-380,381,-382,-383,-384,-385,-386,-387,-388,-389,-390,-391,-392,393,-394,-395,-396,-397,-398,-399,-400,-401,-402,-403,404,-405,-406,-407,-408,409,-410,-411,-412,-413,-414,-415,-416,-417,-418,-419,-420,421,-422,-423,-424,425,-426,-427,-428,-429,-430,-431,-432,-433,-434,435,-436,-437,-438,-439,-440,-441,-442,-443,-444,-445,446,-447,-448,-449,-450,-451,-452,-453,-454,-455,-456,-457,458,-459,460,-461,-462,-463,-464,-465,-466,-467,-468,-469,-470,-471,-472,-473,-474,-475,-476,477,-478,-479,-480,-481,-482,483,-484,-485,-486,-487,-488,-489,-490,-491,-492,-493,494,-495,-496,-497,-498,499,-500,-501,-502,-503,-504,-505,-506,507,-508,-509,-510,-511,-512,-513,-514,515,-516,-517,-518,-519,-520,-521,-522,-523,-524,-525,-526,-527,528,-529,-530,-531,-532,-533,-534,-535,-536,-537,-538,-539,540,-541,-542,-543,-544,-545,-546,547,-548,-549,550,-551,-552,-553,-554,-555,-556,-557,-558,-559,-560,-561,-562,563,-564,-565,-566,-567,-568,-569,-570,-571,-572,-573,574,-575,-576,-577,-578,-579,-580,581,-582,-583,-584,-585,586,-587,-588,-589,-590,-591,-592,-593,-594,-595,-596,-597,-598,-599,-600,-601,-602,603,-604,605,-606,-607,-608,-609,-610,-611,-612,-613,-614,-615,-616,-617,618,-619,-620,-621,-622,-623,-624,-625,-626,-627,-628,629,-630,-631,-632,633,-634,-635,-636,-637,-638,-639,-640,-641,-642,643,-644,-645,-646,-647,-648,-649,650,-651,-652,-653,-654,-655,-656,-657,-658,-659,-660,-661,-662,-663,-664,665,-666,-667,-668,-669,-670,671,-672,-673,-674,-675,-676,-677,-678,-679,-680,681,-682,-683,-684,-685,-686,687,-688,-689,-690,-691,-692,-693,-694,-695,-696,-697,-698,-699,700,-701,-702,-703,-704,-705,-706,-707,-708,-709,-710,711,-712,-713,-714,715,-716,-717,-718,-719,-720,721,-722,-723,-724,-725,-726,-727,-728,-729,0};

    /**
     * Generate DIMACS CNF format and print any given SAT solution
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        // Generate DIMACS CNF format 
        addFacts();
        atLeastOneDigitInCell();
        eachDigitAtMostOnesInRow();
        eachDigitAtMostOnesInColumn();
        eachDigitAtMostOnesInSubGrid();
        print_DIMACS_CNF_format();
        
        // Print a SAT solution        
        printSATSolutionBoard(solution);
    }    
        
    /**
     * 
     * @param digit [1...N]
     * @param row [1...N]
     * @param column [1...N]
     * @return 
     */
    private static int toVariable(int digit, int row, int column){
        return (N2*(digit-1) + N*(row-1) + (column-1) + 1);
    }


    //ADDING FACTS, SPECIFYING WHERE THE DOTS ARE SUPPOSED TO BE PRESENT IN SUDOKU BOARD.
    private static void addFacts(){        
        // Facts
        DIMACS_CNF.add("c Pre-assigned entries");
        // Update the number of facts according to the number of added DIMACS CNF clauses
        int facts=1;
        //DIMACS_CNF.add(toVariable(1, 1, 1) + " 0");
        DIMACS_CNF.add(toVariable(8, 5, 2) + " 0");

        //ADDING CIRCLE FACTS:-

        //White Row:-
        addWhiteCircleRowFacts(0,4,5);
        addWhiteCircleRowFacts(0,6,7);
        addWhiteCircleRowFacts(1,0,1);
        addWhiteCircleRowFacts(1,3,4);
        addWhiteCircleRowFacts(2,1,2);
        addWhiteCircleRowFacts(2,7,8);
        addWhiteCircleRowFacts(3,6,7);
        addWhiteCircleRowFacts(4,1,2);
        addWhiteCircleRowFacts(4,4,5);
        addWhiteCircleRowFacts(4,7,8);
        addWhiteCircleRowFacts(5,2,3);
        addWhiteCircleRowFacts(5,3,4);
        addWhiteCircleRowFacts(5,5,6);
        addWhiteCircleRowFacts(5,7,8);
        addWhiteCircleRowFacts(6,4,5);
        addWhiteCircleRowFacts(7,2,3);
        addWhiteCircleRowFacts(7,4,5);
        addWhiteCircleRowFacts(7,6,7);
        addWhiteCircleRowFacts(8,1,2);

        //White column:-
        addWhiteCircleColFacts(8,0,1);
        addWhiteCircleColFacts(1,1,2);
        addWhiteCircleColFacts(4,1,2);
        addWhiteCircleColFacts(7,2,3);
        addWhiteCircleColFacts(8,2,3);
        addWhiteCircleColFacts(1,3,4);
        addWhiteCircleColFacts(3,3,4);
        addWhiteCircleColFacts(7,3,4);
        addWhiteCircleColFacts(5,4,5);
        addWhiteCircleColFacts(4,5,6);
        addWhiteCircleColFacts(1,6,7);
        addWhiteCircleColFacts(1,7,8);
        addWhiteCircleColFacts(3,7,8);
        addWhiteCircleColFacts(5,7,8);
        addWhiteCircleColFacts(6,7,8);

        // Black Row:-
        addBlackCircleRowFacts(0,1,2);
        addBlackCircleRowFacts(0,3,4);
        addBlackCircleRowFacts(0,7,8);
        addBlackCircleColFacts(2,5,6);
        addBlackCircleColFacts(3,4,5);
        addBlackCircleColFacts(4,0,1);
        addBlackCircleRowFacts(5,0,1);
        addBlackCircleColFacts(6,3,4);

        //Black Column:-
        addBlackCircleColFacts(2,1,2);
        addBlackCircleColFacts(5,1,2);
        addBlackCircleColFacts(8,1,2);
        addBlackCircleColFacts(0,2,3);
        addBlackCircleColFacts(0,4,5);
        addBlackCircleColFacts(3,5,6);


        clauses += facts; 
    }

    //GENERATING CNF FOR EACH NEW ADDED FACTS THROUGH EVERY ROW AND COLUMN THROUGH WHITE AND BLACK CIRCLES.
    private static void addWhiteCircleRowFacts(int row, int col1, int col2){
        DIMACS_CNF.add("c white circle clauses for row: "+row +" cols: "+col1 +":"+col2);
        for (int digit = 1; digit <= N; digit++) {
            for (int digit2 = 1; digit2 <= N; digit2++) {
                if(digit==digit2 || Math.abs(digit-digit2)==1) continue;
                DIMACS_CNF.add("-" + toVariable(digit, row, col1) + " -" + toVariable(digit2, row, col2) + " 0");
                clauses++;
            }
        }
    }
    private static void addBlackCircleRowFacts(int row, int col1, int col2){
        DIMACS_CNF.add("c Black circle clauses for row: "+row +" cols: "+col1 +":"+col2);
        for (int digit = 1; digit <= N; digit++) {
            for (int digit2 = 1; digit2 <= N; digit2++) {
                if(digit==digit2 || digit==digit2*2 || digit2==digit*2) continue;
                DIMACS_CNF.add("-" + toVariable(digit, row, col1) + " -" + toVariable(digit2, row, col2) + " 0");
                clauses++;
            }
        }
    }
    private static void addWhiteCircleColFacts(int col, int row1, int row2){
        DIMACS_CNF.add("c white circle clauses for col: "+col +" rows: "+row1 +":"+row2);
        for (int digit = 1; digit <= N; digit++) {
            for (int digit2 = 1; digit2 <= N; digit2++) {
                if(digit==digit2 || Math.abs(digit-digit2)==1) continue;
                DIMACS_CNF.add("-" + toVariable(digit, row1, col) + " -" + toVariable(digit2, row2, col) + " 0");
                clauses++;
            }
        }
    }
    private static void addBlackCircleColFacts(int col, int row1, int row2){
        DIMACS_CNF.add("c Black circle clauses for col: "+col +" rows: "+row1 +":"+row2);
        for (int digit = 1; digit <= N; digit++) {
            for (int digit2 = 1; digit2 <= N; digit2++) {
                if(digit==digit2 || digit==digit2*2 || digit2==digit*2) continue;
                DIMACS_CNF.add("-" + toVariable(digit, row1, col) + " -" + toVariable(digit2, row2, col) + " 0");
                clauses++;
            }
        }
    }

    // VERIFYING FOR UNIQUE DIGIT PRESENCE IN EACH CELLS:-
    private static void atLeastOneDigitInCell(){        
        // Every cell contains at least one digit
        DIMACS_CNF.add("c Every cell contains at least one digit:");
        String str;
        for (int row = 1; row <= N; row++) {
            for (int column = 1; column <= N; column++) {
                str = "";
                for (int digit = 1; digit <= N; digit++) {
                    str += toVariable(digit,row,column) + " ";
                }
                DIMACS_CNF.add(str + "0");
                clauses++;
            }
        }
    }

    private static void eachDigitAtMostOnesInRow(){        
        // Each digit appears at most once in each row
        //todo
        DIMACS_CNF.add("c Each digit appears at most once in each row:");
        for (int digit = 1; digit <= N; digit++) {
            for (int row = 1; row < N; row++) {
                for (int columnLow = 1; columnLow <= N-1; columnLow++) {
                    for (int columnHigh = columnLow+1; columnHigh <= N; columnHigh++) {
                        DIMACS_CNF.add("-" + toVariable(digit,row,columnLow) + " -" + toVariable(digit,row,columnHigh) + " 0");
                        clauses++;
                    }
                }
            }
        }
    }
    
    private static void eachDigitAtMostOnesInColumn(){
        // Each number appears at most once in each column
//        todo
        DIMACS_CNF.add("c Each number appears at most once in each column:");
        for (int digit = 1; digit <= N; digit++) {
            for (int column = 1; column <= N; column++) {
                for (int rowLow = 1; rowLow <= N-1; rowLow++) {
                    for (int rowHigh = rowLow+1; rowHigh <= N; rowHigh++) {
                        DIMACS_CNF.add("-" + toVariable(digit,rowLow,column) + " -" + toVariable(digit,rowHigh,column) + " 0");
                        clauses++;
                    }
                }
            }
        }
    }
    
    private static void eachDigitAtMostOnesInSubGrid(){
        // Each number appears at most once in each sub-grid
        DIMACS_CNF.add("c Each number appears at most once in each sub-grid:");        
        for(int digit = 1; digit<=N; digit++){
            for(int subGridRow = 0; subGridRow <= subN-1; subGridRow++){
                for(int subRowLow = 1; subRowLow <= subN-1; subRowLow++){                    
                    for(int columnSubGrid = 0; columnSubGrid <= subN-1; columnSubGrid++){
                        for(int subColumnLow = 1; subColumnLow <=subN; subColumnLow++){                          
                            for(int subRowHigh = subRowLow+1; subRowHigh <=subN; subRowHigh++){
                                for(int subColumHigh = 1; subColumHigh <= subN; subColumHigh++){
                                    if(subColumnLow != subColumHigh){
                                        DIMACS_CNF.add("-" + toVariable(digit,(subN*subGridRow + subRowLow),(subN*columnSubGrid + subColumnLow)) + 
                                                " -" + toVariable(digit,(subN*subGridRow + subRowHigh),(subN*columnSubGrid + subColumHigh)) + " 0");
                                        clauses++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Print DIMACS CNF format 
     * @param variables 
     */
    private static void print_DIMACS_CNF_format(){
        // Print DIMACS CNF format 
        System.out.println("==========================================");
        System.out.println("===== Beginning of DIMACS CNF format =====");
        System.out.println("==========================================");
        System.out.println("c digit range [1..." + N + "]");
        System.out.println("c row range: [1..." + N + "]");
        System.out.println("c column range: [1..." + N + "]");
        System.out.println("c board[digit][row][column]: variable");
        for (int digit = 1; digit <= N; digit++) {
            for (int row = 1; row <= N; row++) {
                for (int column = 1; column <= N; column++) {
                    System.out.println("c board[" + digit + "][" + row + "][" + column + "]: " + toVariable(digit,row,column));                    
                }
            }
        }
        System.out.println("c #vars: " + VARS);
        System.out.println("c #clauses: " + clauses);
        System.out.println("p cnf " + VARS + " " + clauses);
        for (int i = 0; i < DIMACS_CNF.size(); i++) {
            System.out.println(DIMACS_CNF.get(i));            
        }
        System.out.println("====================================");
        System.out.println("===== End of DIMACS CNF format =====");
        System.out.println("====================================");
        System.out.println("");
    }
    
    /**
     * Print resulting board based on a set of variables from a SAT solution
     * @param variables 
     */
    private static void printSATSolutionBoard(int[] variables){
        int digit;
        int tmp;
        int row;
        int column;             
        
        int[][] tmpBoard = new int [N][N];
        for (row = 0; row < N; row++) {
            for (column = 0; column < N; column++) {
                tmpBoard[row][column] = -1;
            }
        }
        for (int i = 0; i < variables.length; i++) {
            if(variables[i] > 0){
                digit = (variables[i]-1)/N2;
                tmp = (variables[i]-1)%N2;
                row = tmp/N;
                column = tmp%N;
                tmpBoard[row][column] = digit;
            }
        }
        
        System.out.println("=======================");
        System.out.println("===== Given board =====");
        System.out.println("=======================");
        for (row = 0; row < N; row++) {
            System.out.print("   ");
            for (column = 0; column < N; column++) {
                System.out.print(((tmpBoard[row][column])>=0? (tmpBoard[row][column]+1):"-") + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
}
