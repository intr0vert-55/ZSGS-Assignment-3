import java.util.Scanner;
public class TicTacToe{

    static int x = 0, o = 0;
    public static void main(String [] args){
        char [][] board1 = {
            {'x', 'x', 'o'},
            {'o', 'o', 'x'},
            {'-', '-', 'x'}
        };
        char [][] board2 = {
            {'x', 'x', 'x'},
            {'o', 'o', 'x'},
            {'-', '-', 'o'}
        };
        char [][] board3 = {
            {'x', 'x', 'o'},
            {'o', 'o', 'x'},
            {'o', '-', 'x'}
        };
        char [][] board4 = {
            {'x', 'x', 'o'},
            {'o', 'o', 'x'},
            {'x', 'o', 'x'}
        };
        char [][] board5 = {
            {'x', 'x', 'o'},
            {'o', '-', 'x'},
            {'x', 'o', 'x'}
        };

        System.out.println(stateOfTicTacToe(board1));   // Ongoing game
        System.out.println(stateOfTicTacToe(board2));   // X won
        System.out.println(stateOfTicTacToe(board3));   // O won
        System.out.println(stateOfTicTacToe(board4));   // Game draw
        System.out.println(stateOfTicTacToe(board5));   // Invalid board since x has made more moves 
        // System.out.println(stateOfTicTacToe(userInitializedBoard()));    
        // Wrote a method in the end to get input from the user and convert it into a 2D char array representing tic tac toe game
    }

    public static String stateOfTicTacToe(char [][] board){
        if(!isValid(board)) return "Invalid board";
        if(didXWin(board) && didOWin(board))    return "Game played after winning";
        if(didXWin(board))  return "X won";
        if(didOWin(board))  return "O won";
        if(isDraw())    return "Game Draw";
        return "Ongoing game";
    }

    public static boolean isValid(char [][] board){
        x = 0; 
        o = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 'x')  x++;
                else if(board[i][j] == 'o') o++;
                else if(board[i][j] != '-')   return false;
            }
        }
        return x - o == 0 || x - o == 1;  // Since x starts first, the count of x should be equal to or 1 larger than o.
    }

    public static boolean didXWin(char [][] board){
        boolean result = false;
        for(int i = 0; i < 3; i++){
            result |= xAxis(board, i, 'x') | (yAxis(board, i, 'x'));
        }
        result |= crossChecks(board, 'x');
        return result;
    }

    public static boolean didOWin(char [][] board){
        boolean result = false;
        for(int i = 0; i < 3; i++){
            result |= xAxis(board, i, 'o') | (yAxis(board, i, 'o'));
        }
        result |= crossChecks(board, 'o');
        return result;
    }

    public static boolean yAxis(char [][] board, int j, char ch){
        for(int i = 0; i < 3; i++){
            if(board[i][j] != ch)   return false;
        }
        return true;
    }

    public static boolean xAxis(char [][] board, int i, char ch){
        for(int j = 0; j < 3; j++){
            if(board[i][j] != ch)   return false;
        }
        return true;
    }

    public static boolean crossChecks(char [][] board, char ch){
        boolean flag = true;
        for(int i = 0; i < 3; i++){
            if(board[i][i] != ch){   
                flag = false;
                break;
            }
        }
        if(flag)    return flag;
        flag = true;
        for(int i = 0; i < 3; i++){
            if(board[i][2 - i] != ch){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isDraw(){
        return x + o == 9;
    }

    public static char [][] userInitializedBoard(){
        Scanner s = new Scanner(System.in);
        System.out.println("Rules : ");
        System.out.println("1. Enter the values of the board row by row with x representing player1 and o representing player2.");
        System.out.println("2. Leave a space between every values.");
        System.out.println("3. For the positions that are not filled indicate it using '-'.");
        System.out.println("Example Board : ");
        System.out.println("x o x");
        System.out.println("o - x");
        System.out.println("o x o");
        System.out.println("Enter your board");
        String row1 = s.nextLine();
        String row2 = s.nextLine();
        String row3 = s.nextLine();
        char [][] board = new char[3][3];
        board [0] = stringToRow(row1);
        board [1] = stringToRow(row2);
        board [2] = stringToRow(row3);
        return board;
    }

    public static char [] stringToRow(String s){
        String [] arr = s.split(" ");
        int len = arr.length;
        if(len > 3) len = 3;
        char [] row = new char [3];
        for(int i = 0; i < len; i++){
            row[i] = arr[i].charAt(0);
        }
        for(int i = len; i < 3; i++){
            row[i] = '-';
        }
        return row;
    }
}